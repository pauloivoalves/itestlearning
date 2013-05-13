package br.ufc.si.itest.testes;

import java.util.List;

import br.ufc.si.itest.adicionais.InserirNoBanco;
import br.ufc.si.itest.dao.AlunoDao;
import br.ufc.si.itest.dao.impl.AlunoDaoImpl;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.Usuario;

public class TestaAluno {

	
	private static void listarAlunos(){
		AlunoDao alunodao = new AlunoDaoImpl();
		List<Aluno> alunos = alunodao.listarAlunos();
		for(Aluno a:alunos){
			System.out.println(a.getNome());
		}
	}
	
	
	private static void listarJogos(){
		AlunoDao alunodao = new AlunoDaoImpl();
		Aluno a = (Aluno) alunodao.getUsuarioByNome("mardson");
		
		if(a == null){
			System.out.println("erro aluno");
		}else{
			System.out.println(a.getSenha());
		List<Jogo> jogos = alunodao.listarMeusJogos(a);
		if(jogos!= null){
			for(Jogo elem:jogos){
				System.out.println(elem.getPk().getProjeto().getNome());
			}
		}else{
			System.out.println("erro");
		}
		}
	}
	
	
	
	public static void buscarAluno(){
		AlunoDao alunoDao = new AlunoDaoImpl();
		Aluno aluno = (Aluno) alunoDao.getUsuarioTudo(31);
		aluno.getJogos().size();
	}
	
	public static void main(String[] args) {
		//listarAlunos();
		//listarJogos();
		
		//InserirNoBanco inb = new InserirNoBanco();
		//inb.inserirAlunoTurma();
		buscarAluno();
		
	}
}
