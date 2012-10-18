package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.ArtefatoDao;
import br.ufc.si.itest.dao.impl.ArtefatoDaoImpl;
import br.ufc.si.itest.model.caso;
import br.ufc.si.itest.utils.Utils;

public class ArtefatoBean {
	/* DAOs */
	private ArtefatoDao artefatoDao;
	
	/* Propriedades auxiliares */
	private List<SelectItem> artefatos;
	private List<caso> artefatosProjeto;
	private List<String> artefatosSelecionados;
	private List<caso> respostas;
	private List<caso> respostasCorretas;
	private List<caso> respostasErradas;
	private Boolean respondido;
	
	/* Construtor */
	public ArtefatoBean() {
		artefatoDao = new ArtefatoDaoImpl();
		artefatos = new ArrayList<SelectItem>();
		artefatosProjeto = new ArrayList<caso>();
		artefatosSelecionados = new ArrayList<String>();
		respostas = new ArrayList<caso>();
		respostasCorretas = new ArrayList<caso>();
		respostasErradas = new ArrayList<caso>();
		respondido = false;
	}
	
	/* M�todos Auxiliares */
	public Integer validaResposta() {
		Integer pontuacao = 0;
		for (caso ap : artefatosProjeto) {
			if (ap.getResposta()) {
				respostasCorretas.add(ap);
			}
			else {
				respostasErradas.add(ap);
			}
		}
		for (String i : artefatosSelecionados) {
			caso ap = getArtefatoById(new Integer(i));
			respostas.add(ap);
			if(respostasCorretas.contains(ap)) {
				pontuacao = pontuacao + Utils.PONTO_POSITIVO;
			}
			else {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}
		for(caso ap : respostasCorretas) {
			if(!respostas.contains(ap)) {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}
		
		respondido = true;
		return pontuacao;
	}

	public caso getArtefatoById(Integer id) {
		for (caso ap : artefatosProjeto) {
			if (ap.getPk().getArtefato().getId().equals(id)) {
				return ap;
			}
		}
		return null;
	}

	/* Getters e Setters*/
	public ArtefatoDao getArtefatoDao() {
		return artefatoDao;
	}

	public void setArtefatoDao(ArtefatoDao artefatoDao) {
		this.artefatoDao = artefatoDao;
	}

	public List<SelectItem> getArtefatos() {
		return artefatos;
	}

	public void setArtefatos(List<SelectItem> artefatos) {
		this.artefatos = artefatos;
	}

	public List<caso> getArtefatosProjeto() {
		return artefatosProjeto;
	}

	public void setArtefatosProjeto(List<caso> artefatosProjeto) {
		this.artefatosProjeto = artefatosProjeto;
	}

	public List<String> getArtefatosSelecionados() {
		return artefatosSelecionados;
	}

	public void setArtefatosSelecionados(List<String> artefatosSelecionados) {
		this.artefatosSelecionados = artefatosSelecionados;
	}

	public List<caso> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<caso> respostas) {
		this.respostas = respostas;
	}

	public List<caso> getRespostasCorretas() {
		return respostasCorretas;
	}

	public void setRespostasCorretas(List<caso> respostasCorretas) {
		this.respostasCorretas = respostasCorretas;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	public List<caso> getRespostasErradas() {
		return respostasErradas;
	}

	public void setRespostasErradas(List<caso> respostasErradas) {
		this.respostasErradas = respostasErradas;
	}

}
