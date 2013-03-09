package br.ufc.si.itest.testes;

import java.util.List;

import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.dao.impl.ProjetoDaoImpl;
import br.ufc.si.itest.model.Projeto;

public class TestaProjeto {

	public static void main(String[] args) {
			testaListarTodosProjetos();
	}

	private static void testaListarTodosProjetos() {
		ProjetoDao pdao = new ProjetoDaoImpl();
		List<Projeto> projetos = pdao.list();
		for (Projeto p : projetos) {
			System.out.println(p.getNome());
			System.out.println(p.getDescricao());
		}
	}
}
