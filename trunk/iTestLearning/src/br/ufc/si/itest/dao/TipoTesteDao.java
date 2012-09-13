/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.TipoTeste;
import br.ufc.si.itest.model.TipoTesteProjeto;

/**
 * @author Virginia
 *
 */
public interface TipoTesteDao {
	
	public void save(TipoTeste tipoTeste);
	
	public void remove(TipoTeste tipoTeste);
	
	public void update(TipoTeste tipoTeste);
	
	public List<TipoTeste> list();
	
	public List<TipoTesteProjeto> getItensTesteByProjeto(Integer idProjeto);
	
	public TipoTeste getTipoTesteByNome(String nome);

}//fim da interface
