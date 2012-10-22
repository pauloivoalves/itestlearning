package br.ufc.si.itest.adicionais;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import br.ufc.si.itest.dao.UsuarioDao;
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
import br.ufc.si.itest.dao.impl.UsuarioDaoImpl;
import br.ufc.si.itest.model.Artefato;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.model.CriterioAceitacao;
import br.ufc.si.itest.model.Ferramenta;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.model.ItemTeste;
import br.ufc.si.itest.model.NivelDificuldade;
import br.ufc.si.itest.model.NivelTeste;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.model.TipoTeste;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.model.Usuario;

/*
 * @author Mardson Ferreira
 * atualizar projeto ok
 * atualizar artefato ok
 * atualizar nivel teste ok
 * atualizar ferramenta ok
 * atualizar tipo teste ok
 * atualizar nivel dificuldade ok
 * atualizar Usu�rio ok
 * atualizar item teste ok
 * atualizar crit�rio aceita��o ok
 * atualizar Artefato projeto ok
 * atualizar ferramenta projeto ok
 * atualizar nivelTeste projeto ok
 * atualizar tipoTeste projeto ok
 * */

public class Atualizar {

	public static void main(String[] args) {
		// atualizarProjeto();
		// atualizarArtefato();
		// atualizarNivelTeste();
		// atualizarFerramenta();
		// atualizarTipoTeste();
		// atualizarNivelDificuldade();
		// atualizarUsuario();
		// atualizarItemTeste();
		// atualizarCriterioAceitacao();
		// atualizarArtefatProjeto();
		//atualizarFerramentaProjeto();
		//atualizarNivelTesteProjeto();
		atualizarTipoTesteProjeto();
	}// fim do m�todo main

	public static void atualizarProjeto() {
		Scanner input = new Scanner(System.in);

		Projeto projeto = null;
		ProjetoDao pd = new ProjetoDaoImpl();

		// busca o projeto pelo nome
		System.out.println("digite o nome do projeto");
		projeto = pd.getProjetoByName(input.next());

		if (projeto != null) {

			// modifica os campos do projeto obtido

			System.out.println("digite o novo nome do projeto");
			projeto.setNome(input.next());
			System.out.println("digite a nova descri��o do projeto");
			projeto.setDescricao(input.next());
			System.out.println("digite o n�vel de dificuldade do projeto");
			projeto.getNivelDificuldade().setId(input.nextInt());

			// atualiza o projeto
			pd.update(projeto);
		} else {
			System.out.println("nivel teste n�o encontrado");
		}

	}// fim do m�todo atualizar

	public static void atualizarArtefato() {

		Scanner input = new Scanner(System.in);

		Artefato atf = null;

		System.out.println("digite o nome do artefato");

		// busca o artefato pelo nome
		ArtefatoDao atd = new ArtefatoDaoImpl();
		atf = atd.getArtefatoByName(input.nextLine());

		if (atf != null) {

			// modifica os campos

			System.out.println("digite o novo nome do artefato");
			atf.setNome(input.nextLine());
			System.out.println("digite a descri��o do artefato");
			atf.setDescricao(input.nextLine());

			// atualiza o artefato
			atd.update(atf);

		} else {
			System.out.println("artefato n�o encontrado");
		}

	}// fim do m�todo atualizar artefato

	public static void atualizarNivelTeste() {
		Scanner input = new Scanner(System.in);

		NivelTeste nt = null;

		System.out.println("digite o nome do nivel de teste");

		// busca o nivel_teste pelo nome
		NivelTesteDao ntd = new NivelTesteDaoImpl();
		nt = ntd.getNivelTesteByName(input.nextLine());

		if (nt != null) {

			// modifica os campos

			System.out.println("digite o novo nome do artefato");
			nt.setNome(input.nextLine());
			System.out.println("digite a descri��o do artefato");
			nt.setDescricao(input.nextLine());

			// atualiza o nivel de teste
			ntd.update(nt);
		} else {
			System.out.println("nivel teste n�o encontrado");
		}
	}// fim do m�todo atualizar nivel teste

	public static void atualizarFerramenta() {
		Scanner input = new Scanner(System.in);

		Ferramenta ferramenta = null;

		// busca a ferramenta pelo nome
		FerramentaDao ferdao = new FerramentaDaoImpl();
		System.out.println("digite o nome da ferramenta");
		ferramenta = ferdao.getFerramentaByNome(input.nextLine());

		if (ferramenta != null) {
			System.out.println("digite o novo nome da ferramenta");
			ferramenta.setNome(input.next());
			System.out.println("digite a descri��o da ferramenta");
			ferramenta.setDescricao(input.nextLine());

			// atualiza a ferramenta
			ferdao.update(ferramenta);

		} else {
			System.out.println("ferramenta n�o encontrada");
		}

	}// fim do m�todo atualizar ferramenta

