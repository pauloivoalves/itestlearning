package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.AlunoTurmaDao;
import br.ufc.si.itest.model.AlunoTurma;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Mardson
 * 
 */

public class AlunoTurmaDaoImpl implements AlunoTurmaDao{

	@Override
	public void save(AlunoTurma aluno_turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(aluno_turma);
		t.commit();
		session.close();
	}

	@Override
	public void remove(AlunoTurma aluno_turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(aluno_turma);
		t.commit();
		session.close();
	}

	@Override
	public void update(AlunoTurma aluno_turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(aluno_turma);
		t.commit();
		session.close();
	}

	@Override
	public List<AlunoTurma> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(AlunoTurma.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<AlunoTurma> getAlunoTurmaByIdAluno(int id_aluno) {
		Session session = HibernateUtil.getSession();
		String query = "from AlunoTurma where pk.aluno = :idAluno";
		try {
			return session.createQuery(query)
					.setInteger("idAluno", id_aluno).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public AlunoTurma getAlunoTurmaByIdAlunoIdTurma(int id_aluno, int id_turma) {
		Session session = HibernateUtil.getSession();
		String query = "from AlunoTurma where pk.aluno = :id_aluno and pk.turma = :id_turma";

		try {
			Query consulta = session.createQuery(query);
			consulta.setInteger("id_Aluno", id_aluno);
			consulta.setInteger("id_Turma", id_turma);
			return (AlunoTurma) consulta.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<AlunoTurma> getAlunoTurmaByIdTurma(int id_turma) {
		Session session = HibernateUtil.getSession();
		String query = "from AlunoTurma where pk.turma = :idTurma";
		try {
			return session.createQuery(query)
					.setInteger("idTurma", id_turma).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
