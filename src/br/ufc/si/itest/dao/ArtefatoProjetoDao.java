/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import org.hibernate.Session;

import br.ufc.si.itest.model.caso;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 * 
 */
public interface ArtefatoProjetoDao {

	public void save(caso artefatoProjeto);

	public void remove(caso artefatoProjeto);

	public void update(caso artefatoProjeto);

	public List<caso> list();

	public List<caso> getArtefatProjetoByIdProjeto(int id_projeto);

	public caso getArtefatProjetoByIdProjetoIdArtefato(
			int id_projeto, int id_artefato);

	public caso getArtefatoProjetoById(Integer pk);

	
}// fim da interface
