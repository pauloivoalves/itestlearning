/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Artefato;
import br.ufc.si.itest.model.ArtefatoProjeto;

/**
 * @author Virginia
 *
 */
public interface ArtefatoDao {
	
	public void save(Artefato artefato);
	
	public void remove(Artefato artefato);
	
	public void update(Artefato artefato);
	
	public List<Artefato> list();
	
	public List<ArtefatoProjeto> getArtefatosByProjeto(Integer idProjeto);
	
	public Artefato getArtefatoByName(String nome_artefato);

	
}//fim da interface
