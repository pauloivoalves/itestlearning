package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.TipoTesteDao;
import br.ufc.si.itest.dao.impl.TipoTesteDaoImpl;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.utils.Utils;

public class TipoTesteBean {
	/* DAOs */
	private TipoTesteDao tipoTesteDao;
	
	/* Propriedades auxiliares */
	private List<SelectItem> tiposTeste;
	private List<TipoTesteProjeto> tiposTesteProjeto;
	private List<String> tiposTesteSelecionados;
	private List<TipoTesteProjeto> respostas;
	private List<TipoTesteProjeto> respostasCorretas;
	private List<TipoTesteProjeto> respostasErradas;
	private Boolean respondido;
	
	/* Construtor */
	public TipoTesteBean() {
		tipoTesteDao = new TipoTesteDaoImpl();
		tiposTeste = new ArrayList<SelectItem>();
		tiposTesteProjeto = new ArrayList<TipoTesteProjeto>();
		tiposTesteSelecionados = new ArrayList<String>();
		respostas = new ArrayList<TipoTesteProjeto>();
		respostasCorretas = new ArrayList<TipoTesteProjeto>();
		respostasErradas = new ArrayList<TipoTesteProjeto>();
		respondido = false;
	}
	
	/* Métodos Auxiliares */
	public Integer validaResposta() {
		Integer pontuacao = 0;
		for (TipoTesteProjeto tt : tiposTesteProjeto) {
			if (tt.getResposta()) {
				respostasCorretas.add(tt);
			}
			else {
				respostasErradas.add(tt);
			}
		}
		for (String i : tiposTesteSelecionados) {
			TipoTesteProjeto tt = getTipoTesteById(new Integer(i));
			respostas.add(tt);
			if(respostasCorretas.contains(tt)) {
				pontuacao = pontuacao + Utils.PONTO_POSITIVO;
			}
			else {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}
		for(TipoTesteProjeto ca : respostasCorretas) {
			if(!respostas.contains(ca)) {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}
		
		respondido = true;
		return pontuacao;
	}

	public TipoTesteProjeto getTipoTesteById(Integer id) {
		for (TipoTesteProjeto tt : tiposTesteProjeto) {
			if (tt.getPk().getTipoTeste().getId().equals(id)) {
				return tt;
			}
		}
		return null;
	}

	/* Getters e Setters*/
	public TipoTesteDao getTipoTesteDao() {
		return tipoTesteDao;
	}

	public void setTipoTesteDao(TipoTesteDao tipoTesteDao) {
		this.tipoTesteDao = tipoTesteDao;
	}

	public List<SelectItem> getTiposTeste() {
		return tiposTeste;
	}

	public void setTiposTeste(List<SelectItem> tiposTeste) {
		this.tiposTeste = tiposTeste;
	}

	public List<TipoTesteProjeto> getTiposTesteProjeto() {
		return tiposTesteProjeto;
	}

	public void setTiposTesteProjeto(List<TipoTesteProjeto> tiposTesteProjeto) {
		this.tiposTesteProjeto = tiposTesteProjeto;
	}

	public List<String> getTiposTesteSelecionados() {
		return tiposTesteSelecionados;
	}

	public void setTiposTesteSelecionados(List<String> tiposTesteSelecionados) {
		this.tiposTesteSelecionados = tiposTesteSelecionados;
	}

	public List<TipoTesteProjeto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<TipoTesteProjeto> respostas) {
		this.respostas = respostas;
	}

	public List<TipoTesteProjeto> getRespostasCorretas() {
		return respostasCorretas;
	}

	public void setRespostasCorretas(List<TipoTesteProjeto> respostasCorretas) {
		this.respostasCorretas = respostasCorretas;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	public List<TipoTesteProjeto> getRespostasErradas() {
		return respostasErradas;
	}

	public void setRespostasErradas(List<TipoTesteProjeto> respostasErradas) {
		this.respostasErradas = respostasErradas;
	}
	
}
