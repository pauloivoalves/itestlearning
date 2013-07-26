package br.ufc.si.itest.dao;

import java.util.Date;
import java.util.List;

import br.ufc.si.itest.model.Professor;
import br.ufc.si.itest.model.Simulado;

public interface SimuladoDao {

	public void save(Simulado simulado);

	public void update(Simulado simulado);

	public void delete(Simulado simulado);

	public Simulado getSimuladoById(int id);

	public Simulado getSimuladoByData(Date data);

	public List<Simulado> list(int prof_id);

	public List<Simulado> listSimulados(Professor professor);

	public List<Simulado> getSimuladoByTurma(int turma_id);
}
