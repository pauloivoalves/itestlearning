package br.ufc.si.itest.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.ufc.si.itest.dao.AdministradorDao;
import br.ufc.si.itest.model.Administrador;
import br.ufc.si.itest.model.Projeto;
import br.ufc.si.itest.utils.HibernateUtil;

public class AdiministradorDaoImpl implements AdministradorDao{

	@Override
	public List<Projeto> listarProjetos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Administrador verificaAdmin(int id){
		Session session = HibernateUtil.getSession();
		try{
			Criteria criteria = session.createCriteria(Administrador.class);
			criteria.add(Restrictions.eq("id_admin", id));
			return (Administrador) criteria.uniqueResult();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
