package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.connection.ConnectionBd;
import com.model.Hero;
import com.model.Model;

public abstract class GenericDao {
	
	protected static GenericDao genericDao;
	protected SessionFactory sessionFactory;
	protected ConnectionBd connection;
	protected Session session;
	protected EntityManager manager;
	protected EntityTransaction tx;

	
	public GenericDao () {
		
	}
	
//	public static GenericDao getGenericDao() {
//		if(genericDao == null) {
//			genericDao = new GenericDao();
//		}
//		return genericDao;
//	}
	
	protected void initialize(){
		manager = ConnectionBd.getEntityManager();
		tx = manager.getTransaction();
		tx.begin();
		
	}
	
}
