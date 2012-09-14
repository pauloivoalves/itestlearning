/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.NivelDificuldade;
import br.ufc.si.itest.model.Projeto;

/**
 * @author Virginia
 *
 */
public interface ProjetoDao {
	
	public void save(Projeto projeto);
	
	public void remove(Projeto projeto);
	
	public void update(Projeto projeto);
	
	public List<Projeto> list();
	
	public List<Projeto> getProjetoByNivelDificuldade(NivelDificuldade nivelDificuldade);
	
	public Projeto getProjetoById(Integer id);
	
	public Projeto getProjetoByName(String nome) ;

}//fim da interface
