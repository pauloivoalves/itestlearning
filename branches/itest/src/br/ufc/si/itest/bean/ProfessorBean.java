package br.ufc.si.itest.bean;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufc.si.itest.dao.AlunoDao;
import br.ufc.si.itest.dao.AlunoTurmaDao;
import br.ufc.si.itest.dao.JogoDao;
import br.ufc.si.itest.dao.ProfessorDao;
import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.SimuladoDao;
import br.ufc.si.itest.dao.TurmaDao;
import br.ufc.si.itest.dao.impl.AlunoDaoImpl;
import br.ufc.si.itest.dao.impl.AlunoTurmaDaoImpl;
import br.ufc.si.itest.dao.impl.JogoDaoImpl;
import br.ufc.si.itest.dao.impl.ProfessorDaoImpl;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.SimuladoDaoImpl;
import br.ufc.si.itest.dao.impl.TurmaDaoImpl;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.AlunoTurma;
import br.ufc.si.itest.model.AlunoTurma.AlunoTurmaPK;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.Professor;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.model.Simulado;
import br.ufc.si.itest.model.Turma;
import br.ufc.si.itest.utils.SendMail;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ProfessorBean {

	private Professor professor;
	private ProfessorDao profDao;
	private List<Professor> professores;
	private Turma turma;
	private List<Turma> turmas;
	private List<Aluno> alunos;
	private Aluno aluno;
	private List<Integer> ids_alunos;
	private Jogo jogo;
	private List<Jogo> jogos;
	private boolean contains_alunos;
	private Simulado simulado;
	private List<Simulado> simulados;
	private List<Projeto> projetos;
	private Projeto projeto;

	public boolean isContains_alunos() {
		if (alunos.isEmpty())
			return false;
		return true;
	}

	public void setContains_alunos(boolean contains_alunos) {
		this.contains_alunos = contains_alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ProfessorDao getProfDao() {
		return profDao;
	}

	public void setProfDao(ProfessorDao profDao) {
		this.profDao = profDao;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Integer> getIds_alunos() {
		return ids_alunos;
	}

	public void setIds_alunos(List<Integer> ids_alunos) {
		this.ids_alunos = ids_alunos;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Simulado getSimulado() {
		return simulado;
	}

	public void setSimulado(Simulado simulado) {
		this.simulado = simulado;
	}

	public List<Simulado> getSimulados() {
		return simulados;
	}

	public void setSimulados(List<Simulado> simulados) {
		this.simulados = simulados;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public ProfessorBean() {
		super();
		professor = new Professor();
		profDao = new ProfessorDaoImpl();
		professores = new ArrayList<Professor>();
		turma = new Turma();
		turmas = new ArrayList<Turma>();
		alunos = new ArrayList<Aluno>();
		aluno = new Aluno();
		ids_alunos = new ArrayList<Integer>();
		jogo = new Jogo();
		jogos = new ArrayList<Jogo>();
		simulado = new Simulado();
		simulados = new ArrayList<Simulado>();
		projeto = new Projeto();
		projetos = new ArrayList<Projeto>();

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				false);

		professor = (Professor) session.getAttribute("prof");

		try {
			carregarTurmas();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String cadastrarProfessor() {
		String msg = "Bem vindo ao Itest " + this.professor.getNome()
				+ ", sua senha: " + this.professor.getSenha();
		try {
			SendMail.enviarEmail(this.professor.getLogin(),
					"Criação de Conta no Itest", msg);
			profDao.save(professor);
			return "/admin_add_professor.xhtml";
		} catch (Exception e) {
			return "/admin_add_professor.xhtml";
		}

	}

	public String visualizarProfessores() {
		professores = profDao.list();
		return "admin_visual_professores.xhtml";
	}

	public String atualizarProfessor() {
		profDao.update(professor);
		professor = new Professor();
		professores = profDao.list();
		return "admin_visual_professores.xhtml";
	}

	public String removerProfessor() {
		profDao.delete(professor);
		professor = new Professor();
		professores = profDao.list();
		return "admin_visual_professores.xhtml";
	}

	public List<SelectItem> getTurmasSeleção() {
		List<SelectItem> turmaItens = new ArrayList<SelectItem>();
		TurmaDao turmaDao = new TurmaDaoImpl();
		turmas = turmaDao.list();
		for (Turma t : turmas) {
			turmaItens.add(new SelectItem(t.getId(), t.getNome()));
		}

		return turmaItens;
	}

	public List<SelectItem> getAlunosSelecao() {
		List<SelectItem> alunoItens = new ArrayList<SelectItem>();

		AlunoDao alunoDao = new AlunoDaoImpl();
		alunos = alunoDao.listarAlunos();

		for (Aluno a : alunos) {
			alunoItens.add(new SelectItem(a.getId(), a.getNome()));
		}

		return alunoItens;
	}

	public List<SelectItem> getSimuladosSelecao() {
		List<SelectItem> itensSimulado = new ArrayList<SelectItem>();

		SimuladoDao simdao = new SimuladoDaoImpl();
		simulados = simdao.list(professor.getId());

		if (simulados != null) {
			for (Simulado s : simulados) {
				itensSimulado.add(new SelectItem(s.getId(), s.getNome()));
			}
		}

		return itensSimulado;
	}

	public List<SelectItem> getProjetosSelecao() {
		List<SelectItem> itensProjeto = new ArrayList<SelectItem>();

		ProjetoDao projDao = new ProjetoDaoImpl();
		projetos = projDao.list();

		for (Projeto p : projetos) {
			itensProjeto.add(new SelectItem(p.getId(), p.getNome()));
		}

		return itensProjeto;

	}

	public String AdicionarTurma() {
		TurmaDao turmaDao = new TurmaDaoImpl();
		turma.setProfessor(getProfessor());
		turmaDao.save(turma);

		turma = new Turma();
		turmas = turmaDao.carregarTurmasProfessor(professor.getId());
		return "prof_visual_turmas.jsf";
	}

	public void carregarTurmas() {
		TurmaDao turmaDao = new TurmaDaoImpl();
		turmas = turmaDao.carregarTurmasProfessor(professor.getId());
	}

	public String editarTurma() {
		TurmaDao turmaDao = new TurmaDaoImpl();
		turma.setProfessor(getProfessor());
		turmaDao.update(turma);
		turma = new Turma();
		return "prof_index.jsf";
	}

	public String removerTurma() {
		TurmaDao turmaDao = new TurmaDaoImpl();
		turmaDao.delete(turma);
		turmas = turmaDao.carregarTurmasProfessor(professor.getId());
		turma = new Turma();
		return "prof_index.jsf";
	}

	public String carregarAlunosCadastados() {

		AlunoDao alunoDao = new AlunoDaoImpl();
		alunos = alunoDao.listarAlunos();

		return "prof_visual_alunos.jsf";
	}

	public String buscarAlunoPorEmail() {
		AlunoDao alunoDao = new AlunoDaoImpl();
		aluno = (Aluno) alunoDao.getAlunoByEmail(aluno.getLogin());
		return "prof_add_aluno_turma.jsf";
	}

	public String buscarAlunosTurma() {

		alunos.clear();

		AlunoTurmaDao aluno_turma_dao = new AlunoTurmaDaoImpl();

		List<AlunoTurma> alunosTurma = new ArrayList<AlunoTurma>();

		alunosTurma = aluno_turma_dao.getAlunoTurmaByIdTurma(turma.getId());

		for (AlunoTurma at : alunosTurma) {
			alunos.add(at.getPk().getAluno());
		}

		return "prof_visual_aluno_turma.jsf";
	}

	public String AddAlunoTurma() {
		TurmaDao turmaDao = new TurmaDaoImpl();
		turma = turmaDao.getTurmaById(turma.getId());

		AlunoTurma aluno_turma = new AlunoTurma();
		AlunoTurmaPK pk = new AlunoTurmaPK();

		AlunoTurmaDao aluno_turma_dao = new AlunoTurmaDaoImpl();

		pk.setAluno(aluno);
		pk.setTurma(turma);

		aluno_turma.setPk(pk);

		aluno_turma_dao.save(aluno_turma);

		List<AlunoTurma> alunosTurma = new ArrayList<AlunoTurma>();

		alunosTurma = aluno_turma_dao.getAlunoTurmaByIdTurma(turma.getId());

		alunos.clear();

		for (AlunoTurma at : alunosTurma) {
			alunos.add(at.getPk().getAluno());
		}

		return "prof_visual_alunos.jsf";
	}

	public String AddAlunosTurma() {
		TurmaDao turmaDao = new TurmaDaoImpl();
		turma = turmaDao.getTurmaById(turma.getId());

		AlunoDao alunoDao = new AlunoDaoImpl();

		AlunoTurma aluno_turma = new AlunoTurma();
		AlunoTurmaPK pk = new AlunoTurmaPK();

		AlunoTurmaDao aluno_turma_dao = new AlunoTurmaDaoImpl();

		for (int i = 0; i < ids_alunos.size(); i++) {

			aluno = (Aluno) alunoDao.getAlunoById(Integer.parseInt(""
					+ ids_alunos.get(i)));

			pk.setAluno(aluno);
			pk.setTurma(turma);
			aluno_turma.setPk(pk);
			aluno_turma_dao.save(aluno_turma);

		}

		alunos.clear();

		List<AlunoTurma> alunosTurma = new ArrayList<AlunoTurma>();

		alunosTurma = aluno_turma_dao.getAlunoTurmaByIdTurma(turma.getId());

		for (AlunoTurma at : alunosTurma) {
			alunos.add(at.getPk().getAluno());
		}

		return "prof_visual_alunos.jsf";

	}

	public String removerAlunoTurma() {

		alunos.clear();

		AlunoTurmaDao aluno_turma_dao = new AlunoTurmaDaoImpl();

		List<AlunoTurma> alunosTurma = new ArrayList<AlunoTurma>();

		AlunoTurmaPK pk = new AlunoTurmaPK();
		AlunoTurma aluno_turma = new AlunoTurma();

		pk.setAluno(getAluno());
		pk.setTurma(getTurma());

		aluno_turma.setPk(pk);

		aluno_turma_dao.remove(aluno_turma);

		alunosTurma = aluno_turma_dao.getAlunoTurmaByIdTurma(turma.getId());

		for (AlunoTurma at : alunosTurma) {
			alunos.add(at.getPk().getAluno());
		}

		return "prof_visual_aluno_turma.jsf";
	}

	public String visualizarJogosAluno() {
		JogoDao jogo_dao = new JogoDaoImpl();
		jogos = jogo_dao.getJogoByUsuario(aluno.getId());
		return "prof_visual_jogos_aluno.jsf";
	}

	public String CadastrarSimulado() {
		SimuladoDao simDao = new SimuladoDaoImpl();
		ProjetoDao projDao = new ProjetoDaoImpl();
		TurmaDao turmaDao = new TurmaDaoImpl();

		projeto = projDao.getProjetoById(projeto.getId());
		turma = turmaDao.getTurmaById(turma.getId());

		simulado.setProjeto(projeto);
		simulado.setTurma(turma);
		simulado.setProfessor(professor);

		simDao.save(simulado);

		simulados = simDao.list(professor.getId());

		return "prof_visual_simulados.jsf";
	}

	public String visualizarSimulados() {
		SimuladoDao simDao = new SimuladoDaoImpl();

		simulados = simDao.list(professor.getId());

		return "prof_visual_simulados.jsf";
	}

	public String resultadoSimulado() {
		alunos.clear();
		TurmaDao tdao = new TurmaDaoImpl();
		turma = tdao.getTurmaById(simulado.getTurma().getId());

		AlunoTurmaDao atd = new AlunoTurmaDaoImpl();
		List<AlunoTurma> at = atd.getAlunoTurmaByIdTurma(this.turma.getId());

		for (AlunoTurma elem : at) {
			alunos.add(elem.getPk().getAluno());
		}

		return "prof_visual_res_simulado.jsf";
	}

	public void rankingGeral(ActionEvent event) throws IOException {

		jogos = new ArrayList<Jogo>();
		JogoDao jogoDao = new JogoDaoImpl();
		ProjetoDao projetoDao = new ProjetoDaoImpl();
		jogos = jogoDao.getJogoByProjeto(projetoDao.getProjetoByName(
				simulado.getProjeto().getNome()).getId());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("prof_visual_jogos_aluno.jsf");

	}

	public void rankingTurma(ActionEvent event) throws IOException {

		jogos = new ArrayList<Jogo>();
		JogoDao jogoDao = new JogoDaoImpl();
		ProjetoDao projetoDao = new ProjetoDaoImpl();
		jogos = jogoDao.getJogoByTurmaProjeto(simulado.getTurma().getId(),
				projetoDao.getProjetoByName(simulado.getProjeto().getNome())
						.getId());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("prof_visual_jogos_aluno.jsf");

	}

	public String gerarRelatórioTurma() {

		TurmaDao tdao = new TurmaDaoImpl();
		this.turma = tdao.getTurmaById(turma.getId());
		AlunoDao adao = new AlunoDaoImpl();

		System.out.println(turma.getNome());

		AlunoTurmaDao aluno_turma_dao = new AlunoTurmaDaoImpl();

		List<AlunoTurma> alunosTurma = new ArrayList<AlunoTurma>();

		alunosTurma = aluno_turma_dao.getAlunoTurmaByIdTurma(turma.getId());

		alunos.clear();

		for (AlunoTurma at : alunosTurma) {
			alunos.add(at.getPk().getAluno());
		}

		System.out.println(alunos.size());

		try {
			// pega o contexto da aplicação, caso queria salvar o arquivo em um
			// diretório
			ServletContext ctx = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();

			// pega o contexto da resposta da requisição
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) fc
					.getCurrentInstance().getExternalContext().getResponse();
			HttpServletRequest request = (HttpServletRequest) fc
					.getCurrentInstance().getExternalContext().getRequest();

			response.setContentType("application/pdf");

			Document document = new Document();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			document.open();

			Image jpg = Image.getInstance("http://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()
					+ "/images/UFC.png");
			jpg.setAlignment(Image.LEFT | Image.UNDERLYING); /*
															 * Ajusta o
															 * alinhamento da
															 * imagem.
															 */

			Font fonteCabecalho = new Font(Font.TIMES_ROMAN, 12, Font.BOLD); /*
																			 * Será
																			 * usada
																			 * no
																			 * cabeçalho
																			 * .
																			 */
			Font fonteDesc = new Font(Font.NORMAL, 11, Font.BOLD); /*
																	 * Será
																	 * usada na
																	 * descrição
																	 * .
																	 */
			Font fonteConteudo = new Font(Font.NORMAL, 12, Font.NORMAL); /*
																		 * Será
																		 * usada
																		 * no
																		 * corpo
																		 * de
																		 * relatório
																		 * .
																		 */

			/* Tabela para o cabeçalho. */
			PdfPTable cabecalho = new PdfPTable(2);
			float[] widths = { 0.15f, 0.85f };
			cabecalho.setWidthPercentage(90);
			cabecalho.setWidths(widths);
			cabecalho.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

			cabecalho.addCell(jpg);
			cabecalho.addCell(new Phrase("Alunos Participantes da Turma de "
					+ this.turma.getNome(), fonteCabecalho));

			document.add(cabecalho);

			PdfPTable table = new PdfPTable(3);
			table.setSpacingBefore(5f); /* Coloca um espaço antes da tabela. */
			table.setWidthPercentage(90);
			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			widths = new float[] { 0.05f, 0.50f, 0.20f };
			table.setWidths(widths);
			table.getDefaultCell().setGrayFill(0.5f);

			table.addCell(new Phrase("Nº", fonteDesc));
			table.addCell(new Phrase("Nome", fonteDesc));
			table.addCell(new Phrase("E-mail", fonteDesc));

			for (int i = 0; alunos != null && i < alunos.size(); i++) {
				if (i % 2 == 0) {
					table.getDefaultCell().setBackgroundColor(Color.WHITE);
				} else {
					table.getDefaultCell().setGrayFill(0.80f);
				}
				Aluno a = alunos.get(i);
				table.addCell(new Phrase("" + (i + 1), fonteConteudo));
				table.addCell(new Phrase(a.getNome(), fonteConteudo));
				table.addCell(new Phrase(a.getLogin(), fonteConteudo));
			}
			document.add(table);

			document.close();
			response.setContentLength(baos.size());
			ServletOutputStream out = null;
			try {
				out = response.getOutputStream();
			} catch (IOException ex) {
				ex.printStackTrace();
				return "prof_visual_simulados.jsf";
			}
			try {
				baos.writeTo(out);
				out.flush();
				out.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				return "prof_visual_simulados.jsf";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return "prof_visual_simulados.jsf";
		}
		return "prof_visual_simulados.jsf";

	}

	public String RelatórioJogosAluno() {

		try {
			// pega o contexto da aplicação, caso queria salvar o arquivo em um
			// diretório
			ServletContext ctx = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();

			// pega o contexto da resposta da requisição
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) fc
					.getCurrentInstance().getExternalContext().getResponse();
			HttpServletRequest request = (HttpServletRequest) fc
					.getCurrentInstance().getExternalContext().getRequest();

			response.setContentType("application/pdf");

			Document document = new Document();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			document.open();

			Image jpg = Image.getInstance("http://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()
					+ "/images/UFC.png");
			jpg.setAlignment(Image.LEFT | Image.UNDERLYING); /*
															 * Ajusta o
															 * alinhamento da
															 * imagem.
															 */

			Font fonteCabecalho = new Font(Font.TIMES_ROMAN, 12, Font.BOLD); /*
																			 * Será
																			 * usada
																			 * no
																			 * cabeçalho
																			 * .
																			 */
			Font fonteDesc = new Font(Font.NORMAL, 11, Font.BOLD); /*
																	 * Será
																	 * usada na
																	 * descrição
																	 * .
																	 */
			Font fonteConteudo = new Font(Font.NORMAL, 12, Font.NORMAL); /*
																		 * Será
																		 * usada
																		 * no
																		 * corpo
																		 * de
																		 * relatório
																		 * .
																		 */

			/* Tabela para o cabeçalho. */
			PdfPTable cabecalho = new PdfPTable(2);
			float[] widths = { 0.15f, 0.85f };
			cabecalho.setWidthPercentage(90);
			cabecalho.setWidths(widths);
			cabecalho.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

			cabecalho.addCell(jpg);
			cabecalho.addCell(new Phrase("Relatório dos Projetos do Aluno "
					+ aluno.getNome(), fonteCabecalho));

			document.add(cabecalho);

			PdfPTable table = new PdfPTable(6);
			table.setSpacingBefore(5f); /* Coloca um espaço antes da tabela. */
			table.setWidthPercentage(90);
			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			widths = new float[] { 0.05f, 0.50f, 0.20f, 0.50f, 0.20f, 0,50f };
			table.setWidths(widths);
			table.getDefaultCell().setGrayFill(0.5f);

			table.addCell(new Phrase("Nº", fonteDesc));
			table.addCell(new Phrase("Nome", fonteDesc));
			table.addCell(new Phrase("Projeto", fonteDesc));
			table.addCell(new Phrase("Nível Dificuldade", fonteDesc));
			table.addCell(new Phrase("Pontuação", fonteDesc));
			table.addCell(new Phrase("Data", fonteDesc));

			for (int i = 0; jogos != null && i < jogos.size(); i++) {
				if (i % 2 == 0) {
					table.getDefaultCell().setBackgroundColor(Color.WHITE);
				} else {
					table.getDefaultCell().setGrayFill(0.80f);
				}
				Jogo j = jogos.get(i);
				table.addCell(new Phrase("" + (i + 1), fonteConteudo));
				table.addCell(new Phrase(j.getPk().getUsuario().getNome(), fonteConteudo));
				table.addCell(new Phrase(j.getPk().getProjeto().getNome(), fonteConteudo));
				table.addCell(new Phrase(j.getPk().getProjeto().getNivelDificuldade().getNome(), fonteConteudo));
				table.addCell(new Phrase( "" + j.getPontuacao(), fonteConteudo));
				table.addCell(new Phrase("" + j.getData(), fonteConteudo));
			}
			document.add(table);

			document.close();
			response.setContentLength(baos.size());
			ServletOutputStream out = null;
			try {
				out = response.getOutputStream();
			} catch (IOException ex) {
				ex.printStackTrace();
				return "prof_visual_jogos_aluno.jsf";
			}
			try {
				baos.writeTo(out);
				out.flush();
				out.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				return "prof_visual_jogos_aluno.jsf";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return "prof_visual_jogos_aluno.jsf";
		}
		return "prof_visual_jogos_aluno.jsf";

	}

}
