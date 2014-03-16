/**
 * 
 */
package br.ufc.si.itest.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.ufc.si.itest.dao.JogoDao;
import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.SimuladoDao;
import br.ufc.si.itest.dao.UsuarioDao;
import br.ufc.si.itest.dao.impl.CasoDeTesteDaoImpl;
import br.ufc.si.itest.dao.impl.JogoDaoImpl;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.SimuladoDaoImpl;
import br.ufc.si.itest.dao.impl.UsuarioDaoImpl;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.model.CasoDeTeste;
import br.ufc.si.itest.model.CriterioAceitacao;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.model.ItemTeste;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.Jogo.JogoPk;
import br.ufc.si.itest.model.NivelDificuldade;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.model.Simulado;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.model.Usuario;
import br.ufc.si.itest.utils.Utils;

/**
 * @author Virginia
 * 
 */
public class JogoBean {

	/* Auxiliares */
	int indice;
	int id;
	int indiceCdt;
	int idTurma;
	String nome;

	// fase execução
	private String dados;
	private String formulario;
	private List<SelectItem> sel;
	private List<String> selecionadosExec;
	private boolean execResposta;
	private boolean flag = false;
	private String casoTesteAtual;
	private boolean resp;
	private List<CasoDeTeste> casosValidos;
	private List<CasoDeTeste> casosInvalidos;

	/* Classes de modelo */
	private Jogo jogo;
	private Usuario usuario;
	private Aluno aluno;

	/* DAOs */
	private JogoDao jogoDao;
	private UsuarioDao usuarioDao;
	private ProjetoDao projetoDao;

	/* Beans dependentes */
	private CasoDeTesteBean casodeTesteBean;

	public JogoDao getJogoDao() {
		return jogoDao;
	}

