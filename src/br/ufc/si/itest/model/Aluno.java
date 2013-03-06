package br.ufc.si.itest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="itest.aluno")
@PrimaryKeyJoinColumn(name="id_aluno")
public class Aluno extends Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@OneToMany(mappedBy="aluno")
	private List<Jogo> Jogos;
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Turma turma;

	
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Jogo> getJogos() {
		return Jogos;
	}

	public void setJogos(List<Jogo> meusJogos) {
		this.Jogos = meusJogos;
	}

}
