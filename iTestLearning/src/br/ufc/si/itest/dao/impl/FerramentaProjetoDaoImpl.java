/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.FerramentaProjetoDao;
import br.ufc.si.itest.model.FerramentaProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class FerramentaProjetoDaoImpl implements FerramentaProjetoDao {

	public void save(FerramentaProjetoDao ferramentaProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(ferramentaProjeto);
		t.commit();
		session.close();
		
	}

	public void remove(FerramentaProjetoDao ferramentaProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(ferramentaProjeto);
		t.commit();
		session.close();
		
	}

	public void update(FerramentaProjeto ferramentaProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(ferramentaProjeto);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<FerramentaProjetoDao> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(FerramentaProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do método
	
	
	
	public List<FerramentaProjeto> getFerramentaProjetoByIdProjeto(int id_projeto){
		Session session = HibernateUtil.getSession();
		String query = "from FerramentaProjeto where pk.projeto = :idProjeto";
		try {
			return session.createQuery(query).setInteger("idProjeto", id_projeto)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do método ferrameta projeto por id
	
	public FerramentaProjeto getFerramentaProjetoByIdProjetoIdFerramenta(int id_projeto,int id_ferramenta){
		Session session = HibernateUtil.getSession();
		String query = "from FerramentaProjeto where pk.projeto = :idProjeto and pk.ferramenta = :idFerramenta";
		
		try {
			Query consulta = session.createQuery(query);
			consulta.setInteger("idProjeto", id_projeto);
			consulta.setInteger("idFerramenta", id_ferramenta);
			return  (FerramentaProjeto) consulta.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do método

	
}//fim da classe
