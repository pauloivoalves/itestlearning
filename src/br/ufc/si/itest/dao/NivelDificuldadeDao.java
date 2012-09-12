/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.NivelDificuldade;

/**
 * @author Virginia
 *
 */
public interface NivelDificuldadeDao {
	
	public void save(NivelDificuldade nivelDificuldade);
	
	public void remove(NivelDificuldade nivelDificuldade);
	
	public void update(NivelDificuldade nivelDificuldade);
	
	public List<NivelDificuldade> list();

}