	public static void atualizarTipoTeste() {
		Scanner input = new Scanner(System.in);

		TipoTeste tipo = null;

		// busca tipo teste pelo nome
		System.out.println("digite o nome do tipo teste");
		TipoTesteDao tipodao = new TipoTesteDaoImpl();
		tipo = tipodao.getTipoTesteByNome(input.nextLine());

		if (tipo != null) {
			System.out.println("digite o novo nome do tipo teste");
			tipo.setNome(input.nextLine());
			System.out.println("digite a descri��o do tipo teste");
			tipo.setDescricao(input.nextLine());

			// atualiza tipo teste
			tipodao.update(tipo);

		} else {
			System.out.println("ferramenta n�o encontrada");
		}

	}// fim do m�todo atualizar tipo teste

	public static void atualizarNivelDificuldade() {
		Scanner input = new Scanner(System.in);

		NivelDificuldade nidif = null;

		// busca nivel dificuldade pelo nome
		System.out.println("digite o nome do nivel de dificuldade");
		NivelDificuldadeDao nidifdao = new NivelDificuldadeDaoImpl();
		nidif = nidifdao.getNivelDificuldadeByName(input.nextLine());

		if (nidif != null) {
			System.out.println("digite o novo nome do nivel dificuldade");
			nidif.setNome(input.nextLine());
			System.out.println("digite a descri��o do nivel dificuldade");
			nidif.setDescricao(input.nextLine());

			// atualiza tipo teste
			nidifdao.update(nidif);

		} else {
			System.out.println("ferramenta n�o encontrada");
		}
	}// fim do m�todo atualizar nivelDificuldade

	public static void atualizarUsuario() {
		Scanner input = new Scanner(System.in);

		Usuario user = null;

		// busca usu�rio pelo nome
		System.out.println("digite o nome do usuario");
		UsuarioDao userdao = new UsuarioDaoImpl();
		user = userdao.getUsuarioByNome(input.nextLine());

		if (user != null) {
			System.out.println("digite o novo nome do Usuario");
			user.setNome(input.nextLine());

			System.out.println("digite o novo login do Usuario");
			user.setLogin(input.nextLine());

			System.out.println("digite a nova senha do Usuario");
			user.setSenha(input.nextLine());

			// atualiza o usuario
			userdao.update(user);
		} else {
			System.out.println("Usu�rio n�o encontrado");
		}
	}// fim do m�todo atualizar Usu�rio

	public static void atualizarItemTeste() {
		Scanner input = new Scanner(System.in);

		ItemTeste item = null;

		ItemTesteDao itemdao = new ItemTesteDaoImpl();

		List<ItemTeste> lista = itemdao.list();

		for (ItemTeste elem : lista) {
			System.out.println(elem.getId());
			System.out.println(elem.getDescricao());
		}

		// busca o item teste pelo id
		System.out.println("digite o id do item teste");
		item = itemdao.getItemtesteById(input.nextInt());

		if (item != null) {
			System.out.println("digite a descri��o do item teste");
			item.setDescricao(input.nextLine());

			System.out.println("digite a mensagem do item teste");
			item.setMensagem(input.nextLine());

			System.out.println("digite a resposta item teste");
			item.setResposta(input.nextBoolean());

			// atualiza o item teste
			itemdao.update(item);

		} else {
			System.out.println("item teste n�o encontrado");
		}
	}// fim do m�todo atualizar item teste

	public static void atualizarCriterioAceitacao() {
		Scanner input = new Scanner(System.in);

		System.out.println("digite o nome do projeto");
		String nome_projeto = input.next();

		ProjetoDao pd = new ProjetoDaoImpl();

		Projeto projeto = pd.getProjetoByName(nome_projeto);

		if (projeto != null) {
			System.out.println(projeto.getId());

			CriterioAceitacao criterio = new CriterioAceitacao();

			CriterioAceitacaoDao cad = new CriterioAceitacaoDaoImpl();

			List<CriterioAceitacao> listacriterio = new ArrayList<CriterioAceitacao>();

			// busca todos os crit�rios de aceita��o pelo id do projeto
			listacriterio = cad.getCriterioAceitacaoByProjeto(projeto.getId());

			for (CriterioAceitacao ca : listacriterio) {
				System.out.println(ca.getId());
			}

			// busca o crit�rio aceita��o pelo id
			System.out.println("digite o id do crit�rio de aceita��o");
			criterio = cad.getCriterioAceitacaoById(input.nextInt());

			// verifica se existe
			if (criterio != null) {

				
				System.out.println(criterio.toString());
				
				// modifica o crit�rio de aceita��o

				System.out
						.println("digite a descri��o do crit�rio de aceita��o");
				criterio.setDescricao(input.nextLine());

				System.out
						.println("digite a resposta do crit�rio de aceita��o");
				criterio.setResposta(input.nextBoolean());

				System.out
						.println("digite a mensagem do crit�rio de aceita��o");
				criterio.setMensagem(input.nextLine());

				

				// atualiza o crit�rio de aceita��o
				cad.update(criterio);

			} else {
				System.out.println("criterio de aceita��o n�o encontrado");
			}

		} else {
			System.out.println("projeto n�o encontrado");
		}

	}// fim do m�todo atualizar crit�rio aceita��o

