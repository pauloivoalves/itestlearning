package br.ufc.si.itest.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.ufc.si.itest.dao.AlunoDao;
import br.ufc.si.itest.dao.JogoDao;
import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.impl.AlunoDaoImpl;
import br.ufc.si.itest.dao.impl.JogoDaoImpl;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.utils.SendMail;

public class AlunoBean {
	/* Daos e models */
	private AlunoDao alunodao;
	private Aluno aluno;
	private List<Jogo> jogosAux;
	private List<Jogo> jogos;
	List<Jogo> jogosGeral;
	/* Auxiliares */
	private String nome;
	private Integer idTurma;
	private String nomeProjeto;

	/* Cosntrutor */

	public AlunoBean() {
		lista();
	}

	/* Métodos get e set */

	public void lista() {
		alunodao = new AlunoDaoImpl();
		aluno = new Aluno();

		try {

			// recuperar sessão do usuario.
			ServletRequest req = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			HttpServletRequest request = (HttpServletRequest) req;
			HttpSession session = (HttpSession) request.getSession();
			Integer idUsuarioSession = (Integer) session
					.getAttribute("ID_USUARIO");
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String atualizaLista() {
		lista();
		return "listaAtualizadaJogos";
	}

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

	public List<Jogo> getJogosAux() {
		return jogosAux;
	}

	public void setJogosAux(List<Jogo> jogosAux) {
		this.jogosAux = jogosAux;
	}

	public List<Jogo> getJogosGeral() {
		return jogosGeral;
	}

	public void setJogosGeral(List<Jogo> jogosGeral) {
		this.jogosGeral = jogosGeral;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
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

	public void rankingGeral(ActionEvent event) throws IOException {

		nomeProjeto = (String) event.getComponent().getAttributes()
				.get("nomeProjeto");
		jogosGeral = new ArrayList<Jogo>();
		JogoDao jogoDao = new JogoDaoImpl();
		ProjetoDao projetoDao = new ProjetoDaoImpl();
		jogosGeral = jogoDao.getJogoByProjeto(projetoDao.getProjetoByName(
				nomeProjeto).getId());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("ranking_geral.jsf");

	}

	public void rankingTurma(ActionEvent event) throws IOException {
		nomeProjeto = (String) event.getComponent().getAttributes()
				.get("nomeProjeto");
		jogosGeral = new ArrayList<Jogo>();
		JogoDao jogoDao = new JogoDaoImpl();
		ProjetoDao projetoDao = new ProjetoDaoImpl();
		jogosGeral = jogoDao.getJogoByTurmaProjeto(idTurma, projetoDao
				.getProjetoByName(nomeProjeto).getId());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("ranking_turma.jsf");

	}

	public void inicializar() {
		// jogos = alunodao.
	}
}
