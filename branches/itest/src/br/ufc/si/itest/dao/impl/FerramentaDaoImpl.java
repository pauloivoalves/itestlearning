/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.FerramentaDao;
import br.ufc.si.itest.model.Ferramenta;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class FerramentaDaoImpl implements FerramentaDao {

	public void save(Ferramenta ferramenta) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(ferramenta);
		t.commit();
		session.close();
		
	}

	public void remove(Ferramenta ferramenta) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(ferramenta);
		t.commit();
		session.close();
		
	}

	public void update(Ferramenta ferramenta) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(ferramenta);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<Ferramenta> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(Ferramenta.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FerramentaProjeto> getItensTesteByProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from FerramentaProjeto where pk.projeto = :idProjeto";
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
	
	
	public Ferramenta getFerramentaByNome(String nome){
		Session sessao = HibernateUtil.getSession();
		try{
			Criteria criteria = sessao.createCriteria(Ferramenta.class);
			criteria.add(Restrictions.eq("nome", nome));
			return (Ferramenta) criteria.uniqueResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sessao.close();
		}
		
		return null;
	}//fim do m�todo

	@Override
	public Ferramenta getFerramentaByName(String nome) {
		Session session = HibernateUtil.getSession();
		String query = "from Ferramenta where nome = :nome";
		try {
			return (Ferramenta) session.createQuery(query).setString("nome", nome)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	
}//fim da classe
