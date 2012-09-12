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
@Table(name="itest.nivel_teste_projeto")
public class NivelTesteProjeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private NivelTesteProjetoPk pk;
	
	@Column(name="resposta")
	private Boolean resposta;
	
	@Column(name="mensagem")
	private String mensagem;
	
	public NivelTesteProjetoPk getPk() {
		return pk;
	}

	public void setPk(NivelTesteProjetoPk pk) {
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

	public static class NivelTesteProjetoPk implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@ManyToOne
		@JoinColumn(name = "id_nivel_teste", nullable = false)
		private NivelTeste nivelTeste;
		
		@ManyToOne
		@JoinColumn(name = "id_projeto", nullable = false)
		private Projeto projeto;

		public NivelTeste getNivelTeste() {
			return nivelTeste;
		}

		public void setNivelTeste(NivelTeste nivelTeste) {
			this.nivelTeste = nivelTeste;
		}

		public Projeto getProjeto() {
			return projeto;
		}

		public void setProjeto(Projeto projeto) {
			this.projeto = projeto;
		}
	}
}
