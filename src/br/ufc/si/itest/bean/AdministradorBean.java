package br.ufc.si.itest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import br.ufc.si.itest.dao.ArtefatoDao;
import br.ufc.si.itest.dao.ArtefatoProjetoDao;
import br.ufc.si.itest.dao.CriterioAceitacaoDao;
import br.ufc.si.itest.dao.FerramentaDao;
import br.ufc.si.itest.dao.FerramentaProjetoDao;
import br.ufc.si.itest.dao.ItemTesteDao;
import br.ufc.si.itest.dao.NivelDificuldadeDao;
import br.ufc.si.itest.dao.NivelTesteDao;
import br.ufc.si.itest.dao.NivelTesteProjetoDao;
import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.TipoTesteDao;
import br.ufc.si.itest.dao.TipoTesteProjetoDao;
import br.ufc.si.itest.dao.impl.ArtefatoDaoImpl;
import br.ufc.si.itest.dao.impl.ArtefatoProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.CriterioAceitacaoDaoImpl;
import br.ufc.si.itest.dao.impl.FerramentaDaoImpl;
import br.ufc.si.itest.dao.impl.FerramentaProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.ItemTesteDaoImpl;
import br.ufc.si.itest.dao.impl.NivelDificuldadeDaoImpl;
import br.ufc.si.itest.dao.impl.NivelTesteDaoImpl;
import br.ufc.si.itest.dao.impl.NivelTesteProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.TipoTesteDaoImpl;
import br.ufc.si.itest.dao.impl.TipoTesteProjetoDaoImpl;
import br.ufc.si.itest.model.Administrador;
import br.ufc.si.itest.model.Artefato;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.model.ArtefatoProjeto.ArtefatoProjetoPk;
import br.ufc.si.itest.model.CriterioAceitacao;
import br.ufc.si.itest.model.Ferramenta;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.model.FerramentaProjeto.FerramentaProjetoPk;
import br.ufc.si.itest.model.ItemTeste;
import br.ufc.si.itest.model.NivelDificuldade;
import br.ufc.si.itest.model.NivelTeste;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.model.NivelTesteProjeto.NivelTesteProjetoPk;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.model.TipoTeste;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.model.TipoTesteProjeto.TipoTesteProjetoPk;

public class AdministradorBean {
	private ProjetoDao projetoDao;
	private FerramentaDao ferramentaDao;
	private CriterioAceitacaoDao criterioDao;
	private ArtefatoDao artefatoDao;
	private ItemTesteDao itemDao;
	private NivelTesteDao nivelDao;
	private TipoTesteDao tipoDao;
	private Projeto projeto;
	private NivelDificuldade nivel_dificuldade;
	private List<Projeto> meus_projetos;
	private List<Ferramenta> ferramentas;
	private List<CriterioAceitacao> criterios;
	private List<Artefato> artefatos;
	private List<ItemTeste> itens_teste;
	private List<NivelTeste> niveis_teste;
	private List<TipoTeste> tipos_teste;

	private FerramentaProjetoDao ferramenta_proj_dao;
	private ArtefatoProjetoDao artefato_proj_dao;
	private NivelTesteProjetoDao nivel_proj_dao;
	private TipoTesteProjetoDao tipo_projeto_dao;
	private List<ArtefatoProjeto> artefatos_projeto;
	private List<FerramentaProjeto> ferramenta_projeto;
	private List<NivelTesteProjeto> nivel_teste_projeto;
	private List<TipoTesteProjeto> tipo_teste_projeto;

	private Ferramenta ferramenta;
	private Artefato artefato;
	private NivelTeste nivel;
	private TipoTeste tipo;
	private CriterioAceitacao criterio;
	private ItemTeste item;
	private Administrador adm;

	private List<String> nomesFerramentas;
	private List<String> nomesArtefatos;
	private List<String> nomesNiveis;
	private List<String> nomesTipos;

	private ArtefatoProjeto artefatoprojeto;
	private FerramentaProjeto ferramentaProjeto;
	private NivelTesteProjeto nivelTesteProjeto;
	private TipoTesteProjeto tipoTesteProjeto;

	// private Professor professor;

	public ProjetoDao getProjetoDao() {
		return projetoDao;
	}

