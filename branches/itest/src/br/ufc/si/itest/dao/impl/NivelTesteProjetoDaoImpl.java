/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.NivelTesteProjetoDao;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class NivelTesteProjetoDaoImpl implements NivelTesteProjetoDao {

	public void save(NivelTesteProjeto nivelTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(nivelTesteProjeto);
		t.commit();
		session.close();
		
	}

	public void remove(NivelTesteProjeto nivelTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(nivelTesteProjeto);
		t.commit();
		session.close();
		
	}

	public void update(NivelTesteProjeto nivelTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(nivelTesteProjeto);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<NivelTesteProjeto> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(NivelTesteProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do m�todo

	
	public List<NivelTesteProjeto> getNivelTesteProjetoByIdProjeto(int id_projeto){
		Session session = HibernateUtil.getSession();
		String query = "from NivelTesteProjeto where pk.projeto = :idProjeto";
		try {
			return session.createQuery(query).setInteger("idProjeto", id_projeto)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do m�todo niveltesteprojeto por id
	
	public NivelTesteProjeto getNivelTesteProjetoByIdProjetoIdNivelTeste(int id_projeto,int id_nivel_teste){
		Session session = HibernateUtil.getSession();
		String query = "from NivelTesteProjeto where pk.projeto = :idProjeto and pk.nivelTeste = :idNivelTeste";
		
		try {
			Query consulta = session.createQuery(query);
			consulta.setInteger("idProjeto", id_projeto);
			consulta.setInteger("idNivelTeste", id_nivel_teste);
			return   (NivelTesteProjeto) consulta.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do m�todo
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NivelTesteProjeto> getNivelTesteProjetoById(Integer id, Integer idNivelTeste) {
		Session session = HibernateUtil.getSession();
		String query = "from NivelTesteProjeto where id_projeto = :id and id_nivel_teste = :idNivelTeste";
		try {
			return session.createQuery(query).setInteger("id", id).setInteger("idNivelTeste", idNivelTeste).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	
}//fim da classe

