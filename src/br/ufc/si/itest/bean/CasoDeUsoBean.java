package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.CasoDeUsoDao;
import br.ufc.si.itest.dao.impl.CasoDeUsoDaoImpl;
import br.ufc.si.itest.model.CasoDeUso;

public class CasoDeUsoBean {

	/* Model */
	private CasoDeUso casoDeUso;

	/* DAOs */
	private CasoDeUsoDao casoDeUsoDao;

	/* Propriedades auxiliares */
	private List<CasoDeUso> casoDeUsoProjeto;
	



	
	
	/* Construtor */
	CasoDeUsoBean() {
		casoDeUso = new CasoDeUso();
		casoDeUsoDao = new CasoDeUsoDaoImpl();
		casoDeUsoProjeto = new ArrayList<CasoDeUso>();
			}

	public CasoDeUso getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(CasoDeUso casoDeUso) {
		this.casoDeUso = casoDeUso;
	}

	public CasoDeUsoDao getCasoDeUsoDao() {
		return casoDeUsoDao;
	}

	public void setCasoDeUsoDao(CasoDeUsoDao casoDeUsoDao) {
		this.casoDeUsoDao = casoDeUsoDao;
	}

	public List<CasoDeUso> getCasoDeUsoProjeto() {
		return casoDeUsoProjeto;
	}

	public void setCasoDeUsoProjeto(List<CasoDeUso> casoDeUsoProjeto) {
		this.casoDeUsoProjeto = casoDeUsoProjeto;
	}

}
