package br.ufc.si.itest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.ProfessorDao;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Professor;
import br.ufc.si.itest.model.Usuario;
import br.ufc.si.itest.utils.HibernateUtil;

public class ProfessorDaoImpl implements ProfessorDao{

	@Override
	public void save(Professor professor) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(professor);
		t.commit();
		session.close();
	}

	@Override
	public List<Professor> list() {
		Session session = HibernateUtil.getSession();
		List<Professor> professores = new ArrayList<Professor>();
		List<Usuario> usuarios = session.createCriteria(Usuario.class).list();
		try {
			for(Usuario u: usuarios){
				if(u instanceof Professor){
					professores.add((Professor)u);
				}
			}
			return professores;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void update(Professor professor) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(professor);
		t.commit();
		session.close();
		
	}

	@Override
	public void delete(Professor professor) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(professor);
		t.commit();
		session.close();
		
	}

	@Override
	public Professor getProfessorById(int id) {
		Session session = HibernateUtil.getSession();
		try{
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("id", id));
			return (Professor) criteria.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
