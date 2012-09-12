/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.UsuarioDao;
import br.ufc.si.itest.model.Usuario;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class UsuarioDaoImpl implements UsuarioDao {

	public void save(Usuario usuario) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(usuario);
		t.commit();
		session.close();
		
	}

	public void remove(Usuario usuario) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(usuario);
		t.commit();
		session.close();
		
	}

	public void update(Usuario usuario) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(usuario);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(Usuario.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public Usuario getUsuarioByNome(String nome){
		Session session = HibernateUtil.getSession();
		
		try{
			Criteria c = session.createCriteria(Usuario.class);
			c.add(Restrictions.eq("nome", nome));
			return (Usuario) c.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}//fim do método

}//fim da classe
