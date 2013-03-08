package br.ufc.si.itest.bean;

import br.ufc.si.itest.dao.impl.UsuarioDaoImpl;
import br.ufc.si.itest.model.Usuario;

public class UsuarioBean {

	private Usuario usuario;
	private UsuarioDaoImpl usuarioDaoImpl;

	public UsuarioBean() {
		usuario = new Usuario();
	}

	public String verificaConta() {

		Usuario user = new Usuario();
		
		usuarioDaoImpl = new UsuarioDaoImpl();
		user = usuarioDaoImpl.buscarUsuarioPorEmaileSenha(usuario.getNome(),
				usuario.getSenha());
		
		if(user == null)
		return "falhou";
		
		else
		return "sucesso";

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
