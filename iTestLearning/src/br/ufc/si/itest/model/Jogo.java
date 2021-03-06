/**
 * 
 */
package br.ufc.si.itest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Virginia
 *
 */
@Entity
@Table(name="itest.jogo")
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private JogoPk pk;
	
	@Column(name= "pontuacao", nullable = false)
	private Integer pontuacao;
	
	public JogoPk getPk() {
		return pk;
	}

	public void setPk(JogoPk pk) {
		this.pk = pk;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public static class JogoPk implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@ManyToOne
		@JoinColumn(name = "id_usuario", nullable = false)
		private Usuario usuario;
		
		@ManyToOne
		@JoinColumn(name = "id_projeto", nullable = false)
		private Projeto projeto;

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Projeto getProjeto() {
			return projeto;
		}

		public void setProjeto(Projeto projeto) {
			this.projeto = projeto;
		}
		
	}

}//fim da classe
