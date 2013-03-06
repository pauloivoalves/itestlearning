package br.ufc.si.itest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.xml.internal.ws.developer.SchemaValidation;


@Entity
@Table(name="itest.turma")
public class Turma implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy="turma")
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

	public Turma() {
		super();
	}

	public Turma(int id, String nome, List<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.alunos = alunos;
	}
	
	
}
