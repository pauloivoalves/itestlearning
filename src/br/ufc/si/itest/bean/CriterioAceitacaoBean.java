package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.CriterioAceitacaoDao;
import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.impl.CriterioAceitacaoDaoImpl;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.model.CriterioAceitacao;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.utils.Utils;

public class CriterioAceitacaoBean {
	/* Model */
	private CriterioAceitacao criterioAceitacao;
	private Projeto projeto;

	/* DAOs */
	private CriterioAceitacaoDao criterioAceitacaoDao;

	/* Propriedades auxiliares */
	private int idProjeto;
	private List<SelectItem> listProjetos;
	private List<Projeto> projetos;
	private ProjetoDaoImpl projetoDao;
	private List<SelectItem> criteriosAceitacao;
	private List<CriterioAceitacao> criteriosAceitacaoProjeto;
	private List<String> criteriosAceitacaoSelecionados;
	private List<CriterioAceitacao> respostas;
	private List<CriterioAceitacao> respostasCorretas;
	private List<CriterioAceitacao> respostasErradas;
	private Boolean respondido;

	/* Construtor */
	public CriterioAceitacaoBean() {
		projetoDao = new ProjetoDaoImpl();
		listProjetos = new ArrayList<SelectItem>();
		projetos = new ArrayList<Projeto>();
		criterioAceitacao = new CriterioAceitacao();
		criterioAceitacaoDao = new CriterioAceitacaoDaoImpl();
		criteriosAceitacao = new ArrayList<SelectItem>();
		criteriosAceitacaoProjeto = new ArrayList<CriterioAceitacao>();
		criteriosAceitacaoSelecionados = new ArrayList<String>();
		respostas = new ArrayList<CriterioAceitacao>();
		respostasCorretas = new ArrayList<CriterioAceitacao>();
		respostasErradas = new ArrayList<CriterioAceitacao>();
		respondido = false;

		projetos = projetoDao.list();
		for (Projeto p : projetos) {
			listProjetos.add(new SelectItem(p.getId(), p.getNome()));
		}
	}

	public String criarCriterioAceitacao() {
		projeto = projetoDao.getProjetoById(idProjeto);
		criterioAceitacao.setProjeto(projeto);
		criterioAceitacaoDao.save(criterioAceitacao);
		return "criado";
	}

	/* Métodos Auxiliares */
	public Integer validaResposta(int nivelDificuldade) {
		Integer pontuacao = 0;
		for (CriterioAceitacao ca : criteriosAceitacaoProjeto) {
			if (ca.getResposta()) {
				respostasCorretas.add(ca);
			} else {
				respostasErradas.add(ca);
			}
		}
		for (String i : criteriosAceitacaoSelecionados) {
			CriterioAceitacao ca = getCriterioAceitacaoById(new Integer(i));
			respostas.add(ca);
			if (respostasCorretas.contains(ca)) {
				if (nivelDificuldade == 1) {
					pontuacao = pontuacao + Utils.PONTO_POSITIVO;
				}

				if (nivelDificuldade == 2) {
					pontuacao = pontuacao + Utils.PONTO_POSITIVO_MEDIO;
				}

				if (nivelDificuldade == 3) {
					pontuacao = pontuacao + Utils.PONTO_POSITIVO_DIFICIL;
				}

			} else {
				if (nivelDificuldade == 1) {
					pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
				}

				if (nivelDificuldade == 2) {
					pontuacao = pontuacao + Utils.PONTO_NEGATIVO_MEDIO;
				}

				if (nivelDificuldade == 3) {
					pontuacao = pontuacao + Utils.PONTO_NEGATIVO_DIFICIL;
				}

			}
		}
		for (CriterioAceitacao ca : respostasCorretas) {
			if (!respostas.contains(ca)) {
				if (nivelDificuldade == 1) {
					pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
				}

				if (nivelDificuldade == 2) {
					pontuacao = pontuacao + Utils.PONTO_NEGATIVO_MEDIO;
				}

				if (nivelDificuldade == 3) {
					pontuacao = pontuacao + Utils.PONTO_NEGATIVO_DIFICIL;
				}

			}
		}

		respondido = true;
		return pontuacao;
	}

	public CriterioAceitacao getCriterioAceitacaoById(Integer id) {
		for (CriterioAceitacao ca : criteriosAceitacaoProjeto) {
			if (ca.getId().equals(id)) {
				return ca;
			}
		}
		return null;
	}

	/* Getters e Setters */
	public CriterioAceitacaoDao getCriterioAceitacaoDao() {
		return criterioAceitacaoDao;
	}

	public void setCriterioAceitacaoDao(
			CriterioAceitacaoDao criterioAceitacaoDao) {
		this.criterioAceitacaoDao = criterioAceitacaoDao;
	}

	public List<SelectItem> getCriteriosAceitacao() {
		return criteriosAceitacao;
	}

	public void setCriteriosAceitacao(List<SelectItem> criteriosAceitacao) {
		this.criteriosAceitacao = criteriosAceitacao;
	}

	public List<CriterioAceitacao> getCriteriosAceitacaoProjeto() {
		return criteriosAceitacaoProjeto;
	}

	public void setCriteriosAceitacaoProjeto(
			List<CriterioAceitacao> criteriosAceitacaoProjeto) {
		this.criteriosAceitacaoProjeto = criteriosAceitacaoProjeto;
	}

	public List<String> getCriteriosAceitacaoSelecionados() {
		return criteriosAceitacaoSelecionados;
	}

	public void setCriteriosAceitacaoSelecionados(
			List<String> criteriosAceitacaoSelecionados) {
		this.criteriosAceitacaoSelecionados = criteriosAceitacaoSelecionados;
	}

	public List<CriterioAceitacao> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<CriterioAceitacao> respostas) {
		this.respostas = respostas;
	}

	public List<CriterioAceitacao> getRespostasCorretas() {
		return respostasCorretas;
	}

	public void setRespostasCorretas(List<CriterioAceitacao> respostasCorretas) {
		this.respostasCorretas = respostasCorretas;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	public List<CriterioAceitacao> getRespostasErradas() {
		return respostasErradas;
	}

	public void setRespostasErradas(List<CriterioAceitacao> respostasErradas) {
		this.respostasErradas = respostasErradas;
	}

	public CriterioAceitacao getCriterioAceitacao() {
		return criterioAceitacao;
	}

	public void setCriterioAceitacao(CriterioAceitacao criterioAceitacao) {
		this.criterioAceitacao = criterioAceitacao;
	}

	public int getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}

	public List<SelectItem> getListProjetos() {
		return listProjetos;
	}

	public void setListProjetos(List<SelectItem> listProjetos) {
		this.listProjetos = listProjetos;
	}

}
