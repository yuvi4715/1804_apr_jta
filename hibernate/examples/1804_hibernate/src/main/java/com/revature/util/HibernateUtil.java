package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory mysession;
	
	public HibernateUtil() {
	}

	public static SessionFactory getSession() {
		if(mysession == null) {
			mysession = new Configuration().configure().buildSessionFactory();
		}
		return mysession;
	}
	
}
