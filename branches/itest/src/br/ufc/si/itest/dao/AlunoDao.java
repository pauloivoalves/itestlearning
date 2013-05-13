package br.ufc.si.itest.dao;

import java.util.List;

import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.Usuario;

public interface AlunoDao {

public void saveAlunos(Aluno aluno);
	
	public void removeAlunos(Aluno aluno);
	
	public void updateAlunos(Aluno aluno);
	
	public List<Aluno> listarAlunos();
	
	public Usuario getUsuarioByNome(String nome);
	
	public Usuario getUsuarioByEmail(String email);
	
	public Usuario getUsuarioById(int id);
	
	public Usuario getUsuarioTudo(int id);
	
	public List<Jogo> listarMeusJogos(Aluno aluno);
	
	public List<Aluno> listAlunosByTurma(int id);
}