	public static void atualizarArtefatProjeto() {
		Scanner input = new Scanner(System.in);

		// busco o projeto na base de dados
		System.out.println("digite o nome do projeto");
		String nome_projeto = input.next();

		ProjetoDao pd = new ProjetoDaoImpl();

		Projeto projeto = pd.getProjetoByName(nome_projeto);
		// verifica se o projeto existe

		if (projeto != null) {

			System.out.println(projeto.getId());

			// buscar todos os artefatos pertecentes aquele projeto
			ArtefatoProjetoDao atfpd = new ArtefatoProjetoDaoImpl();
			List<ArtefatoProjeto> lista = atfpd
					.getArtefatProjetoByIdProjeto(projeto.getId());

			if (lista != null) {
				for (ArtefatoProjeto elem : lista) {
					System.out.println("id_artefato: "
							+ elem.getPk().getArtefato().getId()
							+ "id_projeto: "
							+ elem.getPk().getProjeto().getId() + "\n");
				}

				// busco o artefatoprojeto pelo id_artefato e id_projeto
				System.out.println("digite o id do artefato");
				int artf = input.nextInt();

				System.out.println("digite o id do projeto");
				int proj = input.nextInt();

				ArtefatoProjeto ap = atfpd
						.getArtefatProjetoByIdProjetoIdArtefato(proj, artf);

				// verifica se ele existe
				if (ap != null) {
					
					System.out.println(ap.toString());
					
					// modifica o artefato projeto

					System.out.println("digite a resposta do artefatoProjeto");
					ap.setResposta(input.nextBoolean());

					System.out.println("digite a mensagem do artefatoProjeto");
					ap.setMensagem(input.nextLine());

					

					// atualiza o artefatoProjeto
					atfpd.update(ap);
				} else {
					System.out.println("artefatoProjeto n�o encontrado");
				}

			} else {
				System.out
						.println("nenhum artefatoprojeto encontrado para esse projeto");
			}

		} else {
			System.out.println("projeto n�o encontrado");
		}

	}// fim do m�todo atualizarArtefatoProjeto

	public static void atualizarFerramentaProjeto() {
		Scanner input = new Scanner(System.in);

		// busco o projeto na base de dados
		System.out.println("digite o nome do projeto");
		String nome_projeto = input.next();

		ProjetoDao pd = new ProjetoDaoImpl();

		Projeto projeto = pd.getProjetoByName(nome_projeto);
		// verifica se o projeto existe

		if (projeto != null) {

			System.out.println(projeto.getId());

			// buscar todos as ferramentas pertecentes aquele projeto
			FerramentaProjetoDao fdp = new FerramentaProjetoDaoImpl();
			List<FerramentaProjeto> lista = fdp
					.getFerramentaProjetoByIdProjeto(projeto.getId());

			if (lista != null) {
				for (FerramentaProjeto elem : lista) {
					System.out.println("id_ferramenta: "
							+ elem.getPk().getFerramenta().getId()
							+ "id_projeto: "
							+ elem.getPk().getProjeto().getId() + "\n");
				}

				// busco a ferramentaprojeto pelo id_ferramenta e id_projeto
				System.out.println("digite o id da ferramenta");
				int ferproj = input.nextInt();

				System.out.println("digite o id do projeto");
				int proj = input.nextInt();

				FerramentaProjeto fp = fdp
						.getFerramentaProjetoByIdProjetoIdFerramenta(proj,
								ferproj);

				// verifica se ele existe
				if (fp != null) {
					
					System.out.println(fp.toString());
					
					// modifica a ferramentaprojeto

					System.out
							.println("digite a resposta da ferramentaProjeto");
					fp.setResposta(input.nextBoolean());

					System.out
							.println("digite a mensagem da ferramentaProjeto");
					fp.setMensagem(input.nextLine());

					

					// atualiza a ferramentaProjeto
					fdp.update(fp);

				} else {
					System.out.println("ferramentaProjeto n�o encontrado");
				}

			} else {
				System.out
						.println("nenhuma ferramentaprojeto encontrado para esse projeto");
			}

		} else {
			System.out.println("projeto n�o encontrado");
		}
	}// fim do m�todo atualizar ferramenta projeto
	
