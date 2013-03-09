package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.model.Projeto;

public class AdministradorBean {
    private ProjetoDao projetoDao;
    private Projeto projeto;
    private List<Projeto> meus_projetos;
	
    
    
    public ProjetoDao getProjetoDao() {
		return projetoDao;
	}
	public void setProjetoDao(ProjetoDao projetoDao) {
		this.projetoDao = projetoDao;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}	
	public List<Projeto> getMeus_projetos() {
		return meus_projetos;
	}
	public void setMeus_projetos(List<Projeto> meus_projetos) {
		this.meus_projetos = meus_projetos;
	}
	public AdministradorBean() {
		projeto = new Projeto();
		projetoDao = new ProjetoDaoImpl();
		meus_projetos = new ArrayList<Projeto>();
		inicializar();
	}
    
    private void inicializar(){
    	this.meus_projetos = projetoDao.list();
    }
    
}
