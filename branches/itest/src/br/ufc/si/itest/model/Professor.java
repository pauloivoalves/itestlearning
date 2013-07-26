package br.ufc.si.itest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Mardson
 * 
 */

@Entity
@Table(name = "itest.professor")
@PrimaryKeyJoinColumn(name = "id_prof")
public class Professor extends Usuario {

	@OneToMany(mappedBy = "professor")
	private List<Turma> turmas;

	public List<Turma> getTurmas() {
		return turmas;
	}

	@OneToMany(mappedBy="professor")
	private List<Simulado> simulados;

	
	public List<Simulado> getSimulados() {
		return simulados;
	}

	
	public void setSimulados(List<Simulado> simulados) {
		this.simulados = simulados;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

}
