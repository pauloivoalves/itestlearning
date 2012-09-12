/**
 * 
 */
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
@Table(name="itest.projeto")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_nivel_dificuldade", nullable = false)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private NivelDificuldade nivelDificuldade;
	
	@ManyToMany
	@JoinTable(name="itest.nivel_teste_projeto", joinColumns=@JoinColumn(name="id_projeto"), inverseJoinColumns=@JoinColumn(name="id_nivel_teste"))
	private List<NivelTeste> niveisTeste;
	
	@ManyToMany
	@JoinTable(name="itest.tipo_teste_projeto", joinColumns=@JoinColumn(name="id_projeto"), inverseJoinColumns=@JoinColumn(name="id_tipo_teste"))
	private List<TipoTeste> tiposTeste;
	
	@ManyToMany
	@JoinTable(name="itest.ferramenta_projeto", joinColumns=@JoinColumn(name="id_projeto"), inverseJoinColumns=@JoinColumn(name="id_ferramenta"))
	private List<Ferramenta> ferramentas;
	
	@ManyToMany
	@JoinTable(name="itest.artefato_projeto", joinColumns=@JoinColumn(name="id_projeto"), inverseJoinColumns=@JoinColumn(name="id_artefato"))
	private List<Artefato> artefatos;
	
	public Projeto() {
		
	}
	
	public Projeto(Integer id){
		this.id = id;
	}

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

	public NivelDificuldade getNivelDificuldade() {
		return nivelDificuldade;
	}

	public void setNivelDificuldade(NivelDificuldade nivelDificuldade) {
		this.nivelDificuldade = nivelDificuldade;
	}

	public List<NivelTeste> getNiveisTeste() {
		return niveisTeste;
	}

	public void setNiveisTeste(List<NivelTeste> niveisTeste) {
		this.niveisTeste = niveisTeste;
	}

	public List<TipoTeste> getTiposTeste() {
		return tiposTeste;
	}

	public void setTiposTeste(List<TipoTeste> tiposTeste) {
		this.tiposTeste = tiposTeste;
	}

	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

	public List<Artefato> getArtefatos() {
		return artefatos;
	}

	public void setArtefatos(List<Artefato> artefatos) {
		this.artefatos = artefatos;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Projeto)
			if(((Projeto)other).getId().equals(this.id))
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
