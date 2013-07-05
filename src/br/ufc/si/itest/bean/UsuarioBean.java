package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import br.ufc.si.itest.dao.AlunoDao;
import br.ufc.si.itest.dao.JogoDao;
import br.ufc.si.itest.dao.ProfessorDao;
import br.ufc.si.itest.dao.TurmaDao;
import br.ufc.si.itest.dao.impl.AdiministradorDaoImpl;
import br.ufc.si.itest.dao.impl.AlunoDaoImpl;
import br.ufc.si.itest.dao.impl.JogoDaoImpl;
import br.ufc.si.itest.dao.impl.ProfessorDaoImpl;
import br.ufc.si.itest.dao.impl.TurmaDaoImpl;
import br.ufc.si.itest.dao.impl.UsuarioDaoImpl;
import br.ufc.si.itest.model.Administrador;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.Professor;
import br.ufc.si.itest.model.Turma;
import br.ufc.si.itest.model.Usuario;

public class UsuarioBean {

	private Usuario usuario;
	private UsuarioDaoImpl usuarioDaoImpl;
	private String tipoConta;
	private int turma;
	private TurmaDao turmaDao;
	private List<Turma> turmas;
	private List<SelectItem> turmasLista;
	

	public UsuarioBean() {
		usuario = new Usuario();
		turmas = new ArrayList<Turma>();
		turmasLista = new ArrayList<SelectItem>();
		turmaDao = new TurmaDaoImpl();
		
		turmas = turmaDao.list();
		for (Turma t : turmas) {
			System.out.println(t.getNome());
			turmasLista.add(new SelectItem(t.getId(), t.getNome()));
		}

	}

	public String verificaConta() {

		Usuario user = new Usuario();
		usuarioDaoImpl = new UsuarioDaoImpl();
		user = usuarioDaoImpl.buscarUsuarioPorEmaileSenha(usuario.getLogin(),
				usuario.getSenha());

		if (user == null) {
			return "falhou";
		}

		else {
			// grava sessão do usuario.
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext()
					.getSession(false);
			session.setAttribute("ID_USUARIO", user.getId());
			session.setAttribute("NOME_USUARIO", user.getNome());

			if (tipoConta.equalsIgnoreCase("Administrador")) {
				br.ufc.si.itest.dao.impl.AdiministradorDaoImpl dao = new AdiministradorDaoImpl();
				Administrador admin = new Administrador();
				admin = dao.verificaAdmin(user.getId());

				if (admin == null) {
					return "falhou";
				} else {
					session.setAttribute("admin", admin);
					return "sucessoAdmin";
				}

			} else if (tipoConta.equalsIgnoreCase("Aluno")) {
				AlunoDao alunoDao = new AlunoDaoImpl();
				Aluno aluno = new Aluno();
				aluno = alunoDao.getAlunoById(user.getId());

				if (aluno == null) {
					return "falhou";
				} else {

					List<Turma> turmas = aluno.getTurmas();

					if (turma == 0) {
						session.setAttribute("aluno", aluno);
						session.setAttribute("TURMA", turma);
						return "sucessoAluno";
					} else {

						for (Turma t : turmas) {
							if (t.getId() == turma) {
								session.setAttribute("aluno", aluno);
								session.setAttribute("TURMA", turma);
								return "sucessoAluno";
							}
						}

					}

					return "falhou";
				}

			} else if (tipoConta.equalsIgnoreCase("Professor")) {
				ProfessorDao profDao = new ProfessorDaoImpl();
				Professor prof = new Professor();
				prof = profDao.getProfessorById(user.getId());

				if (prof == null) {
					return "falhou";
				} else {
					session.setAttribute("prof", prof);
					return "sucessoProf";
				}
			}

			return "";
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public UsuarioDaoImpl getUsuarioDaoImpl() {
		return usuarioDaoImpl;
	}

	public void setUsuarioDaoImpl(UsuarioDaoImpl usuarioDaoImpl) {
		this.usuarioDaoImpl = usuarioDaoImpl;
	}

	public TurmaDao getTurmaDao() {
		return turmaDao;
	}

	public void setTurmaDao(TurmaDao turmaDao) {
		this.turmaDao = turmaDao;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<SelectItem> getTurmasLista() {
		return turmasLista;
	}

	public void setTurmasLista(List<SelectItem> turmasLista) {
		this.turmasLista = turmasLista;
	}

	public int getTurma() {
		return turma;
	}

	public void setTurma(int turma) {
		this.turma = turma;
	}

}
