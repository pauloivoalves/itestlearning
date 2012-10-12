package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.FaseProjetoDao;
import br.ufc.si.itest.dao.impl.FaseProjetoDaoImpl;
import br.ufc.si.itest.model.FaseProjeto;
import br.ufc.si.itest.utils.Utils;

public class FaseProjetoBean {

	/* Classes de modelo */
	private FaseProjeto faseProjeto;

	/* DAOs */
	private FaseProjetoDao faseProjetoDao;

	/* Propriedades auxiliares */
	private List<FaseProjeto> faseProjetosProjeto;
	private List<SelectItem> fasesProjeto;
	private List<String> alternativasSelecionadas;
	private List<FaseProjeto> respostas;
	private List<FaseProjeto> respostasCorretas;
	private List<FaseProjeto> respostasErradas;
	private Boolean respondido;

	/* Construtor */
	FaseProjetoBean() {
		faseProjetoDao = new FaseProjetoDaoImpl();
		faseProjeto = new FaseProjeto();
		faseProjetosProjeto = new ArrayList<FaseProjeto>();
		fasesProjeto = new ArrayList<SelectItem>();
		alternativasSelecionadas = new ArrayList<String>();
		respostas = new ArrayList<FaseProjeto>();
		respostasCorretas = new ArrayList<FaseProjeto>();
		respostasErradas = new ArrayList<FaseProjeto>();
		respondido = false;
	}

	/* Métodos Auxiliares */
	public Integer validaResposta() {
		Integer pontuacao = 0;
		for (FaseProjeto fp : faseProjetosProjeto) {
			if (fp.getResposta()) {
				respostasCorretas.add(fp);
			} else {
				respostasErradas.add(fp);
			}
		}
		for (String a : alternativasSelecionadas) {
			FaseProjeto fp = getFaseProjetoById(new Integer(a));
			respostas.add(fp);
			if (respostasCorretas.contains(fp)) {
				pontuacao = pontuacao + Utils.PONTO_POSITIVO;
			} else {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}
		for (FaseProjeto fp : respostasCorretas) {
			if (!respostas.contains(fp)) {
				pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
			}
		}

		respondido = true;
		return pontuacao;
	}

	public FaseProjeto getFaseProjetoById(Integer id) {
		for (FaseProjeto fp : faseProjetosProjeto) {
			if (fp.getId().equals(id)) {
				return fp;
			}
		}
		return null;
	}

	/* Getters e Setters */
	public FaseProjeto getFaseProjeto() {
		return faseProjeto;
	}

	public List<String> getAlternativasSelecionadas() {
		return alternativasSelecionadas;
	}

	public void setAlternativasSelecionadas(
			List<String> alternativasSelecionadas) {
		this.alternativasSelecionadas = alternativasSelecionadas;
	}

	public List<FaseProjeto> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<FaseProjeto> respostas) {
		this.respostas = respostas;
	}

	public List<FaseProjeto> getRespostasCorretas() {
		return respostasCorretas;
	}

	public void setRespostasCorretas(List<FaseProjeto> respostasCorretas) {
		this.respostasCorretas = respostasCorretas;
	}

	public List<FaseProjeto> getRespostasErradas() {
		return respostasErradas;
	}

	public void setRespostasErradas(List<FaseProjeto> respostasErradas) {
		this.respostasErradas = respostasErradas;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	public List<SelectItem> getFasesProjeto() {
		return fasesProjeto;
	}

	public void setFasesProjeto(List<SelectItem> fasesProjeto) {
		this.fasesProjeto = fasesProjeto;
	}

	public List<FaseProjeto> getFaseProjetosProjeto() {
		return faseProjetosProjeto;
	}

	public void setFaseProjetosProjeto(List<FaseProjeto> faseProjetosProjeto) {
		this.faseProjetosProjeto = faseProjetosProjeto;
	}

	public void setFaseProjeto(FaseProjeto faseProjeto) {
		this.faseProjeto = faseProjeto;
	}

	public FaseProjetoDao getFaseProjetoDao() {
		return faseProjetoDao;
	}

	public void setFaseProjetoDao(FaseProjetoDao faseProjetoDao) {
		this.faseProjetoDao = faseProjetoDao;
	}

}
