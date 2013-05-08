package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Turma;

public interface TurmaDao {

	public void save(Turma turma);

	public void update(Turma turma);

	public void delete(Turma turma);

	public Turma getTurmaById(int id);
	
	public List<Turma> carregarTurmasProfessor(int id_prof);

	public List<Turma> list();
}
