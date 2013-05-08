package br.ufc.si.itest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.AlunoDao;
import br.ufc.si.itest.model.Aluno;
import br.ufc.si.itest.model.Jogo;
import br.ufc.si.itest.model.Usuario;
import br.ufc.si.itest.utils.HibernateUtil;

public class AlunoDaoImpl implements AlunoDao{

	@Override
	public void saveAlunos(Aluno aluno) {

		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(aluno);
		t.commit();
		session.close();
		
	}

	@Override
	public void removeAlunos(Aluno aluno) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(aluno);
		t.commit();
		session.close();
	}

	@Override
	public void updateAlunos(Aluno aluno) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(aluno);
		t.commit();
		session.close();
	}

	@Override
	public List<Aluno> listarAlunos() {
		Session session = HibernateUtil.getSession();
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Usuario> usuarios = session.createCriteria(Usuario.class).list();
		try {
			for(Usuario u: usuarios){
				if(u instanceof Aluno){
					alunos.add((Aluno)u);
				}
			}
			return alunos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Usuario getUsuarioByNome(String nome) {
		Session session = HibernateUtil.getSession();
		try{
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("nome", nome));
			return (Usuario) criteria.uniqueResult();
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public List<Jogo> listarMeusJogos(Aluno aluno) {
		Session session = HibernateUtil.getSession();
		try{
			String query = "from Jogo where aluno_id_aluno = :id_usuario";
		return session.createQuery(query).setInteger("id_usuario", aluno.getId()).list();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario getUsuarioByEmail(String email) {
		Session session = HibernateUtil.getSession();
		try{
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("login", email));
			return (Usuario) criteria.uniqueResult();
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public Usuario getUsuarioById(int id) {
		Session session = HibernateUtil.getSession();
		try{
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("id", id));
			return (Usuario) criteria.uniqueResult();
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public List<Aluno> listAlunosByTurma(int id) {
		Session session = HibernateUtil.getSession();
		List<Aluno> alunos = new ArrayList<Aluno>();
		Query query = session.createQuery("from Aluno where turma_id =:id");
		query.setInteger("id", id);
		try{
			alunos = query.list();
			return alunos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	
	}

}
