/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	
	public NivelDificuldade getNivelDificuldadeByName(String nome_nivel_dificuldade){
		Session session = HibernateUtil.getSession();
		
		try{
			Criteria criteria = session.createCriteria(NivelDificuldade.class);
			criteria.add(Restrictions.eq("nome", nome_nivel_dificuldade));
			return (NivelDificuldade) criteria.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return null;
		
	}//fim do método buscar dificuldade pelo nome

	@Override
	public NivelDificuldade getNivelDificuldadeById(int id) {
Session session = HibernateUtil.getSession();
		
		try{
			Criteria criteria = session.createCriteria(NivelDificuldade.class);
			criteria.add(Restrictions.eq("id", id));
			return (NivelDificuldade) criteria.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}


}
