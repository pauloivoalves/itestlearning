/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

/**
 * @author Virginia
 *
 */
public interface FerramentaProjetoDao {
	
	public void save(FerramentaProjetoDao ferramentaProjeto);
	
	public void remove(FerramentaProjetoDao ferramentaProjeto);
	
	public void update(FerramentaProjetoDao ferramentaProjeto);
	
	public List<FerramentaProjetoDao> list();

}
