/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.TipoTesteProjeto;

/**
 * @author Virginia
 *
 */
public interface TipoTesteProjetoDao {
	
	public void save(TipoTesteProjetoDao tipoTesteProjeto);
	
	public void remove(TipoTesteProjetoDao tipoTesteProjeto);
	
	public void update(TipoTesteProjeto tipoTesteProjeto);
	
	public List<TipoTesteProjetoDao> list();
	
	public List<TipoTesteProjeto> getTipoTesteProjetoByIdProjeto(int id_projeto);
	
	public TipoTesteProjeto getTipoTesteProjetoByIdProjetoIdTipoTeste(int id_projeto,int id_tipo_teste);
	
}//fim da interface
