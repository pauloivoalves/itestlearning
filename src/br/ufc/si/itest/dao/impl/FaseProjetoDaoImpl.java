package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.FaseProjetoDao;
import br.ufc.si.itest.model.FaseProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

public class FaseProjetoDaoImpl implements FaseProjetoDao {

	@Override
	public void save(FaseProjeto faseProjeto) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(faseProjeto);
		t.commit();
		session.close();

	}

	@Override
	public void update(FaseProjeto faseProjeto) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(faseProjeto);
		t.commit();
		session.close();

	}

	@Override
	public void remove(FaseProjeto faseProjeto) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(faseProjeto);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FaseProjeto> list() {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(FaseProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FaseProjeto> getFaseProjetoAlternativasByIdProjeto(
			Integer idProjeto) {
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

	@Override
	public FaseProjeto getFaseProjetoByIdProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from FaseProjeto where projeto = :idProjeto";
		try {
			return (FaseProjeto) session.createQuery(query)
					.setInteger("idProjeto", idProjeto).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
