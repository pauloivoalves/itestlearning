package br.ufc.si.itest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itest.simulado")
public class Simulado {

	@Id
	@GeneratedValue
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	private Projeto projeto;

	@OneToOne(cascade = CascadeType.ALL)
	private Turma turma;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Simulado(int id, String nome, Turma turma) {
		super();
		this.id = id;
		this.turma = turma;
	}

	public Simulado() {
		super();
	}

}// fim da classe simulado
