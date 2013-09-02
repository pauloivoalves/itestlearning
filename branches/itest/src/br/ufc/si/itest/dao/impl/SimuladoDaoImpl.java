package br.ufc.si.itest.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.SimuladoDao;
import br.ufc.si.itest.model.Professor;
import br.ufc.si.itest.model.Simulado;
import br.ufc.si.itest.utils.HibernateUtil;

public class SimuladoDaoImpl implements SimuladoDao {

	@Override
	public void save(Simulado simulado) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(simulado);
		t.commit();
		session.close();

	}

	@Override
	public void update(Simulado simulado) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(simulado);
		t.commit();
		session.close();
	}

	@Override
	public void delete(Simulado simulado) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(simulado);
		t.commit();
		session.close();
	}

	@Override
	public Simulado getSimuladoById(int id) {
		Session session = HibernateUtil.getSession();
		try {
			return (Simulado) session.get(Simulado.class, id);
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Simulado getSimuladoByData(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Simulado> list(int prof_id) {
		Session session = HibernateUtil.getSession();
		String sql = "from Simulado where professor_id_prof =:prof_id";
		try {
			return session.createQuery(sql).setInteger("prof_id", prof_id)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Simulado> listSimulados(Professor professor) {
		Session session = HibernateUtil.getSession();
		try {
			Criteria c = session.createCriteria(Simulado.class);
			c.add(Restrictions.eq("professor", professor));
			return c.list();
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Simulado> getSimuladoByTurma(int turma_id) {
		Session session = HibernateUtil.getSession();
		String sql = "from Simulado where turma_id =:turma_id";
		try {
			return session.createQuery(sql).setInteger("turma_id", turma_id)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

}
