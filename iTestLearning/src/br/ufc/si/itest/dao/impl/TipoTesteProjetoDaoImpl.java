/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.TipoTesteProjetoDao;
import br.ufc.si.itest.model.NivelTesteProjeto;
import br.ufc.si.itest.model.TipoTesteProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 *
 */
public class TipoTesteProjetoDaoImpl implements TipoTesteProjetoDao {

	public void save(TipoTesteProjetoDao tipoTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(tipoTesteProjeto);
		t.commit();
		session.close();
		
	}

	public void remove(TipoTesteProjetoDao tipoTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(tipoTesteProjeto);
		t.commit();
		session.close();
		
	}

	public void update(TipoTesteProjeto tipoTesteProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(tipoTesteProjeto);
		t.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	public List<TipoTesteProjetoDao> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(TipoTesteProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public List<TipoTesteProjeto> getTipoTesteProjetoByIdProjeto(int id_projeto){
		Session session = HibernateUtil.getSession();
		String query = "from TipoTesteProjeto where pk.projeto = :idProjeto";
		try {
			return session.createQuery(query).setInteger("idProjeto", id_projeto)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do método tipotesteprojeto por id
	
	public TipoTesteProjeto getTipoTesteProjetoByIdProjetoIdTipoTeste(int id_projeto,int id_tipo_teste){
		Session session = HibernateUtil.getSession();
		String query = "from TipoTesteProjeto where pk.projeto = :idProjeto and pk.tipoTeste = :idTipoTeste";
		
		try {
			Query consulta = session.createQuery(query);
			consulta.setInteger("idProjeto", id_projeto);
			consulta.setInteger("idTipoTeste", id_tipo_teste);
			return (TipoTesteProjeto) consulta.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}//fim do método

}//fim da classe
