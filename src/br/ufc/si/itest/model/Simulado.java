package br.ufc.si.itest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="itest.simulado")
public class Simulado {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private Jogo jogo;
	
	@OneToOne
	private Turma turma;

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

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Simulado(int id, String nome, Jogo jogo, Turma turma) {
		super();
		this.id = id;
		this.nome = nome;
		this.jogo = jogo;
		this.turma = turma;
	}

	public Simulado() {
		super();
	}
	
    
	
}//fim da classe simulado
