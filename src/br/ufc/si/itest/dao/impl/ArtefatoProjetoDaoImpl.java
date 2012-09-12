/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.ArtefatoProjetoDao;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class ArtefatoProjetoDaoImpl implements ArtefatoProjetoDao {

	public void save(ArtefatoProjeto artefatoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(artefatoProjeto);
		t.commit();
		session.close();		
	}

	public void remove(ArtefatoProjeto artefatoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(artefatoProjeto);
		t.commit();
		session.close();		
	}

	public void update(ArtefatoProjeto artefatoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(artefatoProjeto);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<ArtefatoProjeto> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(ArtefatoProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
