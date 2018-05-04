package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory mysession;

	public HibernateUtil() {
	}

	// The configure method, can take a filename, but by
	// default, it looks for a configuration file
	// name: 'hibernate.cfg.xml
	public static SessionFactory getSession() {
		if (mysession == null) {
			mysession = new Configuration().configure().buildSessionFactory();
		}
		return mysession;
	}

}
