/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Usuario;

/**
 * @author Virginia
 *
 */
public interface UsuarioDao {
	
	public void save(Usuario usuario);
	
	public void remove(Usuario usuario);
	
	public void update(Usuario usuario);
	
	public List<Usuario> list();
	
	public Usuario getUsuarioByNome(String nome);

	public Usuario getUsuarioByName(String nome);
	

}//fim da interface
