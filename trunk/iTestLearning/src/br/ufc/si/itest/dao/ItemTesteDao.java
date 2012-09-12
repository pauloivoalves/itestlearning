/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.ItemTeste;

/**
 * @author Virginia
 *
 */
public interface ItemTesteDao {

	public void save(ItemTeste itemTeste);
	
	public void remove(ItemTeste itemTeste);
	
	public void update(ItemTeste itemTeste);
	
	public List<ItemTeste> list();
	
	public List<ItemTeste> getItensTesteByProjeto(Integer idProjeto);

	public ItemTeste getItemtesteById(int id);
}
