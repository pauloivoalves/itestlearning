package br.ufc.si.itest.testes;

import junit.framework.TestCase;
import br.ufc.si.itest.dao.UsuarioDao;
import br.ufc.si.itest.dao.impl.UsuarioDaoImpl;
import br.ufc.si.itest.model.Administrador;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Usuario;
import br.ufc.si.itest.persistencia.CriarTabelas;

public class TestaUsuario{
	/*
	public void testeBuscarUsuarioPorEmaileConta(){
		UsuarioDao userdao = new UsuarioDaoImpl();
		Usuario user = new Usuario();
		
		assertEquals(user, userdao.buscarUsuarioPorEmaileSenha("login", "senha"));
	}
	
	*/
	private static void listUsers(){
		UsuarioDao userdao = new UsuarioDaoImpl();
		for(Usuario u: userdao.list()){
			System.out.println(u.getNome());
		}
	}

	private static void salvar(){
		Administrador a = new Administrador();
		
		a.setLogin("4");
		a.setNome("asdf");
		a.setSenha("a");
		UsuarioDao userdao = new UsuarioDaoImpl();
		userdao.save(a);
	}
	
	public static void main(String[] args) {
		//listUsers();
		//CriarTabelas.prepararSessao();
		//CriarTabelas.reiniciaBanco();
		
		salvar();
		
	}
}//fim da classe
