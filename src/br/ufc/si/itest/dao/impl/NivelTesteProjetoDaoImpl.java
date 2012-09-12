/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.NivelTesteProjetoDao;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class NivelTesteProjetoDaoImpl implements NivelTesteProjetoDao {

	public void save(NivelTesteProjeto nivelTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(nivelTesteProjeto);
		t.commit();
		session.close();
		
	}

	public void remove(NivelTesteProjeto nivelTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(nivelTesteProjeto);
		t.commit();
		session.close();
		
	}

	public void update(NivelTesteProjeto nivelTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(nivelTesteProjeto);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<NivelTesteProjeto> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(NivelTesteProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
