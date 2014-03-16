/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.JogoDao;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 * 
 */

public class JogoDaoImpl implements JogoDao {

	public void save(Jogo jogo) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(jogo);
		t.commit();
		session.close();

	}

	public void remove(Jogo jogo) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(jogo);
		t.commit();
		session.close();

	}

	public void update(Jogo jogo) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(jogo);
		t.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<Jogo> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(Jogo.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jogo> getJogoByProjeto(Integer projeto) {
		Session session = HibernateUtil.getSession();
		String query = "from Jogo where  pk.projeto = :projeto order by pontuacao desc";
		try {
			return session.createQuery(query).setInteger("projeto", projeto)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jogo> getJogoById(Integer id) {
		Session session = HibernateUtil.getSession();
		String query = "from Jogo where aluno_id_aluno = :id ";
		try {
			return session.createQuery(query).setInteger("id", id).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Jogo> getJogoByUsuario(Integer id_usuario) {
		Session session = HibernateUtil.getSession();
		String query = "from Jogo where id_usuario = :id ";
		try {
			return session.createQuery(query).setInteger("id", id_usuario)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Jogo> getJogoByTurmaProjeto(Integer id_turma, Integer id_projeto) {
		Session session = HibernateUtil.getSession();
		String query = "from Jogo where id_turma = :id and id_projeto = :id2";
		try {
			return session.createQuery(query).setInteger("id", id_turma)
					.setInteger("id2", id_projeto).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jogo> getJogoByUsárioProjeto(Integer id_usuario,
			Integer id_projeto) {
		Session session = HibernateUtil.getSession();
		String query = "from Jogo where id_usuario = :id and id_projeto = :id2";
		try {
			return session.createQuery(query).setInteger("id", id_usuario)
					.setInteger("id2", id_projeto).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
