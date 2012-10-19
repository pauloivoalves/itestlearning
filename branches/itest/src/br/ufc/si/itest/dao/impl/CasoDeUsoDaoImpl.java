package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.CasoDeUsoDao;
import br.ufc.si.itest.model.CasoDeUso;
import br.ufc.si.itest.utils.HibernateUtil;

public class CasoDeUsoDaoImpl implements CasoDeUsoDao {

	@Override
	public void save(CasoDeUso faseProjeto) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(faseProjeto);
		t.commit();
		session.close();

	}

	@Override
	public void update(CasoDeUso faseProjeto) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(faseProjeto);
		t.commit();
		session.close();

	}

	@Override
	public void remove(CasoDeUso faseProjeto) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(faseProjeto);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CasoDeUso> list() {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(CasoDeUso.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CasoDeUso> getCasoDeUsoByIdProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from FaseProjeto where projeto = :idProjeto";
		try {
			return session.createQuery(query)
					.setInteger("idProjeto", idProjeto).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
