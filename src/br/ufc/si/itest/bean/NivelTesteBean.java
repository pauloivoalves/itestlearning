package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.NivelTesteDao;
import br.ufc.si.itest.dao.impl.NivelTesteDaoImpl;
import br.ufc.si.itest.model.NivelTeste;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.utils.Utils;

public class NivelTesteBean {
	/* Model */
	private NivelTeste nivelTeste = new NivelTeste();
	
	/* DAOs */
	private NivelTesteDao nivelTesteDao;

	/* Propriedades auxiliares */
	private List<SelectItem> niveisTeste;
	private List<NivelTesteProjeto> niveisTesteProjeto;
	private List<String> niveisTesteSelecionados;
	private List<NivelTesteProjeto> respostas;
	private List<NivelTesteProjeto> respostasCorretas;
	private List<NivelTesteProjeto> respostasErradas;
	private Boolean respondido;

	/* Construtor */
	public NivelTesteBean() {
		nivelTeste = new NivelTeste();
		nivelTesteDao = new NivelTesteDaoImpl();
		niveisTeste = new ArrayList<SelectItem>();
		niveisTesteProjeto = new ArrayList<NivelTesteProjeto>();
		niveisTesteSelecionados = new ArrayList<String>();
		respostas = new ArrayList<NivelTesteProjeto>();
		respostasCorretas = new ArrayList<NivelTesteProjeto>();
		respostasErradas = new ArrayList<NivelTesteProjeto>();
		respondido = false;
	}
	
	public String criarNivelTeste(){
		nivelTesteDao.save(nivelTeste);
		return "criado";
	}

	/* Métodos Auxiliares */
	public Integer validaResposta(int nivelDificuldade) {
		Integer pontuacao = 0;
		for (NivelTesteProjeto nt : niveisTesteProjeto) {
			if (nt.getResposta()) {
				respostasCorretas.add(nt);
			} else {
				respostasErradas.add(nt);
			}
		}
		for (String i : niveisTesteSelecionados) {
			NivelTesteProjeto nt = getNivelTesteById(new Integer(i));
			respostas.add(nt);
			if (respostasCorretas.contains(nt)) {
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

		respondido = true;
		return pontuacao;
	}

	public NivelTesteProjeto getNivelTesteById(Integer id) {
		for (NivelTesteProjeto nt : niveisTesteProjeto) {
			if (nt.getPk().getNivelTeste().getId().equals(id)) {
				return nt;
			}
		}
		return null;
	}

	/* Getters e Setters */
	public NivelTesteDao getNivelTesteDao() {
		return nivelTesteDao;
	}

	public void setNivelTesteDao(NivelTesteDao nivelTesteDao) {
		this.nivelTesteDao = nivelTesteDao;
	}

	public List<SelectItem> getNiveisTeste() {
		return niveisTeste;
	}

	public void setNiveisTeste(List<SelectItem> niveisTeste) {
		this.niveisTeste = niveisTeste;
	}

	public List<NivelTesteProjeto> getNiveisTesteProjeto() {
		return niveisTesteProjeto;
	}

	public void setNiveisTesteProjeto(List<NivelTesteProjeto> niveisTesteProjeto) {
		this.niveisTesteProjeto = niveisTesteProjeto;
	}

	public List<String> getNiveisTesteSelecionados() {
		return niveisTesteSelecionados;
	}

	public void setNiveisTesteSelecionados(List<String> niveisTesteSelecionados) {
		this.niveisTesteSelecionados = niveisTesteSelecionados;
	}

	public List<NivelTesteProjeto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<NivelTesteProjeto> respostas) {
		this.respostas = respostas;
	}

	public List<NivelTesteProjeto> getRespostasCorretas() {
		return respostasCorretas;
	}

	public void setRespostasCorretas(List<NivelTesteProjeto> respostasCorretas) {
		this.respostasCorretas = respostasCorretas;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	public List<NivelTesteProjeto> getRespostasErradas() {
		return respostasErradas;
	}

	public void setRespostasErradas(List<NivelTesteProjeto> respostasErradas) {
		this.respostasErradas = respostasErradas;
	}

	public NivelTeste getNivelTeste() {
		return nivelTeste;
	}

	public void setNivelTeste(NivelTeste nivelTeste) {
		this.nivelTeste = nivelTeste;
	}
	
	

}
