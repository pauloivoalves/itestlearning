package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Jogo;

public interface AlunoDao {

public void saveAlunos(Aluno aluno);
	
	public void removeAlunos(Aluno aluno);
	
	public void updateAlunos(Aluno aluno);
	
	public List<Aluno> listarAlunos();
	
	public Aluno getAlunoByNome(String nome);
	
	public Aluno getAlunoByEmail(String email);
	
	public Aluno getAlunoById(int id);
	
	public Aluno getAlunoTudo(int id);
	
	public List<Jogo> listarMeusJogos(Aluno aluno);
	
	public List<Aluno> listAlunosByTurma(int id);
}
