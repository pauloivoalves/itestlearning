package br.ufc.si.itest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Mardson
 * 
 */

@Entity
@Table(name = "itest.aluno")
@PrimaryKeyJoinColumn(name = "id_aluno")
public class Aluno extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "aluno")
	private List<Jogo> Jogos;

	@ManyToMany
	@JoinTable(name = "itest.aluno_turma", joinColumns = { @JoinColumn(name = "id_aluno") }, inverseJoinColumns = { @JoinColumn(name = "id_turma") })
	private List<Turma> turmas;

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Jogo> getJogos() {
		return Jogos;
	}

	public void setJogos(List<Jogo> meusJogos) {
		this.Jogos = meusJogos;
	}

}
