package com.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hibernatetutorial.App;
import com.sun.org.apache.xml.internal.security.Init;

public class ConnectionBd {
	
	private static ConnectionBd connection;
	private static final Logger logger = Logger.getLogger(App.class);
	private StandardServiceRegistry registry;
	private static EntityManagerFactory factory;
	
	
	private ConnectionBd(){
		initConnection();
	}
	
	public static ConnectionBd getConnectionBd() {
		if(connection == null) {
			connection = new ConnectionBd();
		}
		
		return connection;
	}
	
	private static void initConnection() {
        
	    factory = Persistence.createEntityManagerFactory("tutorialHibernate");
	        
	}

	public static EntityManager getEntityManager() {
		if(factory == null) {
			initConnection();
		}
		return factory.createEntityManager();
	}
	
	public static void close() {
		factory.close();
	}
	
//	private SessionFactory instanceSessionFactory() {
//	try {
//		final StandardServiceRegistry registry =
//                new StandardServiceRegistryBuilder()
//                        .configure("hibernate_cfg.xml")
//                        .build();
//		
//		
//        sessionFactory = new MetadataSources(registry)
//                .buildMetadata()
//                .buildSessionFactory();
//    }
//    catch (Exception e) {
//        StandardServiceRegistryBuilder.destroy(registry);
//        logger.error("cannot create sessionFactory", e);
//        System.exit(1);
//    }
//	
//	return sessionFactory;	
//}


}
