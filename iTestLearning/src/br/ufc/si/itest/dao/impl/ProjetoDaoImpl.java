/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.ProjetoDao;
import br.ufc.si.itest.model.NivelDificuldade;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class ProjetoDaoImpl implements ProjetoDao {

	public void save(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(projeto);
		t.commit();
		session.close();
		
	}

	public void remove(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(projeto);
		t.commit();
		session.close();
		
	}

	public void update(Projeto projeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(projeto);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<Projeto> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(Projeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Projeto> getProjetoByNivelDificuldade(NivelDificuldade nivelDificuldade) {
		Session session = HibernateUtil.getSession();
		String query = "from Projeto where nivelDificuldade = :nivelDificuldade";
		try {
			return session.createQuery(query).setInteger("nivelDificuldade", nivelDificuldade.getId())
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Projeto getProjetoById(Integer id) {
		Session session = HibernateUtil.getSession();
		String query = "from Projeto where id = :id";
		try {
			return (Projeto) session.createQuery(query).setInteger("id", id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	
	@Override
	public Projeto getProjetoByName(String nome) {
		Session session = HibernateUtil.getSession();
		String query = "from Projeto where nome = :nome";
		try {
			return (Projeto) session.createQuery(query).setString("nome", nome)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do método
	
	

}//fim da classe
