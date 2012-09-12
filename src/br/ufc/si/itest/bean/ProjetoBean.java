/**
 * 
 */
package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.model.Projeto;

/**
 * @author Virginia
 *
 */
public class ProjetoBean {
	/* Classes de modelo */
	private Projeto projeto;
	
	/* DAOs */
	private ProjetoDao projetoDao;
	
	/* Propriedades auxiliares */
	private List<SelectItem> projetos;
	
	/* Construtor */
	public ProjetoBean() {
		projeto = new Projeto();
		
		projetoDao = new ProjetoDaoImpl();
		
		projetos = new ArrayList<SelectItem>();
	}

	/* Getters e Setters*/
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<SelectItem> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<SelectItem> projetos) {
		this.projetos = projetos;
	}

	public ProjetoDao getProjetoDao() {
		return projetoDao;
	}

	public void setProjetoDao(ProjetoDao projetoDao) {
		this.projetoDao = projetoDao;
	}
}
