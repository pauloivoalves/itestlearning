package br.ufc.si.itest.adicionais;

import java.util.Scanner;

//@author Felipe Freitas

public class MenuInserir {

	public static void main(String[] args) {

		InserirNoBanco inserir = new InserirNoBanco();
		int a = 1;
		while (a == 1) {

			Scanner sc = new Scanner(System.in);

			System.out.println("escolha uma opção: ");
			System.out.println("1-inserir projeto");
			System.out.println("2-inserir usuario");
			System.out.println("3-inserir artefato");
			System.out.println("4-inserir nivel teste");
			System.out.println("5-inserir tipo teste");
			System.out.println("6-inserir item teste");
			System.out.println("7-inserir ferramenta");
			System.out.println("8-inserir criterio da aceitação");
			System.out.println("9-inserir nivel teste projeto");
			System.out.println("10-inserir tipo teste projeto");
			System.out.println("11-inserir ferramenta projeto");
			System.out.println("12-inserir artefato projeto");

			int escolha = sc.nextInt();
			switch (escolha) {

			case 1:
				inserir.inserirProjeto();
				break;
			case 2:
				inserir.inserirUsuario();
				break;
			case 3:
				inserir.inserirArtefato();
				break;
			case 4:
				inserir.inserirNivelTeste();
				break;
			case 5:
				inserir.inserirTipoTeste();
				break;
			case 6:
				inserir.inseriItemTeste();
				break;
			case 7:
				inserir.inserirFerramenta();
				break;
			case 8:
				inserir.inserirCriterioAceitacao();
				break;
			case 9:
				inserir.inserirNivelTesteProjeto();
				break;
			case 10:
				inserir.inserirTipoTesteProjeto();
				break;
			case 11:
				inserir.inserirFerramentaProjeto();
				break;
			case 12:
				inserir.inserirArtefatoProjeto();
				break;
			default:
				break;
			}

		}
	}
}
