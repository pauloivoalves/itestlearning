/**
 * 
 */
package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.CriterioAceitacao;

/**
 * @author Virginia
 *
 */
public interface CriterioAceitacaoDao {
	
	public void save(CriterioAceitacao criterioAceitacao);
	
	public void remove(CriterioAceitacao criterioAceitacao);
	
	public void update(CriterioAceitacao criterioAceitacao);
	
	public List<CriterioAceitacao> list();
	
	public List<CriterioAceitacao> getCriterioAceitacaoByProjeto(Integer idProjeto);
	
	public CriterioAceitacao getCriterioAceitacaoById(int id);

}//fim da interface
