package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.TurmaDao;
import br.ufc.si.itest.model.Turma;
import br.ufc.si.itest.utils.HibernateUtil;

public class TurmaDaoImpl implements TurmaDao{

	@Override
	public void save(Turma turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(turma);
		t.commit();
		session.close();
		
	}

	@Override
	public void update(Turma turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(turma);
		t.commit();
		session.close();
		
	}

	@Override
	public void delete(Turma turma) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		
		session.delete(turma);
		t.commit();
		session.close();
		
		
	}

	@Override
	public Turma getTurmaById(int id) {
		Session session = HibernateUtil.getSession();
	     try{
	    	 Turma t = (Turma) session.get(Turma.class, id);
	    	 return t;
	     }catch (Exception e) {
	    	 return null;
		}finally{
			session.close();
		}
	}

	@Override
	public List<Turma> carregarTurmasProfessor(int id_prof) {
		Session session = HibernateUtil.getSession();
		
		try{
			Query query = session.createQuery("from Turma where professor_id_prof =:id_prof");
			query.setInteger("id_prof", id_prof);
			
			return query.list();
			
		}catch (Exception e) {

			e.printStackTrace();
		}finally{
		session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> list() {
		Session session = HibernateUtil.getSession();
	    try{
		   return session.createCriteria(Turma.class).list();
	    }catch (Exception e) {
	    	return null;
		}finally{
			session.close();
		}
		
	}

}
