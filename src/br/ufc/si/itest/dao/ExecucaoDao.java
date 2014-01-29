package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.ExecucaoProjeto;

public interface ExecucaoDao {

	public void save(ExecucaoProjeto execucao);

	public void remove(ExecucaoProjeto execucao);

	public void update(ExecucaoProjeto execucao);

	public List<ExecucaoProjeto> list();

	public List<ExecucaoProjeto> getOpcoesByIdCasoDeTeste(int id);
}
