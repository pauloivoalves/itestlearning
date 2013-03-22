package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.FerramentaDao;
import br.ufc.si.itest.dao.impl.FerramentaDaoImpl;
import br.ufc.si.itest.model.Ferramenta;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.utils.Utils;

public class FerramentaBean {
	/* Model */
	private Ferramenta ferramenta = new Ferramenta();
	
	/* DAOs */
	private FerramentaDao ferramentaDao;

	/* Propriedades auxiliares */
	private List<SelectItem> ferramentas;
	private List<FerramentaProjeto> ferramentasProjeto;
	private List<String> ferramentasSelecionadas;
	private List<FerramentaProjeto> respostas;
	private List<FerramentaProjeto> respostasCorretas;
	private List<FerramentaProjeto> respostasErradas;
	private Boolean respondido;

	/* Construtor */
	public FerramentaBean() {
		ferramenta = new Ferramenta();
		ferramentaDao = new FerramentaDaoImpl();
		ferramentas = new ArrayList<SelectItem>();
		ferramentasProjeto = new ArrayList<FerramentaProjeto>();
		ferramentasSelecionadas = new ArrayList<String>();
		respostas = new ArrayList<FerramentaProjeto>();
		respostasCorretas = new ArrayList<FerramentaProjeto>();
		respostasErradas = new ArrayList<FerramentaProjeto>();
		respondido = false;
	}
	
	public String criarFerramenta(){
		ferramentaDao.save(ferramenta);
		
		return "criado";
		
	}

	/* Métodos Auxiliares */
	public Integer validaResposta(int nivelDificuldade) {
		Integer pontuacao = 0;
		for (FerramentaProjeto fp : ferramentasProjeto) {
			if (fp.getResposta()) {
				respostasCorretas.add(fp);
			} else {
				respostasErradas.add(fp);
			}
		}
		for (String i : ferramentasSelecionadas) {
			FerramentaProjeto fp = getFerramentaById(new Integer(i));
			respostas.add(fp);
			if (respostasCorretas.contains(fp)) {
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

	public FerramentaProjeto getFerramentaById(Integer id) {
		for (FerramentaProjeto fp : ferramentasProjeto) {
			if (fp.getPk().getFerramenta().getId().equals(id)) {
				return fp;
			}
		}
		return null;
	}

	/* Getters e Setters */
	public FerramentaDao getFerramentaDao() {
		return ferramentaDao;
	}

	public void setFerramentaDao(FerramentaDao ferramentaDao) {
		this.ferramentaDao = ferramentaDao;
	}

	public List<SelectItem> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<SelectItem> ferramentas) {
		this.ferramentas = ferramentas;
	}

	public List<FerramentaProjeto> getFerramentasProjeto() {
		return ferramentasProjeto;
	}

	public void setFerramentasProjeto(List<FerramentaProjeto> ferramentasProjeto) {
		this.ferramentasProjeto = ferramentasProjeto;
	}

	public List<String> getFerramentasSelecionadas() {
		return ferramentasSelecionadas;
	}

	public void setFerramentasSelecionadas(List<String> ferramentasSelecionadas) {
		this.ferramentasSelecionadas = ferramentasSelecionadas;
	}

	public List<FerramentaProjeto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<FerramentaProjeto> respostas) {
		this.respostas = respostas;
	}

	public List<FerramentaProjeto> getRespostasCorretas() {
		return respostasCorretas;
	}

	public void setRespostasCorretas(List<FerramentaProjeto> respostasCorretas) {
		this.respostasCorretas = respostasCorretas;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	public List<FerramentaProjeto> getRespostasErradas() {
		return respostasErradas;
	}

	public void setRespostasErradas(List<FerramentaProjeto> respostasErradas) {
		this.respostasErradas = respostasErradas;
	}

	public Ferramenta getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}
	
	

}
