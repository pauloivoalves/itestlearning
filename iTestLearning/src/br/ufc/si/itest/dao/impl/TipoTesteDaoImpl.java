/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.TipoTesteDao;
import br.ufc.si.itest.model.TipoTeste;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */

public class TipoTesteDaoImpl implements TipoTesteDao {

	public void save(TipoTeste tipoTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(tipoTeste);
		t.commit();
		session.close();
		
	}

	public void remove(TipoTeste tipoTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(tipoTeste);
		t.commit();
		session.close();
		
	}

	public void update(TipoTeste tipoTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(tipoTeste);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<TipoTeste> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(TipoTeste.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoTesteProjeto> getItensTesteByProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from TipoTesteProjeto where pk.projeto = :idProjeto";
		try {
			return session.createQuery(query).setInteger("idProjeto", idProjeto)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public TipoTeste getTipoTesteByNome(String nome){
		Session session = HibernateUtil.getSession();
		
		try{
			Criteria c = session.createCriteria(TipoTeste.class);
			c.add(Restrictions.eq("nome", nome));
			return (TipoTeste) c.uniqueResult();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return null;
	}//fim do método

}//fim da classe
