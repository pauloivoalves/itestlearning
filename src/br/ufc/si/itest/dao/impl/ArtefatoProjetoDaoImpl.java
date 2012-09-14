/**
 * 
 */
package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ufc.si.itest.dao.ArtefatoProjetoDao;
import br.ufc.si.itest.model.ArtefatoProjeto;
import br.ufc.si.itest.utils.HibernateUtil;

/**
 * @author Virginia
 * 
 */
public class ArtefatoProjetoDaoImpl implements ArtefatoProjetoDao {

	public void save(ArtefatoProjeto artefatoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.save(artefatoProjeto);
		t.commit();
		session.close();
	}

	public void remove(ArtefatoProjeto artefatoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(artefatoProjeto);
		t.commit();
		session.close();
	}

	public void update(ArtefatoProjeto artefatoProjeto) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.update(artefatoProjeto);
		t.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<ArtefatoProjeto> list() {
		Session session = HibernateUtil.getSession();
		try {
			return session.createCriteria(ArtefatoProjeto.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}// fim do método

	public List<ArtefatoProjeto> getArtefatProjetoByIdProjeto(int id_projeto) {
		Session session = HibernateUtil.getSession();
		String query = "from ArtefatoProjeto where pk.projeto = :idProjeto";
		try {
			return session.createQuery(query)
					.setInteger("idProjeto", id_projeto).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}// fim do método

	public ArtefatoProjeto getArtefatProjetoByIdProjetoIdArtefato(
			int id_projeto, int id_artefato) {
		Session session = HibernateUtil.getSession();
		String query = "from ArtefatoProjeto where pk.projeto = :idProjeto and pk.artefato = :idArtefato";

		try {
			Query consulta = session.createQuery(query);
			consulta.setInteger("idProjeto", id_projeto);
			consulta.setInteger("idArtefato", id_artefato);
			return (ArtefatoProjeto) consulta.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}// fim do método

}// fim da classe