	public void setProjetoDao(ProjetoDao projetoDao) {
		this.projetoDao = projetoDao;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Projeto> getMeus_projetos() {
		return meus_projetos;
	}

	public void setMeus_projetos(List<Projeto> meus_projetos) {
		this.meus_projetos = meus_projetos;
	}

	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

	public List<CriterioAceitacao> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<CriterioAceitacao> criterios) {
		this.criterios = criterios;
	}

	public List<Artefato> getArtefatos() {
		return artefatos;
	}

	public void setArtefatos(List<Artefato> artefatos) {
		this.artefatos = artefatos;
	}

	public List<ItemTeste> getItens_teste() {
		return itens_teste;
	}

	public void setItens_teste(List<ItemTeste> itens_teste) {
		this.itens_teste = itens_teste;
	}

	public List<NivelTeste> getNiveis_teste() {
		return niveis_teste;
	}

	public void setNiveis_teste(List<NivelTeste> niveis_teste) {
		this.niveis_teste = niveis_teste;
	}

	public List<TipoTeste> getTipos_teste() {
		return tipos_teste;
	}

	public void setTipos_teste(List<TipoTeste> tipos_teste) {
		this.tipos_teste = tipos_teste;
	}

	public FerramentaDao getFerramentaDao() {
		return ferramentaDao;
	}

	public void setFerramentaDao(FerramentaDao ferramentaDao) {
		this.ferramentaDao = ferramentaDao;
	}

	public NivelDificuldade getNivel_dificuldade() {
		return nivel_dificuldade;
	}

	public void setNivel_dificuldade(NivelDificuldade nivel_dificuldade) {
		this.nivel_dificuldade = nivel_dificuldade;
	}

	public CriterioAceitacaoDao getCriterioDao() {
		return criterioDao;
	}

	public void setCriterioDao(CriterioAceitacaoDao criterioDao) {
		this.criterioDao = criterioDao;
	}

	public ArtefatoDao getArtefatoDao() {
		return artefatoDao;
	}

	public void setArtefatoDao(ArtefatoDao artefatoDao) {
		this.artefatoDao = artefatoDao;
	}

