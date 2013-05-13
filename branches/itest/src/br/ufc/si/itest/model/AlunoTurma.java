package br.ufc.si.itest.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Mardson
 *
 */


@Entity
@Table(name="itest.aluno_turma")
public class AlunoTurma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AlunoTurmaPK pk;

	public AlunoTurmaPK getPk() {
		return pk;
	}

	public void setPk(AlunoTurmaPK pk) {
		this.pk = pk;
	}

	public static class AlunoTurmaPK implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@ManyToOne
		@JoinColumn(name = "id_aluno", nullable = false)
		private Aluno aluno;

		@ManyToOne
		@JoinColumn(name = "id_turma", nullable = false)
		private Turma turma;

		public Aluno getAluno() {
			return aluno;
		}

		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}

		public Turma getTurma() {
			return turma;
		}

		public void setTurma(Turma turma) {
			this.turma = turma;
		}

	}// fim da classe AlunoTurmaPK

}// fim da classe AlunoTurma
