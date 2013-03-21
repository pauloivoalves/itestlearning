package br.ufc.si.itest.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.ufc.si.itest.dao.impl.UsuarioDaoImpl;
import br.ufc.si.itest.model.Usuario;

public class UsuarioBean {

	private Usuario usuario;
	private UsuarioDaoImpl usuarioDaoImpl;
	private String tipoConta;

	public UsuarioBean() {
		usuario = new Usuario();
	}

	public String verificaConta() {

		Usuario user = new Usuario();

		usuarioDaoImpl = new UsuarioDaoImpl();
		user = usuarioDaoImpl.buscarUsuarioPorEmaileSenha(usuario.getLogin(),
				usuario.getSenha());

		if (user == null) {
			return "falhou";
		}

		else {
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("ID_USUARIO", user.getId());
			session.setAttribute("NOME_USUARIO", user.getNome());
			return "sucesso";
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

}
