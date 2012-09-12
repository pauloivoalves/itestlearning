/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.TipoTesteProjetoDao;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class TipoTesteProjetoDaoImpl implements TipoTesteProjetoDao {

	public void save(TipoTesteProjetoDao tipoTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(tipoTesteProjeto);
		t.commit();
		session.close();
		
	}

	public void remove(TipoTesteProjetoDao tipoTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(tipoTesteProjeto);
		t.commit();
		session.close();
		
	}

	public void update(TipoTesteProjetoDao tipoTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(tipoTesteProjeto);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<TipoTesteProjetoDao> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(TipoTesteProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