	public ItemTesteDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemTesteDao itemDao) {
		this.itemDao = itemDao;
	}

	public NivelTesteDao getNivelDao() {
		return nivelDao;
	}

	public void setNivelDao(NivelTesteDao nivelDao) {
		this.nivelDao = nivelDao;
	}

	public TipoTesteDao getTipoDao() {
		return tipoDao;
	}

	public void setTipoDao(TipoTesteDao tipoDao) {
		this.tipoDao = tipoDao;
	}

	public FerramentaProjetoDao getFerramenta_proj_dao() {
		return ferramenta_proj_dao;
	}

	public void setFerramenta_proj_dao(FerramentaProjetoDao ferramenta_proj_dao) {
		this.ferramenta_proj_dao = ferramenta_proj_dao;
	}

	public ArtefatoProjetoDao getArtefato_proj_dao() {
		return artefato_proj_dao;
	}

	public void setArtefato_proj_dao(ArtefatoProjetoDao artefato_proj_dao) {
		this.artefato_proj_dao = artefato_proj_dao;
	}

	public NivelTesteProjetoDao getNivel_proj_dao() {
		return nivel_proj_dao;
	}

	public void setNivel_proj_dao(NivelTesteProjetoDao nivel_proj_dao) {
		this.nivel_proj_dao = nivel_proj_dao;
	}

	public TipoTesteProjetoDao getTipo_projeto_dao() {
		return tipo_projeto_dao;
	}

	public void setTipo_projeto_dao(TipoTesteProjetoDao tipo_projeto_dao) {
		this.tipo_projeto_dao = tipo_projeto_dao;
	}

	public List<FerramentaProjeto> getFerramenta_projeto() {
		return ferramenta_projeto;
	}

	public void setFerramenta_projeto(List<FerramentaProjeto> ferramenta_projeto) {
		this.ferramenta_projeto = ferramenta_projeto;
	}

	public List<NivelTesteProjeto> getNivel_teste_projeto() {
		return nivel_teste_projeto;
	}

	public void setNivel_teste_projeto(
			List<NivelTesteProjeto> nivel_teste_projeto) {
		this.nivel_teste_projeto = nivel_teste_projeto;
	}

	public List<TipoTesteProjeto> getTipo_teste_projeto() {
		return tipo_teste_projeto;
	}

	public void setTipo_teste_projeto(List<TipoTesteProjeto> tipo_teste_projeto) {
		this.tipo_teste_projeto = tipo_teste_projeto;
	}

	public List<ArtefatoProjeto> getArtefatos_projeto() {
		return artefatos_projeto;
	}

	public void setArtefatos_projeto(List<ArtefatoProjeto> artefatos_projeto) {
		this.artefatos_projeto = artefatos_projeto;
	}

	public Ferramenta getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	public Artefato getArtefato() {
		return artefato;
	}

	public void setArtefato(Artefato artefato) {
		this.artefato = artefato;
	}

	public NivelTeste getNivel() {
		return nivel;
	}

	public void setNivel(NivelTeste nivel) {
		this.nivel = nivel;
	}

	public TipoTeste getTipo() {
		return tipo;
	}

	public void setTipo(TipoTeste tipo) {
		this.tipo = tipo;
	}

	public CriterioAceitacao getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioAceitacao criterio) {
		this.criterio = criterio;
	}

	public ItemTeste getItem() {
		return item;
	}

	public void setItem(ItemTeste item) {
		this.item = item;
	}

	public Administrador getAdm() {
		return adm;
	}

	public void setAdm(Administrador adm) {
		this.adm = adm;
	}

	public List<String> getNomesFerramentas() {
		return nomesFerramentas;
	}

	public void setNomesFerramentas(List<String> nomesFerramentas) {
		this.nomesFerramentas = nomesFerramentas;
	}

	public List<String> getNomesArtefatos() {
		return nomesArtefatos;
	}

	public void setNomesArtefatos(List<String> nomesArtefatos) {
		this.nomesArtefatos = nomesArtefatos;
	}

	public List<String> getNomesNiveis() {
		return nomesNiveis;
	}

	public void setNomesNiveis(List<String> nomesNiveis) {
		this.nomesNiveis = nomesNiveis;
	}

	public List<String> getNomesTipos() {
		return nomesTipos;
	}

	public void setNomesTipos(List<String> nomesTipos) {
		this.nomesTipos = nomesTipos;
	}

	public ArtefatoProjeto getArtefatoprojeto() {
		return artefatoprojeto;
	}

	public void setArtefatoprojeto(ArtefatoProjeto artefatoprojeto) {
		this.artefatoprojeto = artefatoprojeto;
	}

	public FerramentaProjeto getFerramentaProjeto() {
		return ferramentaProjeto;
	}

	public void setFerramentaProjeto(FerramentaProjeto ferramentaProjeto) {
		this.ferramentaProjeto = ferramentaProjeto;
	}

	public NivelTesteProjeto getNivelTesteProjeto() {
		return nivelTesteProjeto;
	}

	public void setNivelTesteProjeto(NivelTesteProjeto nivelTesteProjeto) {
		this.nivelTesteProjeto = nivelTesteProjeto;
	}

	public TipoTesteProjeto getTipoTesteProjeto() {
		return tipoTesteProjeto;
	}

	public void setTipoTesteProjeto(TipoTesteProjeto tipoTesteProjeto) {
		this.tipoTesteProjeto = tipoTesteProjeto;
	}

	public AdministradorBean() {
		projeto = new Projeto();
		projetoDao = new ProjetoDaoImpl();
		ferramentaDao = new FerramentaDaoImpl();
		criterioDao = new CriterioAceitacaoDaoImpl();
		artefatoDao = new ArtefatoDaoImpl();
		itemDao = new ItemTesteDaoImpl();
		nivelDao = new NivelTesteDaoImpl();
		tipoDao = new TipoTesteDaoImpl();
		ferramenta_proj_dao = new FerramentaProjetoDaoImpl();
		tipo_projeto_dao = new TipoTesteProjetoDaoImpl();
		nivel_proj_dao = new NivelTesteProjetoDaoImpl();
		artefato_proj_dao = new ArtefatoProjetoDaoImpl();

		meus_projetos = new ArrayList<Projeto>();
		ferramentas = new ArrayList<Ferramenta>();
		criterios = new ArrayList<CriterioAceitacao>();
		artefatos = new ArrayList<Artefato>();
		itens_teste = new ArrayList<ItemTeste>();
		niveis_teste = new ArrayList<NivelTeste>();
		tipos_teste = new ArrayList<TipoTeste>();

		artefatos_projeto = new ArrayList<ArtefatoProjeto>();
		ferramenta_projeto = new ArrayList<FerramentaProjeto>();
		nivel_teste_projeto = new ArrayList<NivelTesteProjeto>();
		tipo_teste_projeto = new ArrayList<TipoTesteProjeto>();

		nivel_dificuldade = new NivelDificuldade();

		ferramenta = new Ferramenta();
		artefato = new Artefato();
		nivel = new NivelTeste();
		criterio = new CriterioAceitacao();
		item = new ItemTeste();
		tipo = new TipoTeste();

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				false);

		adm = (Administrador) session.getAttribute("admin");

		nomesFerramentas = new ArrayList<String>();
		nomesArtefatos = new ArrayList<String>();
		nomesNiveis = new ArrayList<String>();
		nomesTipos = new ArrayList<String>();

		artefatoprojeto = new ArtefatoProjeto();
		ferramentaProjeto = new FerramentaProjeto();
		nivelTesteProjeto = new NivelTesteProjeto();
		tipoTesteProjeto = new TipoTesteProjeto();

		inicializar();
	}

	private void inicializar() {
		this.meus_projetos = projetoDao.list();
	}

	private void limpar() {

		try {
			ferramentas.clear();
			criterios.clear();
			artefatos.clear();
			itens_teste.clear();
			niveis_teste.clear();
			tipos_teste.clear();

			artefatos_projeto.clear();
			ferramenta_projeto.clear();
			nivel_teste_projeto.clear();
			tipo_teste_projeto.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// métodos relacionados a visualizações

	public String visualizarProjeto() {
		limpar();

		itens_teste = itemDao.getItensTesteByProjeto(this.projeto.getId());
		criterios = criterioDao.getCriterioAceitacaoByProjeto(this.projeto
				.getId());
		artefatos_projeto = artefato_proj_dao
				.getArtefatProjetoByIdProjeto(this.projeto.getId());
		ferramenta_projeto = ferramenta_proj_dao
				.getFerramentaProjetoByIdProjeto(this.projeto.getId());
		nivel_teste_projeto = nivel_proj_dao
				.getNivelTesteProjetoByIdProjeto(this.projeto.getId());
		tipo_teste_projeto = tipo_projeto_dao
				.getTipoTesteProjetoByIdProjeto(this.projeto.getId());

		for (ArtefatoProjeto ap : artefatos_projeto) {
			artefatos.add(ap.getPk().getArtefato());
		}

		for (FerramentaProjeto fp : ferramenta_projeto) {
			ferramentas.add(fp.getPk().getFerramenta());
		}

		for (NivelTesteProjeto ntp : nivel_teste_projeto) {
			niveis_teste.add(ntp.getPk().getNivelTeste());
		}

		for (TipoTesteProjeto ttp : tipo_teste_projeto) {
			tipos_teste.add(ttp.getPk().getTipoTeste());
		}

		return "admin_visual_proj.jsf";
	}

	public List<SelectItem> getProjetosCadastrados() {
		List<SelectItem> projetos = new ArrayList<SelectItem>();

		this.meus_projetos = projetoDao.list();

		for (Projeto proj : meus_projetos) {
			projetos.add(new SelectItem(proj.getId(), proj.getNome()));
		}

		return projetos;
	}

	public List<SelectItem> getNiveisDificuldade() {
		List<SelectItem> niveis_dificuldade = new ArrayList<SelectItem>();
		NivelDificuldadeDao ndf = new NivelDificuldadeDaoImpl();

		List<NivelDificuldade> niveis = ndf.list();

		for (NivelDificuldade elem : niveis) {
			niveis_dificuldade
					.add(new SelectItem(elem.getId(), elem.getNome()));
		}

		return niveis_dificuldade;
	}

	public List<SelectItem> getFerramentascadastradas() {
		List<SelectItem> ferramentasItens = new ArrayList<SelectItem>();
		this.ferramentas = ferramentaDao.list();

		for (Ferramenta elem : this.ferramentas) {
			ferramentasItens.add(new SelectItem(elem.getId(), elem.getNome()));
		}

		return ferramentasItens;
	}

	public List<SelectItem> getArtefatoscadastrados() {
		List<SelectItem> artefatosItens = new ArrayList<SelectItem>();
		this.artefatos = artefatoDao.list();

		for (Artefato elem : this.artefatos) {
			artefatosItens.add(new SelectItem(elem.getId(), elem.getNome()));
		}

		return artefatosItens;
	}

	public List<SelectItem> getNiveisCadastrados() {
		List<SelectItem> niveisItens = new ArrayList<SelectItem>();
		this.niveis_teste = nivelDao.list();

		for (NivelTeste elem : this.niveis_teste) {
			niveisItens.add(new SelectItem(elem.getId(), elem.getNome()));
		}

		return niveisItens;
	}

	public List<SelectItem> getTiposCadastrados() {
		List<SelectItem> tiposItens = new ArrayList<SelectItem>();
		tipos_teste = tipoDao.list();

		for (TipoTeste elem : this.tipos_teste) {
			tiposItens.add(new SelectItem(elem.getId(), elem.getNome()));
		}

		return tiposItens;
	}

	public String addProjeto() {
		NivelDificuldadeDao ndd = new NivelDificuldadeDaoImpl();
		nivel_dificuldade = ndd.getNivelDificuldadeById(this
				.getNivel_dificuldade().getId());
		this.projeto.setNivelDificuldade(this.getNivel_dificuldade());
		projetoDao.save(this.getProjeto());
		projeto = new Projeto();
		projeto.setNivelDificuldade(new NivelDificuldade());
		this.meus_projetos = this.projetoDao.list();
		return "admin_index.jsf";
	}

	public String visualizarFerramentas() {
		ferramentas = ferramentaDao.list();
		return "admin_visual_ferramentas.jsf";
	}

	public String visualizarArtefatos() {
		artefatos = artefatoDao.list();
		return "admin_visual_artefatos.jsf";
	}

	public String visualizarNiveisTeste() {
		niveis_teste = nivelDao.list();
		return "admin_visual_niveis_teste.jsf";
	}

	public String visualizarTiposTeste() {
		tipos_teste = tipoDao.list();
		return "admin_visual_tipos_teste.jsf";
	}

	public String visualizarCriteriosAceitacao() {
		criterios = criterioDao.list();
		return "admin_visual_criterios_aceitacao.jsf";
	}

	public String visualizarItensTeste() {
		itens_teste = itemDao.list();
		return "admin_visual_itens_teste.jsf";
	}

	// métodos relacionados a atualizações
	public String atualizarFerramenta() {
		ferramentaDao.update(this.ferramenta);
		ferramenta = new Ferramenta();
		ferramentas = ferramentaDao.list();
		return "admin_visual_ferramentas.jsf";
	}

	public String atualizarArtefato() {
		artefatoDao.update(artefato);
		artefato = new Artefato();
		artefatos = artefatoDao.list();
		return "admin_visual_artefatos.jsf";
	}

	public String atualizarNivelTeste() {
		nivelDao.update(nivel);
		nivel = new NivelTeste();
		niveis_teste = nivelDao.list();
		return "admin_visual_niveis_teste.jsf";
	}

	public String atualizarCriterioAceitação() {
		ProjetoDao pd = new ProjetoDaoImpl();
		criterio.setProjeto(pd.getProjetoById(criterio.getProjeto().getId()));
		criterioDao.update(criterio);
		criterio = new CriterioAceitacao();
		criterios = criterioDao.list();
		return "admin_visual_criterios_aceitacao.jsf";
	}

	public String atualizarTipoTeste() {
		tipoDao.update(tipo);
		tipo = new TipoTeste();
		tipos_teste = tipoDao.list();
		return "admin_visual_tipos_teste.jsf";
	}

	public String atualizarItensTeste() {
		ProjetoDao pd = new ProjetoDaoImpl();
		item.setProjeto(pd.getProjetoById(item.getProjeto().getId()));
		itemDao.update(item);
		item = new ItemTeste();
		itens_teste = itemDao.list();
		return "admin_visual_itens_teste.jsf";
	}

	// métodos relacionados a remoções
	public String removerFerramenta() {
		try {
			ferramentaDao.remove(ferramenta);
		} catch (Exception e) {
			e.printStackTrace();
			return "admin_visual_ferramentas.jsf";
		}
		ferramenta = new Ferramenta();
		ferramentas = ferramentaDao.list();
		return "admin_visual_ferramentas.jsf";
	}

	public String removerArtefato() {
		try {
			artefatoDao.remove(artefato);
		} catch (Exception e) {
			return "admin_visual_artefatos.jsf";
		}
		artefato = new Artefato();
		artefatos = artefatoDao.list();
		return "admin_visual_artefatos.jsf";
	}

	public String removerNivelTeste() {
		try {
			nivelDao.remove(nivel);
		} catch (Exception e) {
			return "admin_visual_niveis_teste.jsf";
		}
		nivel = new NivelTeste();
		niveis_teste = nivelDao.list();
		return "admin_visual_niveis_teste.jsf";
	}

	public String removerCriterioAceitação() {
		try {
			criterioDao.remove(criterio);
		} catch (Exception e) {
			return "admin_visual_Criterios_acetação.jsf";
		}
		criterio = new CriterioAceitacao();
		criterios = criterioDao.list();
		return "admin_visual_Criterios_acetação.jsf";
	}

	public String removerTipoTeste() {
		try {
			tipoDao.remove(tipo);
		} catch (Exception e) {
			return "admin_visual_tipos_teste.jsf";
		}
		tipo = new TipoTeste();
		tipos_teste = tipoDao.list();
		return "admin_visual_tipos_teste.jsf";
	}

	public String removerItensTeste() {
		try {
			itemDao.remove(item);
		} catch (Exception e) {
			return "admin_visual_itens_teste.jsf";
		}
		item = new ItemTeste();
		itens_teste = itemDao.list();
		return "admin_visual_itens_teste.jsf";
	}

	public String visualFerramentasPro() {
		ferramentas = ferramentaDao.list();
		return "admin_add_ferr_projeto.jsf";
	}

	public String visualArtefatosPro() {
		artefatos = artefatoDao.list();
		return "admin_add_artef_projeto.jsf";
	}

	public String visualNiveisPro() {
		niveis_teste = nivelDao.list();
		return "admin_add_niveis_projeto.jsf";
	}

	public String visualTiposPro() {
		tipos_teste = tipoDao.list();
		return "admin_add_tipos_projeto.jsf";
	}

	public String addFerramentaProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());
		ferramenta = ferramentaDao.getFerramentaById(ferramenta.getId());

		FerramentaProjetoPk fpk = new FerramentaProjetoPk();
		fpk.setFerramenta(ferramenta);
		fpk.setProjeto(projeto);
		ferramentaProjeto.setPk(fpk);
		ferramenta_proj_dao.save(ferramentaProjeto);

		artefatos.clear();

		artefatos_projeto = artefatoDao.getArtefatosByProjeto(projeto.getId());
		for (ArtefatoProjeto elem : artefatos_projeto) {
			artefatos.add(elem.getPk().getArtefato());
		}

		ferramentas.clear();

		List<FerramentaProjeto> ferramentasProjeto = ferramentaDao
				.getItensTesteByProjeto(projeto.getId());
		for (FerramentaProjeto elem : ferramentasProjeto) {
			ferramentas.add(elem.getPk().getFerramenta());
		}

		niveis_teste.clear();

		nivel_teste_projeto = nivelDao.getItensTesteByProjeto(projeto.getId());
		for (NivelTesteProjeto elem : nivel_teste_projeto) {
			niveis_teste.add(elem.getPk().getNivelTeste());
		}

		tipos_teste.clear();

		tipo_teste_projeto = tipoDao.getItensTesteByProjeto(projeto.getId());
		for (TipoTesteProjeto elem : tipo_teste_projeto) {
			tipos_teste.add(elem.getPk().getTipoTeste());
		}
		return "admin_visual_proj.jsf";
	}

	public String addArtefatoProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());
		artefato = artefatoDao.getArtefatoById(artefato.getId());

		ArtefatoProjetoPk apk = new ArtefatoProjetoPk();
		apk.setArtefato(artefato);
		apk.setProjeto(projeto);
		artefatoprojeto.setPk(apk);

		artefato_proj_dao.save(artefatoprojeto);

		artefatos.clear();

		artefatos_projeto = artefatoDao.getArtefatosByProjeto(projeto.getId());
		for (ArtefatoProjeto elem : artefatos_projeto) {
			artefatos.add(elem.getPk().getArtefato());
		}

		ferramentas.clear();

		List<FerramentaProjeto> ferramentasProjeto = ferramentaDao
				.getItensTesteByProjeto(projeto.getId());
		for (FerramentaProjeto elem : ferramentasProjeto) {
			ferramentas.add(elem.getPk().getFerramenta());
		}

		niveis_teste.clear();

		nivel_teste_projeto = nivelDao.getItensTesteByProjeto(projeto.getId());
		for (NivelTesteProjeto elem : nivel_teste_projeto) {
			niveis_teste.add(elem.getPk().getNivelTeste());
		}

		tipos_teste.clear();

		tipo_teste_projeto = tipoDao.getItensTesteByProjeto(projeto.getId());
		for (TipoTesteProjeto elem : tipo_teste_projeto) {
			tipos_teste.add(elem.getPk().getTipoTeste());
		}

		return "admin_visual_proj.jsf";
	}

	public String addNivelTesteProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());
		nivel = nivelDao.getNivelTesteById(nivel.getId());

		NivelTesteProjetoPk ntpk = new NivelTesteProjetoPk();
		ntpk.setNivelTeste(nivel);
		ntpk.setProjeto(projeto);
		nivelTesteProjeto.setPk(ntpk);

		nivel_proj_dao.save(nivelTesteProjeto);

		artefatos.clear();

		artefatos_projeto = artefatoDao.getArtefatosByProjeto(projeto.getId());
		for (ArtefatoProjeto elem : artefatos_projeto) {
			artefatos.add(elem.getPk().getArtefato());
		}

		ferramentas.clear();

		List<FerramentaProjeto> ferramentasProjeto = ferramentaDao
				.getItensTesteByProjeto(projeto.getId());
		for (FerramentaProjeto elem : ferramentasProjeto) {
			ferramentas.add(elem.getPk().getFerramenta());
		}

		niveis_teste.clear();

		nivel_teste_projeto = nivelDao.getItensTesteByProjeto(projeto.getId());
		for (NivelTesteProjeto elem : nivel_teste_projeto) {
			niveis_teste.add(elem.getPk().getNivelTeste());
		}

		tipos_teste.clear();

		tipo_teste_projeto = tipoDao.getItensTesteByProjeto(projeto.getId());
		for (TipoTesteProjeto elem : tipo_teste_projeto) {
			tipos_teste.add(elem.getPk().getTipoTeste());
		}
		return "admin_visual_proj.jsf";
	}

	public String addTipoTesteProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());
		tipo = tipoDao.getTipoTesteById(tipo.getId());

		TipoTesteProjetoPk ttpk = new TipoTesteProjetoPk();
		ttpk.setTipoTeste(tipo);
		ttpk.setProjeto(projeto);
		tipoTesteProjeto.setPk(ttpk);

		tipo_projeto_dao.save(tipoTesteProjeto);

		artefatos.clear();

		artefatos_projeto = artefatoDao.getArtefatosByProjeto(projeto.getId());
		for (ArtefatoProjeto elem : artefatos_projeto) {
			artefatos.add(elem.getPk().getArtefato());
		}

		ferramentas.clear();

		List<FerramentaProjeto> ferramentasProjeto = ferramentaDao
				.getItensTesteByProjeto(projeto.getId());
		for (FerramentaProjeto elem : ferramentasProjeto) {
			ferramentas.add(elem.getPk().getFerramenta());
		}

		niveis_teste.clear();

		nivel_teste_projeto = nivelDao.getItensTesteByProjeto(projeto.getId());
		for (NivelTesteProjeto elem : nivel_teste_projeto) {
			niveis_teste.add(elem.getPk().getNivelTeste());
		}

		tipos_teste.clear();

		tipo_teste_projeto = tipoDao.getItensTesteByProjeto(projeto.getId());
		for (TipoTesteProjeto elem : tipo_teste_projeto) {
			tipos_teste.add(elem.getPk().getTipoTeste());
		}
		return "admin_visual_proj.jsf";
	}

	public String removerArtefatoProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());

		ArtefatoProjeto ap = new ArtefatoProjeto();
		ArtefatoProjetoPk apk = new ArtefatoProjetoPk();
		apk.setArtefato(artefato);
		apk.setProjeto(projeto);
		ap.setPk(apk);

		artefato_proj_dao.remove(ap);

		artefatos.clear();

		artefatos_projeto = artefatoDao.getArtefatosByProjeto(projeto.getId());
		for (ArtefatoProjeto elem : artefatos_projeto) {
			artefatos.add(elem.getPk().getArtefato());
		}

		return "admin_visual_proj.jsf";
	}

	public String removerFerramentaProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());
		FerramentaProjeto fp = new FerramentaProjeto();
		FerramentaProjetoPk fpk = new FerramentaProjetoPk();
		fpk.setFerramenta(ferramenta);
		fpk.setProjeto(projeto);
		fp.setPk(fpk);
		ferramenta_proj_dao.remove(fp);

		ferramentas.clear();

		List<FerramentaProjeto> ferramentasProjeto = ferramentaDao
				.getItensTesteByProjeto(projeto.getId());
		for (FerramentaProjeto elem : ferramentasProjeto) {
			ferramentas.add(elem.getPk().getFerramenta());
		}

		return "admin_visual_proj.jsf";
	}

	public String removerNivelTesteProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());

		NivelTesteProjeto ntp = new NivelTesteProjeto();

		NivelTesteProjetoPk ntpk = new NivelTesteProjetoPk();
		ntpk.setNivelTeste(nivel);
		ntpk.setProjeto(projeto);
		ntp.setPk(ntpk);

		nivel_proj_dao.remove(ntp);

		niveis_teste.clear();

		nivel_teste_projeto = nivelDao.getItensTesteByProjeto(projeto.getId());
		for (NivelTesteProjeto elem : nivel_teste_projeto) {
			niveis_teste.add(elem.getPk().getNivelTeste());
		}

		return "admin_visual_proj.jsf";
	}

	public String removerTipoTesteProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());

		TipoTesteProjeto ttp = new TipoTesteProjeto();

		TipoTesteProjetoPk ttpk = new TipoTesteProjetoPk();
		ttpk.setTipoTeste(tipo);
		ttpk.setProjeto(projeto);
		ttp.setPk(ttpk);

		tipo_projeto_dao.remove(ttp);

		tipos_teste.clear();

		tipo_teste_projeto = tipoDao.getItensTesteByProjeto(projeto.getId());
		for (TipoTesteProjeto elem : tipo_teste_projeto) {
			tipos_teste.add(elem.getPk().getTipoTeste());
		}
		return "admin_visual_proj.jsf";
	}

	public String removerProjeto() {
		projeto = projetoDao.getProjetoById(projeto.getId());

		artefatos_projeto = artefatoDao.getArtefatosByProjeto(projeto.getId());
		for (ArtefatoProjeto ap : artefatos_projeto) {
			artefato_proj_dao.remove(ap);
		}

		ferramenta_projeto = ferramentaDao.getItensTesteByProjeto(projeto
				.getId());
		for (FerramentaProjeto fp : ferramenta_projeto) {
			ferramenta_proj_dao.remove(fp);
		}

		nivel_teste_projeto = nivelDao.getItensTesteByProjeto(projeto.getId());
		for (NivelTesteProjeto ntp : nivel_teste_projeto) {
			nivel_proj_dao.remove(ntp);
		}

		tipo_teste_projeto = tipoDao.getItensTesteByProjeto(projeto.getId());
		for (TipoTesteProjeto ttp : tipo_teste_projeto) {
			tipo_projeto_dao.remove(ttp);
		}

		criterios = criterioDao.getCriterioAceitacaoByProjeto(projeto.getId());
		for (CriterioAceitacao ca : criterios) {
			criterioDao.remove(ca);
		}

		itens_teste = itemDao.getItensTesteByProjeto(projeto.getId());
		for (ItemTeste it : itens_teste) {
			itemDao.remove(it);
		}

		projetoDao.remove(projeto);

		return "admin_escolher_projeto.jsf";
	}

}
