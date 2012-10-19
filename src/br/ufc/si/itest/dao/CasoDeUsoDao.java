package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.CasoDeUso;

public interface CasoDeUsoDao {

	public void save(CasoDeUso faseProjeto);

	public void remove(CasoDeUso faseProjeto);

	public void update(CasoDeUso faseProjeto);

	public List<CasoDeUso> list();

	public List<CasoDeUso> getCasoDeUsoByIdProjeto(Integer idProjeto);

}// fim da interface
