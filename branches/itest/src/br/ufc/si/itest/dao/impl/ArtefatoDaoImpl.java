/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.ArtefatoDao;
import br.ufc.si.itest.model.Artefato;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class ArtefatoDaoImpl implements ArtefatoDao {

	public void save(Artefato artefato) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(artefato);
		t.commit();
		session.close();		
	}

	public void remove(Artefato artefato) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(artefato);
		t.commit();
		session.close();		
	}

	public void update(Artefato artefato) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(artefato);
		t.commit();
		session.close();		
	}

	@SuppressWarnings("unchecked")
	public List<Artefato> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(Artefato.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArtefatoProjeto> getArtefatosByProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from ArtefatoProjeto where pk.projeto = :idProjeto";
		try {
			return session.createQuery(query).setInteger("idProjeto", idProjeto)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do m�todo
	
	public Artefato getArtefatoByName(String nome_artefato){
		Session session = HibernateUtil.getSession();
		
		try{
			Criteria criteria = session.createCriteria(Artefato.class);
			criteria.add(Restrictions.eq("nome", nome_artefato));
			return (Artefato) criteria.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return null;
	}//fim do m�todo buscar artefato por nome
	
	
}//fim da classe
