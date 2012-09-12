/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.NivelDificuldadeDao;
import br.ufc.si.itest.model.NivelDificuldade;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class NivelDificuldadeDaoImpl implements NivelDificuldadeDao {

	public void save(NivelDificuldade nivelDificuldade) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(nivelDificuldade);
		t.commit();
		session.close();
		
	}

	public void remove(NivelDificuldade nivelDificuldade) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(nivelDificuldade);
		t.commit();
		session.close();
		
	}

	public void update(NivelDificuldade nivelDificuldade) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(nivelDificuldade);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<NivelDificuldade> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(NivelDificuldade.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
