/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.FerramentaProjeto;

/**
 * @author Virginia
 *
 */
public interface FerramentaProjetoDao {
	
	public void save(FerramentaProjetoDao ferramentaProjeto);
	
	public void remove(FerramentaProjetoDao ferramentaProjeto);
	
	public void update(FerramentaProjeto ferramentaProjeto);
	
	public List<FerramentaProjetoDao> list();
	
	public List<FerramentaProjeto> getFerramentaProjetoByIdProjeto(int id_projeto);
	
	public FerramentaProjeto getFerramentaProjetoByIdProjetoIdFerramenta(int id_projeto,int id_ferramenta);

}
