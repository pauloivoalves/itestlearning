package br.ufc.si.itest.adicionais;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufc.si.itest.dao.AlunoDao;
import br.ufc.si.itest.dao.AlunoTurmaDao;
import br.ufc.si.itest.dao.TurmaDao;
import br.ufc.si.itest.dao.impl.AlunoDaoImpl;
import br.ufc.si.itest.dao.impl.AlunoTurmaDaoImpl;
import br.ufc.si.itest.dao.impl.ArtefatoDaoImpl;
import br.ufc.si.itest.dao.impl.ArtefatoProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.CasoDeUsoDaoImpl;
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
import br.ufc.si.itest.dao.impl.TurmaDaoImpl;
import br.ufc.si.itest.dao.impl.UsuarioDaoImpl;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.AlunoTurma;
import br.ufc.si.itest.model.AlunoTurma.AlunoTurmaPK;
import br.ufc.si.itest.model.Artefato;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.model.CasoDeUso;
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
import br.ufc.si.itest.model.Turma;
import br.ufc.si.itest.model.Usuario;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.model.ArtefatoProjeto.ArtefatoProjetoPk;

// @author Felipe Freitas

public class InserirNoBanco {

	public void inserirFaseProjeto() {

		Scanner sc = new Scanner(System.in);

		CasoDeUso caso_de_uso = new CasoDeUso();
		CasoDeUsoDaoImpl fpdi = new CasoDeUsoDaoImpl();
		Projeto projeto = new Projeto();
		ProjetoDaoImpl pdi = new ProjetoDaoImpl();

		System.out.println("digite a descrição do fluxo principal se houver: ");
		String fp = sc.nextLine();
		System.out
				.println("digite a descrição do fluxo secundário se houver: ");
		String fs = sc.nextLine();
		System.out
				.println("digite a descrição do fluxo de exceção se houver:  ");
		String fe = sc.nextLine();
		System.out.println("digite a descrição de requisito se houver:  ");
		String req = sc.nextLine();
		System.out
				.println("digite a descrição a nivel de requisito se houver:  ");
		String nreq = sc.nextLine();
		System.out.println("digite o nome do Projeto Correspondente:  ");
		String nome = sc.nextLine();
		System.out.println("digite a descrição da alternativa se houver:  ");
		String desc = sc.nextLine();
		System.out.println("digite a resposta se houver:  ");
		boolean resposta = sc.nextBoolean();
		System.out.println("digite a mensagem se houver:  ");
		String mensagem = sc.nextLine();

		projeto = pdi.getProjetoByName(nome);

		
		caso_de_uso.setDesc_fluxo_principal(fp);
		caso_de_uso.setDesc_fluxo_secundario(fs);
		caso_de_uso.setDesc_requisito(req);
		caso_de_uso.setDesc_nivel_requisito(nreq);
		caso_de_uso.setProjeto(projeto);
		//faseProjeto.setDescricao(desc);
		//faseProjeto.setResposta(resposta);
		//faseProjeto.setMensagem(mensagem);

		fpdi.save(caso_de_uso);

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * CasoDeUso faseProjeto = new CasoDeUso(); CasoDeUsoDaoImpl fpdi = new
		 * CasoDeUsoDaoImpl(); Projeto projeto = new Projeto(); ProjetoDaoImpl
		 * pdi = new ProjetoDaoImpl();
		 * 
		 * System.out.println("digite a descrição do fluxo principal se houver: "
		 * ); String fp = sc.nextLine(); System.out
		 * .println("digite a descrição do fluxo secundário se houver: ");
		 * String fs = sc.nextLine(); System.out
		 * .println("digite a descrição do fluxo de exceção se houver:  ");
		 * String fe = sc.nextLine();
		 * System.out.println("digite a descrição de requisito se houver:  ");
		 * String req = sc.nextLine(); System.out
		 * .println("digite a descrição a nivel de requisito se houver:  ");
		 * String nreq = sc.nextLine();
		 * System.out.println("digite o nome do Projeto Correspondente:  ");
		 * String nome = sc.nextLine();
		 * System.out.println("digite a descrição da alternativa se houver:  ");
		 * String desc = sc.nextLine();
		 * System.out.println("digite a resposta se houver:  "); boolean
		 * resposta = sc.nextBoolean();
		 * System.out.println("digite a mensagem se houver:  "); String mensagem
		 * = sc.nextLine();
		 * 
		 * projeto = pdi.getProjetoByName(nome);
		 * 
		 * faseProjeto.setDesc_fluxo_excecao(fe);
		 * faseProjeto.setDesc_fluxo_principal(fp);
		 * faseProjeto.setDesc_fluxo_secundario(fs);
		 * faseProjeto.setDesc_requisito(req);
		 * faseProjeto.setDesc_nivel_requisito(nreq);
		 * faseProjeto.setProjeto(projeto); faseProjeto.setDescricao(desc);
		 * faseProjeto.setResposta(resposta); faseProjeto.setMensagem(mensagem);
		 * 
		 * fpdi.save(faseProjeto);
		 */
	}

