package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.CasoDeTesteDao;
import br.ufc.si.itest.dao.impl.CasoDeTesteDaoImpl;
import br.ufc.si.itest.model.CasoDeTeste;
import br.ufc.si.itest.utils.Utils;

public class CasoDeTesteBean {

	/* DAOs */
	private CasoDeTesteDao casoDeTesteDao;

	/* Propriedades auxiliares */
	private List<SelectItem> casosDeTeste;
	private List<CasoDeTeste> casosDeTesteProjeto;
	private List<String> casoDeTesteSelecionados;
	private List<CasoDeTeste> respostas;
	private List<CasoDeTeste> respostasCorretas;
	private List<CasoDeTeste> respostasErradas;
	private Boolean respondido;

	/* Construtor */
	public CasoDeTesteBean() {
		casoDeTesteDao = new CasoDeTesteDaoImpl();
		casosDeTeste = new ArrayList<SelectItem>();
		casosDeTesteProjeto = new ArrayList<CasoDeTeste>();
		casoDeTesteSelecionados = new ArrayList<String>();
		respostas = new ArrayList<CasoDeTeste>();
		respostasCorretas = new ArrayList<CasoDeTeste>();
		respostasErradas = new ArrayList<CasoDeTeste>();
		respondido = false;
	}

	/* Métodos Auxiliares */
	public Integer validaResposta() {
		Integer pontuacao = 0;
		for (CasoDeTeste cdt : casosDeTesteProjeto) {
			if (cdt.getResposta()) {
				respostasCorretas.add(cdt);
			} else {
				respostasErradas.add(cdt);
			}
		}
		for (String i : casoDeTesteSelecionados) {
			CasoDeTeste cdt = getCasoDeTesteById(new Integer(i));
			respostas.add(cdt);
			if (respostasCorretas.contains(cdt)) {
				pontuacao = pontuacao + Utils.PONTO_POSITIVO;
			} else {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}
		for (CasoDeTeste cdt : respostasCorretas) {
			if (!respostas.contains(cdt)) {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}

		respondido = true;
		return pontuacao;
	}

	public CasoDeTeste getCasoDeTesteById(Integer id) {
		for (CasoDeTeste cdt : casosDeTesteProjeto) {
			if (cdt.getId().equals(id)) {
				return cdt;
			}
		}
		return null;
	}

	public CasoDeTesteDao getCasoDeTesteDao() {
		return casoDeTesteDao;
	}

	public void setCasoDeTesteDao(CasoDeTesteDao casoDeTesteDao) {
		this.casoDeTesteDao = casoDeTesteDao;
	}

	public List<SelectItem> getCasosDeTeste() {
		return casosDeTeste;
	}

	public void setCasosDeTeste(List<SelectItem> casosDeTeste) {
		this.casosDeTeste = casosDeTeste;
	}

	public List<CasoDeTeste> getCasosDeTesteProjeto() {
		return casosDeTesteProjeto;
	}

	public void setCasosDeTesteProjeto(List<CasoDeTeste> casosDeTesteProjeto) {
		this.casosDeTesteProjeto = casosDeTesteProjeto;
	}

	public List<String> getCasoDeTesteSelecionados() {
		return casoDeTesteSelecionados;
	}

	public void setCasoDeTesteSelecionados(List<String> casoDeTesteSelecionados) {
		this.casoDeTesteSelecionados = casoDeTesteSelecionados;
	}

	public List<CasoDeTeste> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<CasoDeTeste> respostas) {
		this.respostas = respostas;
	}

	public List<CasoDeTeste> getRespostasCorretas() {
		return respostasCorretas;
	}

	public void setRespostasCorretas(List<CasoDeTeste> respostasCorretas) {
		this.respostasCorretas = respostasCorretas;
	}

	public List<CasoDeTeste> getRespostasErradas() {
		return respostasErradas;
	}

	public void setRespostasErradas(List<CasoDeTeste> respostasErradas) {
		this.respostasErradas = respostasErradas;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

}
