package br.ufc.si.itest.dao;

/**
 * @author Mardson
 * 
 */

import java.util.List;

import br.ufc.si.itest.model.AlunoTurma;

public interface AlunoTurmaDao {

	public void save(AlunoTurma aluno_turma);

	public void remove(AlunoTurma aluno_turma);

	public void update(AlunoTurma aluno_turma);

	public List<AlunoTurma> list();

	public List<AlunoTurma> getAlunoTurmaByIdAluno(
			int id_aluno);
	
	public List<AlunoTurma> getAlunoTurmaByIdTurma(
			int id_turma);

	public AlunoTurma getAlunoTurmaByIdAlunoIdTurma(
			int id_aluno, int id_turma);
	
	
	
}
