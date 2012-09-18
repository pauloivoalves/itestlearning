/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import org.hibernate.Session;

import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 * 
 */
public interface ArtefatoProjetoDao {

	public void save(ArtefatoProjeto artefatoProjeto);

	public void remove(ArtefatoProjeto artefatoProjeto);

	public void update(ArtefatoProjeto artefatoProjeto);

	public List<ArtefatoProjeto> list();

	public List<ArtefatoProjeto> getArtefatProjetoByIdProjeto(int id_projeto);

	public ArtefatoProjeto getArtefatProjetoByIdProjetoIdArtefato(
			int id_projeto, int id_artefato);

	public ArtefatoProjeto getArtefatoProjetoById(Integer pk);

	
}// fim da interface
