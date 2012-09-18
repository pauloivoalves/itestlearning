package br.ufc.si.itest.adicionais;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ufc.si.itest.dao.impl.ArtefatoDaoImpl;
import br.ufc.si.itest.dao.impl.ArtefatoProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.CriterioAceitacaoDaoImpl;
import br.ufc.si.itest.dao.impl.FerramentaDaoImpl;
import br.ufc.si.itest.dao.impl.FerramentaProjetoDaoImpl;
import br.ufc.si.itest.dao.impl.ItemTesteDaoImpl;
import br.ufc.si.itest.dao.impl.JogoDaoImpl;
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
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.NivelTeste;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.model.TipoTeste;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.model.Usuario;

public class RemovendoObjetosDoBanco {

	public static void main(String[] args) {

		//--removerProjetoPorNome();
		//--removeArtfatoPorNome();
		//--removeArtefatoProjetoPorId();
		//--removeCriteriosAceitacaoPorIdProjeto();
		//--removeItemTestePorIdProjeto();
		//--removeJogoPorIdProjeto();
		//--removeFerramentaPorNome();
		//--removeFerramentaProjetoPorIdProjetoIdFerramenta();
		//--removeNivelTestePorNome();
		//--removeNivelTesteProjetoPorId();
		//--removeUsuarioPorNome();
		//--removeTipoTestePorNome();
		//--removeTipoTesteProjeto();
	}
	
	
	public static void removerProjetoPorNome() {

		ProjetoDaoImpl dao = new ProjetoDaoImpl();
		Projeto pro = new Projeto();

		Scanner sc = new Scanner(System.in);
		System.out.println("digite o nome do projeto: ");
		String nomeProjeto = sc.nextLine();

		try {
			pro = dao.getProjetoByName(nomeProjeto);

			removeCriteriosAceitacaoPorIdProjeto();
			removeItemTestePorIdProjeto();
			removeJogoPorIdProjeto();

			dao.remove(pro);
			System.out.println("ok projeto removido");
		} catch (Exception e) {
			System.out.println("não existe projeto cadastrado com este nome");
		}

	}

	public static void removeCriteriosAceitacaoPorIdProjeto() {

		Scanner input = new Scanner(System.in);
		System.out.println("digite o id do projeto...");
		int idprojeto = input.nextInt();
		
		CriterioAceitacaoDaoImpl Dao = new CriterioAceitacaoDaoImpl();
		List<CriterioAceitacao> listaDeCriterios = new ArrayList<CriterioAceitacao>();
		
		try {
			
			listaDeCriterios = Dao.getCriterioAceitacaoByProjeto(idprojeto);

			if(listaDeCriterios.get(0)!=null){
			for (CriterioAceitacao c : listaDeCriterios) {
				Dao.remove(c);
				System.out.println("criterio de aceitação removido");

			}

			}else{
				System.out.println("não existe criterio de aceitação " +
									"para este projeto");
			}
			
		} catch (Exception e) {
			System.out
					.println("não existe criterio de aceitação para este projeto");
		}

	}

	public static void removeItemTestePorIdProjeto() {

		Scanner input = new Scanner(System.in);
		System.out.println("digite o id do projeto para remover os itens teste...");
		int idprojeto = input.nextInt();
		
			
		try {

			ItemTesteDaoImpl dao = new ItemTesteDaoImpl();
			List<ItemTeste> listaDeItens = new ArrayList<ItemTeste>();

			listaDeItens = dao.getItensTesteByProjeto(idprojeto);

			if(listaDeItens.get(0)!= null){
			for (ItemTeste itemDavez : listaDeItens) {
				dao.remove(itemDavez);
				System.out.println("item removido");
			}
			
			}else{
				System.out.println("Não existe itens para o projeto referido");
			}
			
		} catch (Exception e) {
			System.out.println("Não existe itens para o projeto referido");
		}

	}

	public static void removeJogoPorIdProjeto() {

		Scanner input = new Scanner(System.in);
		System.out.println("digite o id do projeto do jogo a ser removido...");
		int idprojeto = input.nextInt();
		
		try {

			JogoDaoImpl Dao = new JogoDaoImpl();
			List<Jogo> listaJogos = new ArrayList<Jogo>();
			listaJogos = Dao.getJogoByProjeto(idprojeto);
			
			if(listaJogos.get(0) != null){
			for (Jogo jogoDavez : listaJogos) {
				 Dao.remove(jogoDavez);
				 System.out.println("removido");
			}
			
			}else{
				
				System.out.println("Verifique se o id passado existe " +
				"realmente no banco de dados");
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Verifique se o id passado existe " +
					"realmente no banco de dados");
		}

	}

	public static void removeArtfatoPorNome() {

		Scanner input = new Scanner(System.in);
		System.out.println("digite o nome do artefato");
		String nomeBuscado = input.next();
		
		ArtefatoDaoImpl Dao = new ArtefatoDaoImpl();
		Artefato artefatoDaVez = new Artefato();

		try {

			artefatoDaVez = Dao.getArtefatoByName(nomeBuscado);
			Dao.remove(artefatoDaVez);
			System.out.println("artefato removido com sucesso");

		} catch (Exception e) {
			System.out.println("erro na remoção");
		}

	}

	public static void removeArtefatoProjetoPorId() {

		Scanner input = new Scanner(System.in);
		System.out.println("digite o id do projeto");
		int idprojeto = input.nextInt();
		
		ArtefatoProjetoDaoImpl Dao = new ArtefatoProjetoDaoImpl();
		ArtefatoProjeto atp = new ArtefatoProjeto();

		try {
			atp = Dao.getArtefatoProjetoById(idprojeto);
			Dao.remove(atp);
			System.out.println("ok na remoção");

		} catch (Exception e) {
			System.out
					.println("o artefato projeto a ser removido não existe ou o id informado está incorreto");
		}

	}

