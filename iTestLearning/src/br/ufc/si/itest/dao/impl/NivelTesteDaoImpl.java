/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.NivelTesteDao;
import br.ufc.si.itest.model.NivelTeste;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class NivelTesteDaoImpl implements NivelTesteDao {

	public void save(NivelTeste nivelTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(nivelTeste);
		t.commit();
		session.close();
		
	}

	public void remove(NivelTeste nivelTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(nivelTeste);
		t.commit();
		session.close();
		
	}

	public void update(NivelTeste nivelTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(nivelTeste);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<NivelTeste> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(NivelTeste.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NivelTesteProjeto> getItensTesteByProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from NivelTesteProjeto where pk.projeto = :idProjeto";
		try {
			return session.createQuery(query).setInteger("idProjeto", idProjeto)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do método
	
	
	public NivelTeste getNivelTesteByName(String nome_nivel_teste){
		Session session = HibernateUtil.getSession();
		
		try{
			Criteria criteria = session.createCriteria(NivelTeste.class);
			criteria.add(Restrictions.eq("nome", nome_nivel_teste));
			return (NivelTeste) criteria.uniqueResult();
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			session.close();
		}
		
		return null;
	}//fim do método nivel teste

}//fim da classe