	public void inserirProjeto() {
		Scanner sc = new Scanner(System.in);
		ProjetoDaoImpl pdi = new ProjetoDaoImpl();
		Projeto projeto = new Projeto();
		NivelDificuldadeDaoImpl ndfi = new NivelDificuldadeDaoImpl();
		NivelDificuldade nivel = new NivelDificuldade();

		System.out.println("digite o nome do projeto: ");
		String nome = sc.nextLine();
		System.out.println("digite a descrição do projeto: ");
		String descricao = sc.nextLine();
		System.out.println("digite o nivel de dificuldade do projeto: ");
		String nivel_dificuldade = sc.next();

		nivel = ndfi.getNivelDificuldadeByName(nivel_dificuldade);

		projeto.setNome(nome);
		projeto.setDescricao(descricao);
		projeto.setNivelDificuldade(nivel);

		pdi.save(projeto);

	}

	public void inserirUsuario() {
		Scanner sc = new Scanner(System.in);
		UsuarioDaoImpl udi = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();

		System.out.println("digite o nome do usuário: ");
		String nome_usuario = sc.nextLine();
		System.out.println("digite o login do usuário: ");
		String login = sc.next();
		System.out.println("digite a senha do usuário: ");
		String senha = sc.next();

		usuario.setLogin(login);
		usuario.setNome(nome_usuario);
		usuario.setSenha(senha);

		udi.save(usuario);
	}

	public void inserirArtefato() {
		Scanner sc = new Scanner(System.in);
		ArtefatoDaoImpl adi = new ArtefatoDaoImpl();
		Artefato artefato = new Artefato();

		System.out.println("digite o nome do artefato: ");
		String nome_artefato = sc.nextLine();
		System.out.println("digite a descrição do artefato: ");
		String descricao_artefato = sc.nextLine();

		artefato.setNome(nome_artefato);
		artefato.setDescricao(descricao_artefato);

		adi.save(artefato);

	}
	
	
	
	public void inserirTurma(){
		Scanner sc = new Scanner(System.in);
		TurmaDao turmaDao = new TurmaDaoImpl();
		Turma turma = new Turma();
		
		System.out.println("digite o nome da turma: ");
		String nome_turma = sc.nextLine();
		
		turma.setNome(nome_turma);
		turmaDao.save(turma);	
		
	}
	

	public void inserirNivelTeste() {
		Scanner sc = new Scanner(System.in);
		NivelTesteDaoImpl ntdi = new NivelTesteDaoImpl();
		NivelTeste nivelTeste = new NivelTeste();

		System.out.println("digite o nome do nivel de teste: ");
		String nome_nivelTeste = sc.nextLine();
		System.out.println("digite a descrição do nivel de teste: ");
		String descricao_nivelTeste = sc.nextLine();

		nivelTeste.setNome(nome_nivelTeste);
		nivelTeste.setDescricao(descricao_nivelTeste);

		ntdi.save(nivelTeste);

	}

