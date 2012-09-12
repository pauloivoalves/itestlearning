/**
 * 
 */
package br.ufc.si.itest.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author Virginia
 *
 */
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private HibernateUtil() {
	}
	
	public static Session getSession() {
		if (sessionFactory == null) {
			try {
				sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory.openSession();
	}

}
