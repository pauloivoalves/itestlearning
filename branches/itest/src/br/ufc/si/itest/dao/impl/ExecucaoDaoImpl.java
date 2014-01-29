package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.ExecucaoDao;
import br.ufc.si.itest.model.ExecucaoProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

public class ExecucaoDaoImpl implements ExecucaoDao {

	@Override
	public void save(ExecucaoProjeto execucao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(execucao);
		t.commit();
		session.close();

	}

	@Override
	public void remove(ExecucaoProjeto execucao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(execucao);
		t.commit();
		session.close();

	}

	@Override
	public void update(ExecucaoProjeto execucao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(execucao);
		t.commit();
		session.close();

	}

	@Override
	public List<ExecucaoProjeto> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(ExecucaoProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<ExecucaoProjeto> getOpcoesByIdCasoDeTeste(int id) {
		Session session = HibernateUtil.getSession();
		String query = "from ExecucaoProjeto where id_caso = :id";

		try {
			Query consulta = session.createQuery(query);
			consulta.setInteger("id", id);
			return (List<ExecucaoProjeto>) consulta.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
