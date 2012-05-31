package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.ArtefatoDao;
import br.ufc.si.itest.dao.impl.ArtefatoDaoImpl;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.utils.Utils;

public class ArtefatoBean {
	/* DAOs */
	private ArtefatoDao artefatoDao;
	
	/* Propriedades auxiliares */
	private List<SelectItem> artefatos;
	private List<ArtefatoProjeto> artefatosProjeto;
	private List<String> artefatosSelecionados;
	private List<ArtefatoProjeto> respostas;
	private List<ArtefatoProjeto> respostasCorretas;
	private List<ArtefatoProjeto> respostasErradas;
	private Boolean respondido;
	
	/* Construtor */
	public ArtefatoBean() {
		artefatoDao = new ArtefatoDaoImpl();
		artefatos = new ArrayList<SelectItem>();
		artefatosProjeto = new ArrayList<ArtefatoProjeto>();
		artefatosSelecionados = new ArrayList<String>();
		respostas = new ArrayList<ArtefatoProjeto>();
		respostasCorretas = new ArrayList<ArtefatoProjeto>();
		respostasErradas = new ArrayList<ArtefatoProjeto>();
		respondido = false;
	}
	
	/* Métodos Auxiliares */
	public Integer validaResposta() {
		Integer pontuacao = 0;
		for (ArtefatoProjeto ap : artefatosProjeto) {
			if (ap.getResposta()) {
				respostasCorretas.add(ap);
			}
			else {
				respostasErradas.add(ap);
			}
		}
		for (String i : artefatosSelecionados) {
			ArtefatoProjeto ap = getArtefatoById(new Integer(i));
			respostas.add(ap);
			if(respostasCorretas.contains(ap)) {
				pontuacao = pontuacao + Utils.PONTO_POSITIVO;
			}
			else {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}
		for(ArtefatoProjeto ap : respostasCorretas) {
			if(!respostas.contains(ap)) {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}
		
		respondido = true;
		return pontuacao;
	}

	public ArtefatoProjeto getArtefatoById(Integer id) {
		for (ArtefatoProjeto ap : artefatosProjeto) {
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

	public List<ArtefatoProjeto> getArtefatosProjeto() {
		return artefatosProjeto;
	}

	public void setArtefatosProjeto(List<ArtefatoProjeto> artefatosProjeto) {
		this.artefatosProjeto = artefatosProjeto;
	}

	public List<String> getArtefatosSelecionados() {
		return artefatosSelecionados;
	}

	public void setArtefatosSelecionados(List<String> artefatosSelecionados) {
		this.artefatosSelecionados = artefatosSelecionados;
	}

	public List<ArtefatoProjeto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<ArtefatoProjeto> respostas) {
		this.respostas = respostas;
	}

	public List<ArtefatoProjeto> getRespostasCorretas() {
		return respostasCorretas;
	}

	public void setRespostasCorretas(List<ArtefatoProjeto> respostasCorretas) {
		this.respostasCorretas = respostasCorretas;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	public List<ArtefatoProjeto> getRespostasErradas() {
		return respostasErradas;
	}

	public void setRespostasErradas(List<ArtefatoProjeto> respostasErradas) {
		this.respostasErradas = respostasErradas;
	}

}
