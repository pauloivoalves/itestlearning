package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.ufc.si.itest.dao.AlunoDao;
import br.ufc.si.itest.dao.impl.AlunoDaoImpl;
import br.ufc.si.itest.dao.impl.JogoDaoImpl;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.utils.SendMail;

public class AlunoBean {
	/* Daos e models */
	private AlunoDao alunodao;
	private Aluno aluno;
	private List<Jogo> jogosAux;
	private List<Jogo> jogos;

	/* Auxiliares */
	private String nome;
	private int idTurma;
	private String nomeProjeto;

	/* Cosntrutor */

	public AlunoBean() {
		alunodao = new AlunoDaoImpl();
		aluno = new Aluno();

		// recuperar sessão do usuario.
		ServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = (HttpSession) request.getSession();
		int idUsuarioSession = (Integer) session.getAttribute("ID_USUARIO");
		nome = (String) session.getAttribute("NOME_USUARIO");
		idTurma = (Integer) session.getAttribute("TURMA");
		jogos = new ArrayList<Jogo>();
		jogosAux = new ArrayList<Jogo>();
		JogoDaoImpl jogoDaoImpl = new JogoDaoImpl();

		if (idTurma == 0) {
			jogos = jogoDaoImpl.getJogoById(idUsuarioSession);

		} else {

			jogosAux = jogoDaoImpl.getJogoById(idUsuarioSession);

			for (Jogo j : jogosAux) {
				if (j.getTurma() == idTurma) {
					jogos.add(j);
				}
			}

		}
	}

	/* Métodos get e set */

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/* funcionalidades */
	public String cadastrarAluno() {
		String msg = "Bem vindo ao Itest " + this.aluno.getNome()
				+ ", sua senha: " + this.aluno.getSenha();
		try {
			SendMail.enviarEmail(this.aluno.getLogin(),
					"Criação de Conta no Itest", msg);
			alunodao.saveAlunos(getAluno());
			aluno = new Aluno();
			return "/cadastro.xhtml";
		} catch (Exception e) {
			return "/cadastro.xhtml";
		}

	}

	public void inicializar() {
		// jogos = alunodao.
	}
}
