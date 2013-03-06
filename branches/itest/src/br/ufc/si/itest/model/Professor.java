package br.ufc.si.itest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="itest.professor")
@PrimaryKeyJoinColumn(name="id_prof")
public class Professor extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="professor")
	private List<Turma> minhasTurmas;

	public List<Turma> getMinhasTurmas() {
		return minhasTurmas;
	}

	public void setMinhasTurmas(List<Turma> minhasTurmas) {
		this.minhasTurmas = minhasTurmas;
	}

	
	
}