	public void inserirTipoTeste() {
		Scanner sc = new Scanner(System.in);
		TipoTesteDaoImpl ttdi = new TipoTesteDaoImpl();
		TipoTeste tipoTeste = new TipoTeste();

		System.out.println("digite o nome do tipo de teste: ");
		String nome_tipoTeste = sc.nextLine();
		System.out.println("digite a descrição do tipo de teste: ");
		String descricao_tipoTeste = sc.nextLine();

		tipoTeste.setNome(nome_tipoTeste);
		tipoTeste.setDescricao(descricao_tipoTeste);

		ttdi.save(tipoTeste);

	}

	public void inseriItemTeste() {
		Scanner sc = new Scanner(System.in);
		ItemTesteDaoImpl itdi = new ItemTesteDaoImpl();
		ItemTeste itemTeste = new ItemTeste();
		Projeto proj = new Projeto();
		ProjetoDaoImpl projdao = new ProjetoDaoImpl();

		System.out.println("digite a descrição do item teste: ");
		String descricao_itemTeste = sc.nextLine();
		System.out.println("digite a resposta do item teste: ");
		boolean resposta_itemTeste = sc.nextBoolean();
		System.out
				.println("digite o nome do projeto correspondente ao  tipo de teste: ");
		String nome = sc.next();

		proj = projdao.getProjetoByName(nome);

		itemTeste.setDescricao(descricao_itemTeste);
		itemTeste.setResposta(resposta_itemTeste);
		itemTeste.setProjeto(proj);

		itdi.save(itemTeste);

	}

	public void inserirFerramenta() {
		Scanner sc = new Scanner(System.in);
		FerramentaDaoImpl fdi = new FerramentaDaoImpl();
		Ferramenta ferramenta = new Ferramenta();

		System.out.println("digite o nome da ferramenta: ");
		String nome_ferramenta = sc.nextLine();
		System.out.println("digite a descrição da ferramenta: ");
		String descricao_ferramenta = sc.nextLine();

		ferramenta.setNome(nome_ferramenta);
		ferramenta.setDescricao(descricao_ferramenta);

		fdi.save(ferramenta);

	}

	public void inserirCriterioAceitacao() {
		Scanner sc = new Scanner(System.in);
		CriterioAceitacaoDaoImpl cadi = new CriterioAceitacaoDaoImpl();
		CriterioAceitacao criterioAceitacao = new CriterioAceitacao();
		ProjetoDaoImpl pdi = new ProjetoDaoImpl();
		Projeto proj = new Projeto();

		System.out.println("digite a descrição do criterio de aceitação: ");
		String descricao_criterio = sc.nextLine();
		System.out.println("digite a resposta do criterio de aceitação: ");
		boolean resposta_criterio = sc.nextBoolean();
		System.out
				.println("digite o nome do projeto correspondente ao  tipo de teste: ");
		String nome = sc.next();

		proj = pdi.getProjetoByName(nome);

		criterioAceitacao.setDescricao(descricao_criterio);
		criterioAceitacao.setResposta(resposta_criterio);
		criterioAceitacao.setProjeto(proj);

		cadi.save(criterioAceitacao);
	}

