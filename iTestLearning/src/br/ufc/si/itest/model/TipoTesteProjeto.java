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
@Table(name="itest.tipo_teste_projeto")
public class TipoTesteProjeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TipoTesteProjetoPk pk;
	
	@Column(name="resposta")
	private Boolean resposta;
	
	@Column(name="mensagem")
	private String mensagem;
	
	public TipoTesteProjetoPk getPk() {
		return pk;
	}

	public void setPk(TipoTesteProjetoPk pk) {
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

	public static class TipoTesteProjetoPk implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@ManyToOne
		@JoinColumn(name = "id_tipo_teste", nullable = false)
		private TipoTeste tipoTeste;
		
		@ManyToOne
		@JoinColumn(name = "id_projeto", nullable = false)
		private Projeto projeto;

		public TipoTeste getTipoTeste() {
			return tipoTeste;
		}

		public void setTipoTeste(TipoTeste tipoTeste) {
			this.tipoTeste = tipoTeste;
		}

		public Projeto getProjeto() {
			return projeto;
		}

		public void setProjeto(Projeto projeto) {
			this.projeto = projeto;
		}
	}
	
	public String toString() {
		return "\n id_projeto: " + this.getPk().getProjeto().getId()
				+ " \n id_ferramenta: " + this.getPk().getTipoTeste().getId()
				+ "\n resposta:" + this.getResposta() + "\n mensagem: " + this.getMensagem();
	}// fim do método
}//fim da classe
