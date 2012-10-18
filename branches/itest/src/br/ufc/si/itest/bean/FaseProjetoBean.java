package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import br.ufc.si.itest.dao.FaseProjetoDao;
import br.ufc.si.itest.dao.impl.FaseProjetoDaoImpl;
import br.ufc.si.itest.model.FaseProjeto;

public class FaseProjetoBean {

	/* DAOs */
	private FaseProjetoDao faseProjetoDao;

	/* Propriedades auxiliares */
	private List<FaseProjeto> faseProjetosProjeto;

	/* Construtor */
	FaseProjetoBean() {
		faseProjetoDao = new FaseProjetoDaoImpl();
		faseProjetosProjeto = new ArrayList<FaseProjeto>();

	}

	public FaseProjetoDao getFaseProjetoDao() {
		return faseProjetoDao;
	}

	public void setFaseProjetoDao(FaseProjetoDao faseProjetoDao) {
		this.faseProjetoDao = faseProjetoDao;
	}

	public List<FaseProjeto> getFaseProjetosProjeto() {
		return faseProjetosProjeto;
	}

	public void setFaseProjetosProjeto(List<FaseProjeto> faseProjetosProjeto) {
		this.faseProjetosProjeto = faseProjetosProjeto;
	}

}
