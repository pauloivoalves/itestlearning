package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.FaseProjeto;

public interface FaseProjetoDao {

	public void save(FaseProjeto faseProjeto);

	public void remove(FaseProjeto faseProjeto);

	public void update(FaseProjeto faseProjeto);

	public List<FaseProjeto> list();

	public FaseProjeto getFaseProjetoByIdProjeto(Integer idProjeto);

	public List<FaseProjeto> getFaseProjetoAlternativasByIdProjeto(
			Integer idProjeto);

}// fim da interface
