package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.CasoDeTesteDao;
import br.ufc.si.itest.model.CasoDeTeste;
import br.ufc.si.itest.utils.HibernateUtil;

public class CasoDeTesteDaoImpl implements CasoDeTesteDao {

	@Override
	public void save(CasoDeTeste casoDeTeste) {

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(casoDeTeste);
		t.commit();
		session.close();

		// TODO Auto-generated method stub

	}

	@Override
	public void remove(CasoDeTeste casoDeTeste) {

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(casoDeTeste);
		t.commit();
		session.close();
	}

	@Override
	public void update(CasoDeTeste casoDeTeste) {

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(casoDeTeste);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CasoDeTeste> list() {

		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(CasoDeTeste.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CasoDeTeste> getCasoDeTesteByIdProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from CasoDeTeste where projeto = :idProjeto";
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
