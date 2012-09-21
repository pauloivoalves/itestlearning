/**
 * 
 */
package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import br.ufc.si.itest.dao.JogoDao;
import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.UsuarioDao;
import br.ufc.si.itest.dao.impl.JogoDaoImpl;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.UsuarioDaoImpl;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.model.CriterioAceitacao;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.model.ItemTeste;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.Jogo.JogoPk;
import br.ufc.si.itest.model.NivelDificuldade;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.model.Usuario;

/**
 * @author Virginia
 * 
 */
public class JogoBean {
	/* Classes de modelo */
	private Jogo jogo;
	private Usuario usuario;

	/* DAOs */
	private JogoDao jogoDao;
	private UsuarioDao usuarioDao;
	private ProjetoDao projetoDao;

	/* Beans dependentes */
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

	/* Construtor */
	public JogoBean() {
		usuario = new Usuario();
		jogo = new Jogo();
		jogo.setPontuacao(0);

		projetoBean = new ProjetoBean();
		nivelDificuldadeBean = new NivelDificuldadeBean();
		itemTesteBean = new ItemTesteBean();
		tipoTesteBean = new TipoTesteBean();
		nivelTesteBean = new NivelTesteBean();
		criterioAceitacaoBean = new CriterioAceitacaoBean();
		artefatoBean = new ArtefatoBean();
		ferramentaBean = new FerramentaBean();

		ranking = false;
		jogoDao = new JogoDaoImpl();
		usuarioDao = new UsuarioDaoImpl();
		projetoDao = new ProjetoDaoImpl();

		projetos = new ArrayList<SelectItem>();
		carregaTodosProjeto();
	}

	public void carregaProjetos() {
		projetoBean.setProjetos(new ArrayList<SelectItem>());
		List<Projeto> projs = projetoBean.getProjetoDao()
				.getProjetoByNivelDificuldade(
						new NivelDificuldade(nivelDificuldadeEscolhido));
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

		// Carrega todo o conteúdo do projeto.
		carregarItensTeste();
		carregarTiposTeste();
		carregarNiveisTeste();
		carregarCriteriosAceitacao();
		carregarArtefatos();
		carregarFerramentas();

		return "descricaoProjeto";
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

	public String validarItensTeste() {
		if (!itemTesteBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ itemTesteBean.validaResposta());
		}
		return "tiposTeste";
	}

	public String validarTipoTeste() {
		if (!tipoTesteBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ tipoTesteBean.validaResposta());
		}
		return "niveisTeste";
	}

	public String validarNiveisTeste() {
		if (!nivelTesteBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ nivelTesteBean.validaResposta());
		}
		return "criterioAceitacao";
	}

	public String validarCriteriosAceitacao() {
		if (!criterioAceitacaoBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ criterioAceitacaoBean.validaResposta());
		}
		return "ferramentas";
	}

	public String validarFerramentas() {
		if (!ferramentaBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ ferramentaBean.validaResposta());
		}
		return "artefatos";
	}

	public String validarArtefatos() {
		if (!artefatoBean.getRespondido()) {
			jogo.setPontuacao(jogo.getPontuacao()
					+ artefatoBean.validaResposta());
		}
		return "resultado";
	}

	public String adicionarRanking() {
		this.ranking = true;
		usuario.setLogin("login");
		usuario.setSenha("senha");
		usuarioDao.save(usuario);
		jogo.setPk(new JogoPk());
		jogo.getPk().setProjeto(projetoBean.getProjeto());
		jogo.getPk().setUsuario(usuario);
		jogoDao.save(jogo);
		jogos = jogoDao.getJogoByProjeto(projetoRanking);
		// encerra sessão aberta
		FacesContext faces = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) faces.getExternalContext()
				.getSession(false);
		session.invalidate();
		return "ranking";
	}

	public String terminarJogo() {
		// encerra sessão aberta
		FacesContext faces = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) faces.getExternalContext()
				.getSession(false);
		session.invalidate();

		return "escolhaProjeto";
	}

	/* Getters e Setters */
	public ProjetoBean getProjetoBean() {
		return projetoBean;
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

}
