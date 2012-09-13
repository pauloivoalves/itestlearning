/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.NivelTesteProjeto;

/**
 * @author Virginia
 *
 */
public interface NivelTesteProjetoDao {
	
	public void save(NivelTesteProjeto nivelTesteProjeto);
	
	public void remove(NivelTesteProjeto nivelTesteProjeto);
	
	public void update(NivelTesteProjeto nivelTesteProjeto);
	
	public List<NivelTesteProjeto> list();
	
	public List<NivelTesteProjeto> getNivelTesteProjetoByIdProjeto(int id_projeto);
	
	public NivelTesteProjeto getNivelTesteProjetoByIdProjetoIdNivelTeste(int id_projeto,int id_nivel_teste);
	
	
}//fim da interface
