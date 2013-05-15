package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Administrador;
import br.ufc.si.itest.model.Projeto;

public interface AdministradorDao {

	public List<Projeto> listarProjetos();
	
	public Administrador verificaAdmin(int id);
	
}