	//este metodo está ok
	public static void removeFerramentaPorNome() {

		FerramentaDaoImpl dao = new FerramentaDaoImpl();
		Ferramenta ferramenta = new Ferramenta();

		Scanner sc = new Scanner(System.in);
		System.out.println("digite o nome da ferramenta a ser removida: ");
		String nomeFerramenta = sc.nextLine();

		try {
			ferramenta = dao.getFerramentaByName(nomeFerramenta);
			removeFerramentaProjetoPorIdProjetoIdFerramenta();
			dao.remove(ferramenta);
			System.out.println("Ferramenta removida com sucesso!!!");

		} catch (Exception e) {
			System.out
					.println("a ferramenta a ser removida não existe no banco ou seu nome está incorreto");
		}

	}

	//este metodo está ok
	public static void removeFerramentaProjetoPorIdProjetoIdFerramenta() {

		FerramentaProjetoDaoImpl dao = new FerramentaProjetoDaoImpl();
		FerramentaProjeto ferramentaProjeto = new FerramentaProjeto();

		Scanner input = new Scanner(System.in);
		System.out.println("digite o id do projeto: ");
		Integer idProj = input.nextInt();
		System.out.println("digite o id da ferramenta: ");
		Integer idfer = input.nextInt();

		try {
			ferramentaProjeto = dao.getFerramentaProjByIdProjetoIdFerramenta(
					idProj, idfer);
			dao.remove(ferramentaProjeto);
			System.out.println("ferramenta removida com sucesso");
		} catch (Exception e) {
			System.out.println("ferramenta procurada não fora encontrada verifique se os dados estão corretos");
		}

	}

	public static void removeUsuarioPorNome() {

		Scanner input = new Scanner(System.in);
		System.out.println("digite o nome do usuario a ser removido");
		String nome = input.nextLine();
		
		UsuarioDaoImpl dao = new UsuarioDaoImpl();
		Usuario usuarioAtual = new Usuario();
		
		try {
			
			usuarioAtual = dao.getUsuarioByName(nome);
			dao.remove(usuarioAtual);
			System.out.println("Usuario removido com sucesso.");
			
		} catch (Exception e) {
			System.out.println("O usuario não existe. digite um nome de usuário válido./n Ou" +
					"o mesmo pode esta sendo referenciado por outro campo no banco");
		}
		
		
	}

	public static void removeNivelTestePorNome() {

		NivelTesteDaoImpl dao = new NivelTesteDaoImpl();
		NivelTeste nivelTeste = new NivelTeste();

		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do nivel de teste a ser removido");
		String nomeTeste = input.nextLine();

		try {

			nivelTeste = dao.getNivelTesteByName(nomeTeste);
							
			dao.remove(nivelTeste);

			System.out.println("teste removido com sucesso");

		} catch (Exception e) {
			System.out.println("este teste não existe ou tem uma \n" +
					"referencia a ele na tabela nivel de teste projeto \n" +
					"favor verificar .");
		}

	}

	public static void removeTipoTestePorNome() {

		TipoTesteDaoImpl dao = new TipoTesteDaoImpl();
		TipoTeste tipoTeste = new TipoTeste();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do tipo de teste a ser removido");
		String nomeTeste = input.nextLine();
		
		try {
			
			tipoTeste = dao.getTipoTesteByName(nomeTeste);
			dao.remove(tipoTeste);
			System.out.println("teste removido com sucesso");
			
			
		} catch (Exception e) {
			System.out.println("o teste informado não fora encontrado, \n" +
					"ou existe dependência do mesmo verifique referências \n" +
					"ao mesmo na tabela Tipo Teste Projeto");
		}
		
	}

	public static void removeTipoTesteProjeto() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("digite o id do projeto");
		Integer idpro = input.nextInt();
		System.out.println("digite o id do tipo de teste");
		Integer idTipoDeTeste = input.nextInt();
		
		try {
			
			TipoTesteProjetoDaoImpl dao = new TipoTesteProjetoDaoImpl();
			TipoTesteProjeto ttp = new TipoTesteProjeto();
			
			ttp = dao.getTipoTesteProjetoByIdProjetoIdTipoTeste(idpro, idTipoDeTeste);
			
			dao.remove(ttp);
			
			System.out.println("tipo teste projeto procurado removido com sucesso");
			
		} catch (Exception e) {
			
			System.out.println("Verifique se os dados digitados estão corretos e tente novamente. ");
		}
			
				
	}

	public static void removeNivelTesteProjetoPorId() {

		Scanner input = new Scanner(System.in);
		System.out.println("digite o id do projeto do qual o nivel de teste será removido...");
		int id = input.nextInt();
		System.out.println("digite o id do nivel de teste que será removido...");
		int idNivelTeste = input.nextInt();
		
		
		try {

			NivelTesteProjetoDaoImpl dao = new NivelTesteProjetoDaoImpl();
			List<NivelTesteProjeto> minhaLista = new ArrayList<NivelTesteProjeto>();

			minhaLista = dao.getNivelTesteProjetoById(id, idNivelTeste);

			for (NivelTesteProjeto ntp : minhaLista) {
				dao.remove(ntp);
				System.out.println("removido com sucesso");
			}

		} catch (Exception e) {
			System.out.println("não existem niveis cadastrados aqui com esse numero");
		}

	}

}