/**
 * 
 */
package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.ufc.si.itest.dao.NivelDificuldadeDao;
import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.impl.NivelDificuldadeDaoImpl;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.model.NivelDificuldade;
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
	String nome_nivel_dificuldade;
	
	/* Construtor */
	public ProjetoBean() {
		projeto = new Projeto();
		
		projetoDao = new ProjetoDaoImpl();
		
		projetos = new ArrayList<SelectItem>();
	}
	
	public String criarProjeto(){
		NivelDificuldadeDaoImpl nivelDao = new NivelDificuldadeDaoImpl();
		NivelDificuldade nivelDificuldade = new NivelDificuldade();
		
		nivelDificuldade = nivelDao.getNivelDificuldadeByName(nome_nivel_dificuldade);
		projeto.setNivelDificuldade(nivelDificuldade);
		projetoDao.save(projeto);
		
		return "criado";
			
	
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

	public String getNome_nivel_dificuldade() {
		return nome_nivel_dificuldade;
	}

	public void setNome_nivel_dificuldade(String nome_nivel_dificuldade) {
		this.nome_nivel_dificuldade = nome_nivel_dificuldade;
	}
	
	
}
