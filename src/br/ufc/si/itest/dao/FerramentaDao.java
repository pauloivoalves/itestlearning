/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Ferramenta;
import br.ufc.si.itest.model.FerramentaProjeto;

/**
 * @author Virginia
 *
 */
public interface FerramentaDao {
	
	public void save(Ferramenta ferramenta);
	
	public void remove(Ferramenta ferramenta);
	
	public void update(Ferramenta ferramenta);
	
	public List<Ferramenta> list();
	
	public List<FerramentaProjeto> getItensTesteByProjeto(Integer idProjeto);
	
	public Ferramenta getFerramentaByName(String nome);
	
	public Ferramenta getFerramentaByNome(String nome);
	

	

}//fim da interface
