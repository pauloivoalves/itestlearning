package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.CasoDeTesteDao;
import br.ufc.si.itest.dao.CasoDeUsoDao;
import br.ufc.si.itest.dao.ExecucaoDao;
import br.ufc.si.itest.dao.impl.CasoDeTesteDaoImpl;
import br.ufc.si.itest.dao.impl.CasoDeUsoDaoImpl;
import br.ufc.si.itest.dao.impl.ExecucaoDaoImpl;
import br.ufc.si.itest.model.CasoDeTeste;
import br.ufc.si.itest.model.CasoDeUso;
import br.ufc.si.itest.model.ExecucaoProjeto;

public class ExecucaoBean {

	private List<CasoDeUso> casosDeUsos;
	private List<CasoDeTeste> casosDetestes;
	private CasoDeUsoDao casoDeUsoDao;
	private CasoDeTesteDao casoDeTesteDao;
	private String formulario;
	private List<ExecucaoProjeto> opcoes;
	private List<SelectItem> sel;
	private ExecucaoDao execucaoDao;
	private List<String> selecionados;
	private String dados;

	private int i = 0;

	public ExecucaoBean() {
		casoDeTesteDao = new CasoDeTesteDaoImpl();
		casoDeUsoDao = new CasoDeUsoDaoImpl();
		casosDetestes = new ArrayList<CasoDeTeste>();
		casosDeUsos = new ArrayList<CasoDeUso>();
		execucaoDao = new ExecucaoDaoImpl();
		selecionados = new ArrayList<String>();
		sel = new ArrayList<SelectItem>();
	}

	public void montaOpcoes() {
		sel.add(new SelectItem("verdadeiro", "verdadeiro"));
		sel.add(new SelectItem("falso", "falso"));
	}

	public void formaCadastro(CasoDeTeste caso) {
		montaOpcoes();
		dados = caso.getDados();
		String[] campos = caso.getCampos().split(",");
		formulario = "<h3>Realize seu Cadastro</h3><input id='msgm' type='hidden' value='"
				+ caso.getMensagemSistema() + "'>";
		for (int i = 0; i < campos.length; i++) {
			formulario += "<label for=" + campos[i] + ">" + campos[i]
					+ ": </label for=" + campos[i] + "><input class='campo"
					+ "'" + "id='" + campos[i] + "'></br></br>";
		}
		formulario += "<input type='" + "button" + "' value='" + "cadastrar"
				+ "'onclick='cadastro()'";

	}

	public List<CasoDeUso> getCasosDeUsos() {
		return casosDeUsos;
	}

	public void setCasosDeUsos(List<CasoDeUso> casosDeUsos) {
		this.casosDeUsos = casosDeUsos;
	}

	public List<CasoDeTeste> getCasosDetestes() {
		return casosDetestes;
	}

	public void setCasosDetestes(List<CasoDeTeste> casosDetestes) {
		this.casosDetestes = casosDetestes;
	}

	public CasoDeUsoDao getCasoDeUsoDao() {
		return casoDeUsoDao;
	}

	public void setCasoDeUsoDao(CasoDeUsoDao casoDeUsoDao) {
		this.casoDeUsoDao = casoDeUsoDao;
	}

	public CasoDeTesteDao getCasoDeTesteDao() {
		return casoDeTesteDao;
	}

	public void setCasoDeTesteDao(CasoDeTesteDao casoDeTesteDao) {
		this.casoDeTesteDao = casoDeTesteDao;
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public List<ExecucaoProjeto> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<ExecucaoProjeto> opcoes) {
		this.opcoes = opcoes;
	}

	public List<SelectItem> getSel() {
		return sel;
	}

	public void setSel(List<SelectItem> sel) {
		this.sel = sel;
	}

	public List<String> getSelecionados() {
		return selecionados;
	}

	public void setSelecionados(List<String> selecionados) {
		this.selecionados = selecionados;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}
}
