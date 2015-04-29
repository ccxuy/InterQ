package util;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.criterion.*;

/**
 * @author yxx03
 *
 */

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
 
	private static SessionFactory buildSessionFactory() {
		System.out.println("HibernateUtil: Working Directory = " +
	              System.getProperty("user.dir"));
		try {
			Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			// Log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
	
}
