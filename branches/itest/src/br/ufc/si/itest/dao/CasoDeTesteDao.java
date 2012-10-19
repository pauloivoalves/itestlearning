package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.CasoDeTeste;

public interface CasoDeTesteDao {

	public void save(CasoDeTeste casoDeTeste);

	public void remove(CasoDeTeste casoDeTeste);

	public void update(CasoDeTeste casoDeTeste);

	public List<CasoDeTeste> list();

	public List<CasoDeTeste> getCasoDeTesteByIdCasoDeUso(Integer idCasoDeUso);

}// fim da interface

