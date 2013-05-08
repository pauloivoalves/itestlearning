package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Professor;

public interface ProfessorDao {
	
	public void save(Professor professor);
	
	public void update(Professor professor);
	
	public void delete(Professor professor);
	
	public Professor getProfessorById(int id);

	public List<Professor> list();

}
