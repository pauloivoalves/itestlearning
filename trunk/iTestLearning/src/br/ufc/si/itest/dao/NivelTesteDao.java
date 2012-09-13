/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.NivelTeste;
import br.ufc.si.itest.model.NivelTesteProjeto;

/**
 * @author Virginia
 *
 */
public interface NivelTesteDao {
	
	public void save(NivelTeste nivelTeste);
	
	public void remove(NivelTeste nivelTeste);
	
	public void update(NivelTeste nivelTeste);
	
	public List<NivelTeste> list();
	
	public List<NivelTesteProjeto> getItensTesteByProjeto(Integer idProjeto);
	
	public NivelTeste getNivelTesteByName(String nome_nivel_teste);

}//fim da interface