	public void inserirArtefatoProjeto() {
		Scanner sc = new Scanner(System.in);
		ArtefatoProjeto artefatoProjeto = new ArtefatoProjeto();
		ArtefatoProjetoPk artefatoProjetoPK = new ArtefatoProjetoPk();
		Projeto proj = new Projeto();
		ProjetoDaoImpl pdi = new ProjetoDaoImpl();
		ArtefatoDaoImpl adi = new ArtefatoDaoImpl();
		ArtefatoProjetoDaoImpl apdi = new ArtefatoProjetoDaoImpl();
		Artefato artefato = new Artefato();
		List<Artefato> artefatoList;

		artefatoList = adi.list();

		System.out.println("artefatos inseridos no sistema: ");

		for (Artefato a : artefatoList) {
			System.out.println(a.getNome());
		}

		System.out.println("");

		System.out.println("digite o nome do artefato: ");
		String nome_artefato = sc.nextLine();
		System.out.println("digite a resposta do artefato projeto: ");
		boolean resposta = sc.nextBoolean();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("digite a mensagem do artefato projeto: ");
		String mensagem = sc2.nextLine();

		System.out
				.println("digite o nome do projeto correspondente ao  tipo de teste: ");
		String nome = sc.next();

		proj = pdi.getProjetoByName(nome);
		artefato = adi.getArtefatoByName(nome_artefato);

		artefatoProjetoPK.setProjeto(proj);
		artefatoProjetoPK.setArtefato(artefato);
		artefatoProjeto.setResposta(resposta);
		artefatoProjeto.setMensagem(mensagem);
		artefatoProjeto.setPk(artefatoProjetoPK);

		apdi.save(artefatoProjeto);
	}

	public void inserirNivelTesteProjeto() {
		Scanner sc = new Scanner(System.in);
		NivelTesteProjeto nivelTesteProjeto = new NivelTesteProjeto();
		NivelTesteProjetoDaoImpl ntpdi = new NivelTesteProjetoDaoImpl();
		NivelTesteProjetoPk nivelTesteProjetoPK = new NivelTesteProjetoPk();
		NivelTeste nivelTeste = new NivelTeste();
		NivelTesteDaoImpl ntdi = new NivelTesteDaoImpl();
		Projeto proj = new Projeto();
		ProjetoDaoImpl pdi = new ProjetoDaoImpl();
		List<NivelTeste> nivelList;

		nivelList = ntdi.list();

		System.out.println("niveis de teste inseridos no sistema: ");

		for (NivelTeste n : nivelList) {
			System.out.println(n.getNome());
		}

		System.out.println("");

		System.out.println("digite o nome do nivel de teste: ");
		String nome_nivelTeste = sc.nextLine();
		System.out.println("digite a resposta do  nivel de teste: ");
		boolean resposta = sc.nextBoolean();
		System.out.println("digite a mensagem do  nivel de teste: ");
		sc = new Scanner(System.in);
		String mensagem = sc.nextLine();
		System.out
				.println("digite o nome do projeto correspondente ao  tipo de teste: ");
		String nome = sc.next();

		proj = pdi.getProjetoByName(nome);
		nivelTeste = ntdi.getNivelTesteByName(nome_nivelTeste);

		nivelTesteProjetoPK.setNivelTeste(nivelTeste);
		nivelTesteProjetoPK.setProjeto(proj);
		nivelTesteProjeto.setResposta(resposta);
		nivelTesteProjeto.setMensagem(mensagem);
		nivelTesteProjeto.setPk(nivelTesteProjetoPK);

		ntpdi.save(nivelTesteProjeto);

	}

