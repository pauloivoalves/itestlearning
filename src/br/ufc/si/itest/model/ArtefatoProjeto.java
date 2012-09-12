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
@Table(name="itest.artefato_projeto")
public class ArtefatoProjeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ArtefatoProjetoPk pk;
	
	@Column(name="resposta")
	private Boolean resposta;
	
	@Column(name="mensagem")
	private String mensagem;
	
	public ArtefatoProjetoPk getPk() {
		return pk;
	}

	public void setPk(ArtefatoProjetoPk pk) {
		this.pk = pk;
	}

	public Boolean getResposta() {
		return resposta;
	}

	public void setResposta(Boolean resposta) {
		this.resposta = resposta;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public static class ArtefatoProjetoPk implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@ManyToOne
		@JoinColumn(name = "id_artefato", nullable = false)
		private Artefato artefato;
		
		@ManyToOne
		@JoinColumn(name = "id_projeto", nullable = false)
		private Projeto projeto;

		public Artefato getArtefato() {
			return artefato;
		}

		public void setArtefato(Artefato artefato) {
			this.artefato = artefato;
		}

		public Projeto getProjeto() {
			return projeto;
		}

		public void setProjeto(Projeto projeto) {
			this.projeto = projeto;
		}
	}
}
