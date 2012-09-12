/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.ItemTesteDao;
import br.ufc.si.itest.model.ItemTeste;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class ItemTesteDaoImpl implements ItemTesteDao {

	public void save(ItemTeste itemTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(itemTeste);
		t.commit();
		session.close();
		
	}

	public void remove(ItemTeste itemTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(itemTeste);
		t.commit();
		session.close();
		
	}

	public void update(ItemTeste itemTeste) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(itemTeste);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<ItemTeste> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(ItemTeste.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemTeste> getItensTesteByProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from ItemTeste where projeto = :idProjeto";
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
	
	public ItemTeste getItemtesteById(int id){
		Session session = HibernateUtil.getSession();
		
		try{
			return (ItemTeste) session.get(ItemTeste.class, id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return null;
	}//fim do método

}//fim da classe