	public void inserirTipoTesteProjeto() {
		Scanner sc = new Scanner(System.in);
		TipoTesteProjeto tipoTesteProjeto = new TipoTesteProjeto();
		TipoTesteProjetoDaoImpl ttpdi = new TipoTesteProjetoDaoImpl();
		TipoTesteProjetoPk tipoTesteProjetoPK = new TipoTesteProjetoPk();
		TipoTeste tipoTeste = new TipoTeste();
		TipoTesteDaoImpl ttdi = new TipoTesteDaoImpl();
		Projeto proj = new Projeto();
		ProjetoDaoImpl pdi = new ProjetoDaoImpl();
		List<TipoTeste> tipoList;

		tipoList = ttdi.list();

		System.out.println("tipos de teste inseridos no sistema: ");

		for (TipoTeste t : tipoList) {
			System.out.println(t.getNome());
		}

		System.out.println("");

		System.out.println("digite o nome do tipo de teste: ");
		String nome_tipoTeste = sc.nextLine();
		System.out.println("digite a resposta do tipo de teste: ");
		boolean resposta = sc.nextBoolean();
		System.out.println("digite a mensagem do  tipo de teste: ");
		sc = new Scanner(System.in);
		String mensagem = sc.nextLine();

		System.out
				.println("digite o nome do projeto correspondente ao  tipo de teste: ");
		String nome = sc.next();

		proj = pdi.getProjetoByName(nome);
		tipoTeste = ttdi.getTipoTesteByNome(nome_tipoTeste);

		tipoTesteProjetoPK.setProjeto(proj);
		tipoTesteProjetoPK.setTipoTeste(tipoTeste);
		tipoTesteProjeto.setResposta(resposta);
		tipoTesteProjeto.setMensagem(mensagem);
		tipoTesteProjeto.setPk(tipoTesteProjetoPK);

		ttpdi.save(tipoTesteProjeto);

	}

	public void inserirFerramentaProjeto() {
		Scanner sc = new Scanner(System.in);
		FerramentaProjeto ferramentaProjeto = new FerramentaProjeto();
		FerramentaProjetoDaoImpl fpdi = new FerramentaProjetoDaoImpl();
		FerramentaProjetoPk ferramentaProjetoPk = new FerramentaProjetoPk();
		Ferramenta ferramenta = new Ferramenta();
		FerramentaDaoImpl fdi = new FerramentaDaoImpl();
		Projeto proj = new Projeto();
		ProjetoDaoImpl pdi = new ProjetoDaoImpl();
		List<Ferramenta> ferramentaList;

		ferramentaList = fdi.list();

		System.out.println("ferramentas inseridos no sistema: ");

		for (Ferramenta f : ferramentaList) {
			System.out.println(f.getNome());
		}

		System.out.println("");

		System.out.println("digite o nome da ferramenta: ");
		String nome_ferramenta = sc.nextLine();
		System.out.println("digite a resposta da ferramenta do projeto: ");
		boolean resposta = sc.nextBoolean();
		System.out.println("digite a mensagem da ferramenta do projeto: ");
		sc = new Scanner(System.in);
		String mensagem = sc.nextLine();
		System.out
				.println("digite o nome do projeto correspondente ao  tipo de teste: ");
		String nome = sc.next();

		proj = pdi.getProjetoByName(nome);
		ferramenta = fdi.getFerramentaByNome(nome_ferramenta);

		ferramentaProjetoPk.setProjeto(proj);
		ferramentaProjetoPk.setFerramenta(ferramenta);
		ferramentaProjeto.setResposta(resposta);
		ferramentaProjeto.setMensagem(mensagem);
		ferramentaProjeto.setPk(ferramentaProjetoPk);

		fpdi.save(ferramentaProjeto);

	}
	
	
	
	public void inserirAlunoTurma() {
		
		AlunoTurma at = new AlunoTurma();
		AlunoTurmaPK aluno_turma_pk = new AlunoTurmaPK();
		Turma turma = new Turma();
		Aluno aluno = new Aluno();
		
		AlunoDao alunoDao = new AlunoDaoImpl();
		TurmaDao turmaDao = new TurmaDaoImpl();
		
		AlunoTurmaDao aluno_turma_dao = new AlunoTurmaDaoImpl();
		
		aluno = (Aluno) alunoDao.getUsuarioById(31);
		turma = turmaDao.getTurmaById(15);

		
		

		aluno_turma_pk.setAluno(aluno);
		aluno_turma_pk.setTurma(turma);
		
		at.setPk(aluno_turma_pk);
		
		
		aluno_turma_dao.save(at);
	}

}