	public static void atualizarNivelTesteProjeto(){
		Scanner input = new Scanner(System.in);

		// busco o projeto na base de dados
		System.out.println("digite o nome do projeto");
		String nome_projeto = input.next();

		ProjetoDao pd = new ProjetoDaoImpl();

		Projeto projeto = pd.getProjetoByName(nome_projeto);
		// verifica se o projeto existe

		if (projeto != null) {

			System.out.println(projeto.getId());

			// buscar todos os nivelTeste pertecentes aquele projeto
			NivelTesteProjetoDao ntpd = new NivelTesteProjetoDaoImpl();
			List<NivelTesteProjeto> lista = ntpd.getNivelTesteProjetoByIdProjeto(projeto.getId());

			if (lista != null) {
				for (NivelTesteProjeto elem : lista) {
					System.out.println("id_Nivel_teste: "
							+ elem.getPk().getNivelTeste().getId()
							+ "id_projeto: "
							+ elem.getPk().getProjeto().getId() + "\n");
				}

				// busco o niveltesteprojeto pelo id_nivel_teste e id_projeto
				System.out.println("digite o id do nivel teste");
				int ntproj = input.nextInt();

				System.out.println("digite o id do projeto");
				int proj = input.nextInt();

				NivelTesteProjeto ntp = ntpd.getNivelTesteProjetoByIdProjetoIdNivelTeste(proj, ntproj);

				// verifica se ele existe
				if (ntp != null) {
					
					System.out.println(ntp.toString());
					
					// modifica o niveltesteprojeto

					System.out
							.println("digite a resposta do niveltesteProjeto");
					ntp.setResposta(input.nextBoolean());

					System.out
							.println("digite a mensagem do niveltesteProjeto");
					ntp.setMensagem(input.nextLine());

					

					// atualiza o niveltesteProjeto
					ntpd.update(ntp);

				} else {
					System.out.println("niveltesteProjeto n�o encontrado");
				}

			} else {
				System.out
						.println("nenhum niveltesteprojeto encontrado para esse projeto");
			}

		} else {
			System.out.println("projeto n�o encontrado");
		}
	}//fim do m�todo atualizarNIvelTesteProjeto
	
	
	public static void atualizarTipoTesteProjeto(){
		Scanner input = new Scanner(System.in);

		// busco o projeto na base de dados
		System.out.println("digite o nome do projeto");
		String nome_projeto = input.next();

		ProjetoDao pd = new ProjetoDaoImpl();

		Projeto projeto = pd.getProjetoByName(nome_projeto);
		// verifica se o projeto existe

		if (projeto != null) {

			System.out.println(projeto.getId());

			// buscar todos os tipoTeste pertecentes aquele projeto
			TipoTesteProjetoDao ttpd = new TipoTesteProjetoDaoImpl();
			List<TipoTesteProjeto> lista = ttpd.getTipoTesteProjetoByIdProjeto(projeto.getId());

			if (lista != null) {
				for (TipoTesteProjeto elem : lista) {
					System.out.println("id_tipo_teste: "
							+ elem.getPk().getTipoTeste().getId()
							+ "id_projeto: "
							+ elem.getPk().getProjeto().getId() + "\n");
				}

				// busco o tipotesteprojeto pelo id_tipo_teste e id_projeto
				System.out.println("digite o id do tipo teste");
				int ttproj = input.nextInt();

				System.out.println("digite o id do projeto");
				int proj = input.nextInt();

				TipoTesteProjeto ttp = ttpd.getTipoTesteProjetoByIdProjetoIdTipoTeste(proj, ttproj);
				
				// verifica se ele existe
				if (ttp != null) {
					
					System.out.println(ttp.toString());
					
					// modifica o tipotesteprojeto

					System.out
							.println("digite a resposta do tipotesteProjeto");
					ttp.setResposta(input.nextBoolean());

					System.out
							.println("digite a mensagem do tipotesteProjeto");
					ttp.setMensagem(input.nextLine());

					

					// atualiza o niveltesteProjeto
					ttpd.update(ttp);

				} else {
					System.out.println("tipotesteProjeto n�o encontrado");
				}

			} else {
				System.out
						.println("nenhum tipotesteprojeto encontrado para esse projeto");
			}

		} else {
			System.out.println("projeto n�o encontrado");
		}
	}//fim do m�todo atualizar tipo teste

}// fim da classe atualizar
