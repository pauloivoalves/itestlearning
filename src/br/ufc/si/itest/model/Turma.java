package br.ufc.si.itest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Mardson
 * 
 */


@Entity
@Table(name="itest.turma")
public class Turma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String codigo;
	
	private String nome;
	
	@ManyToMany
	@JoinTable(name="itest.aluno_turma", joinColumns={@JoinColumn(name="id_turma")}, inverseJoinColumns={@JoinColumn(name="id_aluno")})
	private List<Aluno> alunos;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Professor professor;
	

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Turma() {
		super();
	}

	public Turma(int id, String nome, List<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.alunos = alunos;
	}

	public Turma(int id, String codigo, String nome, List<Aluno> alunos,
			Professor professor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.alunos = alunos;
		this.professor = professor;
	}
	
	
	
	
	
}
