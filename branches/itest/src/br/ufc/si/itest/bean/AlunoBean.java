package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import br.ufc.si.itest.dao.AlunoDao;
import br.ufc.si.itest.dao.impl.AlunoDaoImpl;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.utils.SendMail;

public class AlunoBean {
     /*Daos e models*/
	private AlunoDao alunodao;
    private Aluno aluno;
    private List<Jogo> jogos; 
    
    
    
	
	
	/*Cosntrutor*/
	
	public AlunoBean() {
		alunodao = new AlunoDaoImpl();
		aluno = new Aluno();
		jogos = new ArrayList<Jogo>();
	}
	
	/*Métodos get e set*/
	
	
	
	public AlunoDao getAlunodao() {
		return alunodao;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public void setAlunodao(AlunoDao alunodao) {
		this.alunodao = alunodao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
	
	/*funcionalidades*/
	public String cadastrarAluno(){
		String msg = "Bem vindo ao Itest " + this.aluno.getNome() + ", sua senha: " + this.aluno.getSenha();
	try{
		SendMail.enviarEmail(this.aluno.getLogin(), "Criação de Conta no Itest", msg);
		alunodao.saveAlunos(getAluno());
		aluno = new Aluno();
		return "/cadastro.xhtml";
	}catch (Exception e) {
		return "/cadastro.xhtml";
	}
		
	}
	
	
	
	public void inicializar(){
		//jogos = alunodao.
	}
}
