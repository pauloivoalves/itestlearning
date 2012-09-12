package br.ufc.si.itest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Virginia
 *
 */
@Entity
@Table(name="itest.nivel_teste")
public class NivelTeste implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToMany
	@JoinTable(name="itest.artefato_projeto", joinColumns={@JoinColumn(name="id_artefato")}, inverseJoinColumns={@JoinColumn(name="id_projeto")})
	private List<Projeto> produtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Projeto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Projeto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof NivelTeste)
			if(((NivelTeste)other).getId().equals(this.id))
				return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + this.id;
		return hash;
	}

}
