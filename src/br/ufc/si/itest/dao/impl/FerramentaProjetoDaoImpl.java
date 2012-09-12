/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.FerramentaProjetoDao;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class FerramentaProjetoDaoImpl implements FerramentaProjetoDao {

	public void save(FerramentaProjetoDao ferramentaProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(ferramentaProjeto);
		t.commit();
		session.close();
		
	}

	public void remove(FerramentaProjetoDao ferramentaProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(ferramentaProjeto);
		t.commit();
		session.close();
		
	}

	public void update(FerramentaProjetoDao ferramentaProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(ferramentaProjeto);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<FerramentaProjetoDao> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(FerramentaProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
