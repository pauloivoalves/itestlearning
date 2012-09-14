/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import br.ufc.si.itest.model.FerramentaProjeto;

/**
 * @author Virginia
 * 
 */
public interface FerramentaProjetoDao {

	public void save(FerramentaProjeto ferramentaProjeto);

	public void remove(FerramentaProjeto ferramentaProjeto);

	public void update(FerramentaProjeto ferramentaProjeto);

	public List<FerramentaProjeto> list();

	public List<FerramentaProjeto> getFerramentaProjetoByIdProjeto(
			int id_projeto);

	public FerramentaProjeto getFerramentaProjetoByIdProjetoIdFerramenta(
			int id_projeto, int id_ferramenta);

}// fim da interface