	public void setJogoDao(JogoDao jogoDao) {
		this.jogoDao = jogoDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public ProjetoDao getProjetoDao() {
		return projetoDao;
	}

	public void setProjetoDao(ProjetoDao projetoDao) {
		this.projetoDao = projetoDao;
	}

	public CasoDeTesteBean getCasodeTesteBean() {
		return casodeTesteBean;
	}

	public void setCasodeTesteBean(CasoDeTesteBean casodeTesteBean) {
		this.casodeTesteBean = casodeTesteBean;
	}

	public CasoDeUsoBean getCasoDeUsoBean() {
		return casoDeUsoBean;
	}

	public void setCasoDeUsoBean(CasoDeUsoBean casoDeUsoBean) {
		this.casoDeUsoBean = casoDeUsoBean;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public List<CasoDeTeste> getCasosDeTesteSel() {
		return casosDeTesteSel;
	}

	public void setCasosDeTesteSel(List<CasoDeTeste> casosDeTesteSel) {
		this.casosDeTesteSel = casosDeTesteSel;
	}

	public List<SelectItem> getSel() {
		return sel;
	}

	public void setSel(List<SelectItem> sel) {
		this.sel = sel;
	}

	public List<String> getSelecionadosExec() {
		return selecionadosExec;
	}

	public void setSelecionadosExec(List<String> selecionadosExec) {
		this.selecionadosExec = selecionadosExec;
	}

	public boolean getExecResposta() {
		return execResposta;
	}

	public void setExecResposta(boolean execResposta) {
		this.execResposta = execResposta;
	}

	public String getCasoTesteAtual() {
		return casoTesteAtual;
	}

	public void setCasoTesteAtual(String casoTesteAtual) {
		this.casoTesteAtual = casoTesteAtual;
	}

	private CasoDeUsoBean casoDeUsoBean;
	private ProjetoBean projetoBean;
	private NivelDificuldadeBean nivelDificuldadeBean;
	private ItemTesteBean itemTesteBean;
	private TipoTesteBean tipoTesteBean;
	private NivelTesteBean nivelTesteBean;
	private CriterioAceitacaoBean criterioAceitacaoBean;
	private ArtefatoBean artefatoBean;
	private FerramentaBean ferramentaBean;

	/* Propriedades auxiliares */
	private Integer nivelDificuldadeEscolhido;
	private Integer projetoEscolhido;
	private Integer projetoRanking;
	private Boolean ranking;
	private List<Jogo> jogos;
	private List<SelectItem> projetos;
	private List<CasoDeTeste> casosDeTesteSel;

	/* Construtor */
	public JogoBean() {

		ServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = (HttpSession) request.getSession();
		id = (Integer) session.getAttribute("ID_USUARIO");
		nome = (String) session.getAttribute("NOME_USUARIO");

		try {
			idTurma = (Integer) session.getAttribute("TURMA");
		} catch (Exception e) {
			e.printStackTrace();
		}
		indice = 0;
		indiceCdt = 0;
		casosDeTesteSel = new ArrayList<CasoDeTeste>();
		aluno = new Aluno();
		aluno.setId(id);
		usuario = new Usuario();
		jogo = new Jogo();
		jogo.setPontuacao(0);
		sel = new ArrayList<SelectItem>();
		selecionadosExec = new ArrayList<String>();
		casodeTesteBean = new CasoDeTesteBean();
		casoDeUsoBean = new CasoDeUsoBean();
		projetoBean = new ProjetoBean();
		nivelDificuldadeBean = new NivelDificuldadeBean();
		itemTesteBean = new ItemTesteBean();
		tipoTesteBean = new TipoTesteBean();
		nivelTesteBean = new NivelTesteBean();
		criterioAceitacaoBean = new CriterioAceitacaoBean();
		artefatoBean = new ArtefatoBean();
		ferramentaBean = new FerramentaBean();
		casosValidos = new ArrayList<CasoDeTeste>();
		casosInvalidos = new ArrayList<CasoDeTeste>();
		ranking = false;
		jogoDao = new JogoDaoImpl();
		usuarioDao = new UsuarioDaoImpl();
		projetoDao = new ProjetoDaoImpl();

		projetos = new ArrayList<SelectItem>();
		carregaTodosProjeto();
	}

	public void carregaProjetos() {
		projetoBean.setProjetos(new ArrayList<SelectItem>());
		List<Projeto> projs;
		if (idTurma == 0) {
			projs = projetoBean.getProjetoDao().getProjetoByNivelDificuldade(
					new NivelDificuldade(nivelDificuldadeEscolhido));
		} else {
			projs = new ArrayList<Projeto>();
			SimuladoDao simuladoDao = new SimuladoDaoImpl();
			List<Simulado> simulados = new ArrayList<Simulado>();
			simulados = simuladoDao.getSimuladoByTurma(idTurma);

			List<Projeto> projetos = projetoBean.getProjetoDao()
					.getProjetoByNivelDificuldade(
							new NivelDificuldade(nivelDificuldadeEscolhido));
			for (Simulado s : simulados) {
				for (Projeto p : projetos) {
					if (s.getProjeto().getId() == p.getId()) {
						projs.add(p);
						break;
					}
				}
			}
		}

		for (Projeto p : projs) {
			projetoBean.getProjetos().add(
					new SelectItem(p.getId(), p.getNome()));
		}
	}

	public void carregaTodosProjeto() {
		List<Projeto> projs = projetoDao.list();
		for (Projeto p : projs) {
			projetos.add(new SelectItem(p.getId(), p.getNome()));
		}
	}

	public void carregaRanking() {
		jogos = jogoDao.getJogoByProjeto(projetoRanking);
	}

	public String iniciarJogo() {
		projetoBean.setProjeto(projetoBean.getProjetoDao().getProjetoById(
				projetoEscolhido));

		// verifica se algum projeto foi escolhido
		if (projetoBean.getProjeto() == null) {
			return "escolhaprojeto";
		}

		// Carrega todo o conteúdo do projeto.
		carregarItensTeste();
		carregarTiposTeste();
		carregarNiveisTeste();
		carregarCriteriosAceitacao();
		carregarArtefatos();
		carregarFerramentas();

		// checa se aquele projeto tem caso de uso
		if (!casoDeUsoBean.getCasoDeUsoDao()
				.getCasoDeUsoByIdProjeto(projetoBean.getProjeto().getId())
				.isEmpty()) {
			carregarCasoDeUso();
		}

		return "descricaoProjeto";
	}

	public String carregarExecucao() throws IOException {
		List<CasoDeTeste> casosDeTeste = new ArrayList<CasoDeTeste>();
		CasoDeTesteDaoImpl cdti = new CasoDeTesteDaoImpl();
		casosDeTeste = cdti.getCasoDeTesteByIdCasoDeUso(casoDeUsoBean
				.getCasoDeUso().getId());
		carregaFeedback(casosDeTeste);
		for (String c : casodeTesteBean.getCasoDeTesteSelecionados()) {
			System.out.println(c);
			for (CasoDeTeste caso : casosDeTeste) {
				if (caso.getId() == Integer.parseInt(c)) {
					casosDeTesteSel.add(caso);
				}
			}
		}

		carregarFaseExecucao();

		return "";
	}

	public void carregaFeedback(List<CasoDeTeste> casos) {
		for (CasoDeTeste c : casos) {
			if (c.getResposta() == true) {
				casosValidos.add(c);
			} else {
				casosInvalidos.add(c);
			}
		}
	}

	public String carregarFaseExecucao() throws IOException {

		if (flag == true) {
			if (resp == execResposta) {
				jogo.setPontuacao(jogo.getPontuacao()
						+ validaRespostaCorreta(projetoBean.getProjeto()
								.getNivelDificuldade().getId()));
			} else {
				jogo.setPontuacao(jogo.getPontuacao()
						+ validaRespostaIncorreta(projetoBean.getProjeto()
								.getNivelDificuldade().getId()));
			}
		}

		if (indiceCdt < casosDeTesteSel.size()) {
			casoTesteAtual = casosDeTesteSel.get(indiceCdt).getDescricao();
			formaCadastro(casosDeTesteSel.get(indiceCdt));
			resp = casosDeTesteSel.get(indiceCdt).getResposta();
			indiceCdt++;
			flag = true;
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("fase_execucao_ativo.xhtml");
		} else {
			carregarProximoCasoUso();
		}

		return "";
	}

	public Integer validaRespostaCorreta(int nivelDificuldade) {
		Integer pontuacao = 0;

		if (nivelDificuldade == 1) {
			pontuacao = pontuacao + Utils.PONTO_POSITIVO;
		}

		if (nivelDificuldade == 2) {
			pontuacao = pontuacao + Utils.PONTO_POSITIVO_MEDIO;
		}

		if (nivelDificuldade == 3) {
			pontuacao = pontuacao + Utils.PONTO_POSITIVO_MEDIO;
		}
		return pontuacao;
	}

	public Integer validaRespostaIncorreta(int nivelDificuldade) {
		Integer pontuacao = 0;
		if (nivelDificuldade == 1) {
			pontuacao = pontuacao + Utils.PONTO_NEGATIVO;
		}

		if (nivelDificuldade == 2) {
			pontuacao = pontuacao + Utils.PONTO_NEGATIVO_MEDIO;
		}

		if (nivelDificuldade == 3) {
			pontuacao = pontuacao + Utils.PONTO_NEGATIVO_DIFICIL;
		}

		return pontuacao;
	}

	public void montaOpcoes() {
		sel = new ArrayList<SelectItem>();
		sel.add(new SelectItem(true, "caso de teste válido"));
		sel.add(new SelectItem(false, "caso de teste inválido"));
	}

	public void formaCadastro(CasoDeTeste caso) {
		montaOpcoes();
		dados = caso.getDados();
		String tipo = caso.getTipo();
		String[] campos = caso.getCampos().split(",");
		formulario = "<input id='tipo"
				+ "' value='"
				+ tipo
				+ "' type='hidden"
				+ "'/>"
				+ "<input id='dados"
				+ "' value='"
				+ dados
				+ "' type='hidden"
				+ "'/>"
				+ "<h3 class='exec"
				+ "'>Execute o sistema</h3><input id='msgm' type='hidden' value='"
				+ caso.getMensagemSistema() + "'>";
		for (int i = 0; i < campos.length; i++) {
			formulario += "<label class='exec" + "'for=" + campos[i] + ">"
					+ campos[i] + ": </label for=" + campos[i]
					+ "><input class='campo exec" + "'" + "id='camp" + i
					+ "'></br></br>";
		}
		formulario += "<input class='exec" + "'type='" + "button" + "' value='"
				+ "executar" + "'onclick='cadastro()'";

	}

	public void carregarProximoCasoUso() throws IOException {
		// validarCasoDeTeste();
		++indice;
		if (indice < casoDeUsoBean.getCasoDeUsoProjeto().size()) {
			System.out.println("1");
			casoDeUsoBean.setCasoDeUso(casoDeUsoBean.getCasoDeUsoProjeto().get(
					indice));
			casodeTesteBean.setCasoDeTesteSelecionados(new ArrayList<String>());
			casodeTesteBean
					.setCasosDeTesteProjeto(new ArrayList<CasoDeTeste>());
			casodeTesteBean.setCasosDeTeste(new ArrayList<SelectItem>());
			carregarCasoDeTeste();
			casodeTesteBean.setRespondido(false);

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("fase_projeto.xhtml");

		} else {
			// aqui redirecione pra página final
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("resultado_fase_projeto.xhtml");
		}
	}

	public void carregarCasoDeUso() {
		casoDeUsoBean.setCasoDeUsoProjeto(casoDeUsoBean.getCasoDeUsoDao()
				.getCasoDeUsoByIdProjeto(projetoBean.getProjeto().getId()));
		casoDeUsoBean.setCasoDeUso(casoDeUsoBean.getCasoDeUsoProjeto().get(
				indice));
		carregarCasoDeTeste();
	}

	public void carregarCasoDeTeste() {
		casodeTesteBean.setCasosDeTesteProjeto(casodeTesteBean
				.getCasoDeTesteDao().getCasoDeTesteByIdCasoDeUso(
						casoDeUsoBean.getCasoDeUso().getId()));
		for (CasoDeTeste cdt : casodeTesteBean.getCasosDeTesteProjeto())
			casodeTesteBean.getCasosDeTeste().add(
					new SelectItem(cdt.getId(), cdt.getDescricao()));
	}

	public void carregarItensTeste() {
		itemTesteBean.setItensTesteProjeto(itemTesteBean.getItemTesteDao()
				.getItensTesteByProjeto(projetoBean.getProjeto().getId()));
		itemTesteBean.setItensTeste(new ArrayList<SelectItem>());
		for (ItemTeste it : itemTesteBean.getItensTesteProjeto()) {
			itemTesteBean.getItensTeste().add(
					new SelectItem(it.getId(), it.getDescricao()));
		}
	}

	public void carregarTiposTeste() {
		tipoTesteBean.setTiposTesteProjeto(tipoTesteBean.getTipoTesteDao()
				.getItensTesteByProjeto(projetoBean.getProjeto().getId()));
		tipoTesteBean.setTiposTeste(new ArrayList<SelectItem>());
		for (TipoTesteProjeto tt : tipoTesteBean.getTiposTesteProjeto()) {
			tipoTesteBean.getTiposTeste().add(
					new SelectItem(tt.getPk().getTipoTeste().getId(), tt
							.getPk().getTipoTeste().getNome()));
		}
	}

	public void carregarNiveisTeste() {
		nivelTesteBean.setNiveisTesteProjeto(nivelTesteBean.getNivelTesteDao()
				.getItensTesteByProjeto(projetoBean.getProjeto().getId()));
		nivelTesteBean.setNiveisTeste(new ArrayList<SelectItem>());
		for (NivelTesteProjeto nt : nivelTesteBean.getNiveisTesteProjeto()) {
			nivelTesteBean.getNiveisTeste().add(
					new SelectItem(nt.getPk().getNivelTeste().getId(), nt
							.getPk().getNivelTeste().getNome()));
		}
	}

	public void carregarCriteriosAceitacao() {
		criterioAceitacaoBean
				.setCriteriosAceitacaoProjeto(criterioAceitacaoBean
						.getCriterioAceitacaoDao()
						.getCriterioAceitacaoByProjeto(
								projetoBean.getProjeto().getId()));
		criterioAceitacaoBean
				.setCriteriosAceitacao(new ArrayList<SelectItem>());
		for (CriterioAceitacao ca : criterioAceitacaoBean
				.getCriteriosAceitacaoProjeto()) {
			criterioAceitacaoBean.getCriteriosAceitacao().add(
					new SelectItem(ca.getId(), ca.getDescricao()));
		}
	}

	public void carregarArtefatos() {
		artefatoBean.setArtefatosProjeto(artefatoBean.getArtefatoDao()
				.getArtefatosByProjeto(projetoBean.getProjeto().getId()));
		artefatoBean.setArtefatos(new ArrayList<SelectItem>());
		for (ArtefatoProjeto ap : artefatoBean.getArtefatosProjeto()) {
			artefatoBean.getArtefatos().add(
					new SelectItem(ap.getPk().getArtefato().getId(), ap.getPk()
							.getArtefato().getNome()));
		}
	}

	public void carregarFerramentas() {
		ferramentaBean.setFerramentasProjeto(ferramentaBean.getFerramentaDao()
				.getItensTesteByProjeto(projetoBean.getProjeto().getId()));
		ferramentaBean.setFerramentas(new ArrayList<SelectItem>());
		for (FerramentaProjeto fp : ferramentaBean.getFerramentasProjeto()) {
			ferramentaBean.getFerramentas().add(
					new SelectItem(fp.getPk().getFerramenta().getId(), fp
							.getPk().getFerramenta().getNome()));
		}
	}

	public void validarCasoDeTeste() {

		if (!casodeTesteBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ casodeTesteBean.validaResposta(projetoBean.getProjeto()
							.getNivelDificuldade().getId()));
		}

	}

	public String validarItensTeste() {
		if (!itemTesteBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ itemTesteBean.validaResposta(projetoBean.getProjeto()
							.getNivelDificuldade().getId()));
		}
		return "tiposTeste";
	}

