/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Jogo;

/**
 * @author Virginia
 *
 */
public interface JogoDao {
	
	public void save(Jogo jogo);
	
	public void remove(Jogo jogo);
	
	public void update(Jogo jogo);
	
	public List<Jogo> list();

}
