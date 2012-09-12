/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.CriterioAceitacaoDao;
import br.ufc.si.itest.model.CriterioAceitacao;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class CriterioAceitacaoDaoImpl implements CriterioAceitacaoDao {

	public void save(CriterioAceitacao criterioAceitacao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(criterioAceitacao);
		t.commit();
		session.close();
	}

	public void remove(CriterioAceitacao criterioAceitacao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(criterioAceitacao);
		t.commit();
		session.close();
	}

	public void update(CriterioAceitacao criterioAceitacao) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(criterioAceitacao);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<CriterioAceitacao> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(CriterioAceitacao.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CriterioAceitacao> getCriterioAceitacaoByProjeto(Integer idProjeto) {
		Session session = HibernateUtil.getSession();
		String query = "from CriterioAceitacao where projeto = :idProjeto";
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
	
	
	public CriterioAceitacao getCriterioAceitacaoById(int id){
		Session session = HibernateUtil.getSession();
		
		try{
			return (CriterioAceitacao) session.get(CriterioAceitacao.class, id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}//fim do método critério aceitação por id

}//fim da classe
