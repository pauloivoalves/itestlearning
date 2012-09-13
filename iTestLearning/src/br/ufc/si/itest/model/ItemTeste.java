/**
 * 
 */
package br.ufc.si.itest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Virginia
 *
 */
@Entity
@Table(name="itest.item_teste")
public class ItemTeste implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Integer id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="resposta")
	private Boolean resposta;
	
	@Column(name="mensagem")
	private String mensagem;
	
	@ManyToOne
	@JoinColumn(name="id_projeto")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Projeto projeto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof ItemTeste)
			if(((ItemTeste)other).getId().equals(this.id))
				return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + this.id;
		return hash;
	}

}//fim da classe