	public String validarTipoTeste() {
		if (!tipoTesteBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ tipoTesteBean.validaResposta(projetoBean.getProjeto()
							.getNivelDificuldade().getId()));
		}
		return "niveisTeste";
	}

	public String validarNiveisTeste() {
		if (!nivelTesteBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ nivelTesteBean.validaResposta(projetoBean.getProjeto()
							.getNivelDificuldade().getId()));
		}
		return "criterioAceitacao";
	}

	public String validarCriteriosAceitacao() {
		if (!criterioAceitacaoBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ criterioAceitacaoBean.validaResposta(projetoBean
							.getProjeto().getNivelDificuldade().getId()));
		}
		return "ferramentas";
	}

	public String validarFerramentas() {
		if (!ferramentaBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ ferramentaBean.validaResposta(projetoBean.getProjeto()
							.getNivelDificuldade().getId()));
		}
		return "artefatos";
	}

	public String validarArtefatos() {
		if (!artefatoBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ artefatoBean.validaResposta(projetoBean.getProjeto()
							.getNivelDificuldade().getId()));
		}
		return "resultado";
	}

	public String adicionarRanking() {
		try {
			List<Jogo> jogosAux = jogoDao.getJogoByUsárioProjeto(id,
					projetoBean.getProjeto().getId());

			System.out.println(jogosAux.size());

			this.ranking = true;
			usuario.setId(id);
			usuario.setNome(nome);
			usuario.setLogin("login");
			usuario.setSenha("senha");

			// usuarioDao.save(usuario);
			jogo.setPk(new JogoPk());
			jogo.getPk().setProjeto(projetoBean.getProjeto());
			jogo.getPk().setUsuario(usuario);
			Date data = new Date();
			jogo.setData(data);
			jogo.setAluno(aluno);

			if (idTurma != 0) {
				jogo.setTurma(idTurma);
			} else {
				jogo.setTurma(0);
			}

			if (jogosAux.size() > 0) {
				jogoDao.update(jogo);
			} else {
				jogoDao.save(jogo);
			}
			jogos = jogoDao.getJogoByProjeto(projetoRanking);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		jogo = new Jogo();
		jogo.setPontuacao(0);
		indice = 0;

		casodeTesteBean = new CasoDeTesteBean();
		casoDeUsoBean = new CasoDeUsoBean();
		projetoBean = new ProjetoBean();
		nivelDificuldadeBean = new NivelDificuldadeBean();
		itemTesteBean = new ItemTesteBean();
		tipoTesteBean = new TipoTesteBean();
		nivelTesteBean = new NivelTesteBean();
		criterioAceitacaoBean = new CriterioAceitacaoBean();
		artefatoBean = new ArtefatoBean();
		ferramentaBean = new FerramentaBean();

		return "ranking";
	}

	public String logOut() {
		// encerra sessão aberta
		FacesContext faces = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) faces.getExternalContext()
				.getSession(false);
		session.invalidate();
		return "login.xhtml";
	}

	public String terminarJogo() {
		jogo = new Jogo();
		jogo.setPontuacao(0);
		indice = 0;

		casodeTesteBean = new CasoDeTesteBean();
		casoDeUsoBean = new CasoDeUsoBean();
		projetoBean = new ProjetoBean();
		nivelDificuldadeBean = new NivelDificuldadeBean();
		itemTesteBean = new ItemTesteBean();
		tipoTesteBean = new TipoTesteBean();
		nivelTesteBean = new NivelTesteBean();
		criterioAceitacaoBean = new CriterioAceitacaoBean();
		artefatoBean = new ArtefatoBean();
		ferramentaBean = new FerramentaBean();

		ranking = false;

		return "escolhaProjeto";
	}

	/* Getters e Setters */

	public ProjetoBean getProjetoBean() {
		return projetoBean;
	}

	public CasoDeUsoBean getFaseProjetoBean() {
		return casoDeUsoBean;
	}

	public void setFaseProjetoBean(CasoDeUsoBean faseProjetoBean) {
		this.casoDeUsoBean = faseProjetoBean;
	}

	public void setProjetoBean(ProjetoBean projetoBean) {
		this.projetoBean = projetoBean;
	}

	public NivelDificuldadeBean getNivelDificuldadeBean() {
		return nivelDificuldadeBean;
	}

	public void setNivelDificuldadeBean(
			NivelDificuldadeBean nivelDificuldadeBean) {
		this.nivelDificuldadeBean = nivelDificuldadeBean;
	}

	public Integer getNivelDificuldadeEscolhido() {
		return nivelDificuldadeEscolhido;
	}

	public void setNivelDificuldadeEscolhido(Integer nivelDificuldadeEscolhido) {
		this.nivelDificuldadeEscolhido = nivelDificuldadeEscolhido;
	}

	public Integer getProjetoEscolhido() {
		return projetoEscolhido;
	}

	public void setProjetoEscolhido(Integer projetoEscolhido) {
		this.projetoEscolhido = projetoEscolhido;
	}

	public ItemTesteBean getItemTesteBean() {
		return itemTesteBean;
	}

	public void setItemTesteBean(ItemTesteBean itemTesteBean) {
		this.itemTesteBean = itemTesteBean;
	}

	public TipoTesteBean getTipoTesteBean() {
		return tipoTesteBean;
	}

	public void setTipoTesteBean(TipoTesteBean tipoTesteBean) {
		this.tipoTesteBean = tipoTesteBean;
	}

	public NivelTesteBean getNivelTesteBean() {
		return nivelTesteBean;
	}

	public void setNivelTesteBean(NivelTesteBean nivelTesteBean) {
		this.nivelTesteBean = nivelTesteBean;
	}

	public CriterioAceitacaoBean getCriterioAceitacaoBean() {
		return criterioAceitacaoBean;
	}

	public void setCriterioAceitacaoBean(
			CriterioAceitacaoBean criterioAceitacaoBean) {
		this.criterioAceitacaoBean = criterioAceitacaoBean;
	}

	public ArtefatoBean getArtefatoBean() {
		return artefatoBean;
	}

	public void setArtefatoBean(ArtefatoBean artefatoBean) {
		this.artefatoBean = artefatoBean;
	}

	public FerramentaBean getFerramentaBean() {
		return ferramentaBean;
	}

	public void setFerramentaBean(FerramentaBean ferramentaBean) {
		this.ferramentaBean = ferramentaBean;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getRanking() {
		return ranking;
	}

	public void setRanking(Boolean ranking) {
		this.ranking = ranking;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Integer getProjetoRanking() {
		return projetoRanking;
	}

	public void setProjetoRanking(Integer projetoRanking) {
		this.projetoRanking = projetoRanking;
	}

	public List<SelectItem> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<SelectItem> projetos) {
		this.projetos = projetos;
	}

	public List<CasoDeTeste> getCasosValidos() {
		return casosValidos;
	}

	public void setCasosValidos(List<CasoDeTeste> casosValidos) {
		this.casosValidos = casosValidos;
	}

	public List<CasoDeTeste> getCasosInvalidos() {
		return casosInvalidos;
	}

	public void setCasosInvalidos(List<CasoDeTeste> casosInvalidos) {
		this.casosInvalidos = casosInvalidos;
	}

}
