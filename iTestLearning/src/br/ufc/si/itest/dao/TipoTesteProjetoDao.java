/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

/**
 * @author Virginia
 *
 */
public interface TipoTesteProjetoDao {
	
	public void save(TipoTesteProjetoDao tipoTesteProjeto);
	
	public void remove(TipoTesteProjetoDao tipoTesteProjeto);
	
	public void update(TipoTesteProjetoDao tipoTesteProjeto);
	
	public List<TipoTesteProjetoDao> list();

}
