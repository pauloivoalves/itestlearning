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

	public Usuario getUsuarioByNome(String nome) {
		Session session = HibernateUtil.getSession();

		try {
			Criteria c = session.createCriteria(Usuario.class);
			c.add(Restrictions.eq("nome", nome));
			return (Usuario) c.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}// fim do m�todo

	@Override
	public Usuario getUsuarioByName(String nome) {
		Session session = HibernateUtil.getSession();
		String query = "from Usuario where nome = :nome";
		try {
			return (Usuario) session.createQuery(query).setString("nome", nome)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Usuario buscarUsuarioPorEmaileSenha(String email, String senha) {

		Session session = HibernateUtil.getSession();

		try {
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("login", email));
			criteria.add(Restrictions.eq("senha", senha));

			return (Usuario) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		session.close();
		}
		return null;
	}

	@Override
	public Usuario getUsuarioById(int id) {

		Session session = HibernateUtil.getSession();

		try {
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("id", id));
			return (Usuario) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		session.close();
		}
		return null;
	}

}// fim da classe
