package com.dao;

import org.apache.catalina.Manager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.ConnectionBd;
import com.model.Model;

public class CrudDao extends GenericDao{
	
	public void insert(Model model) {
		
		super.initialize();
        try {

            manager.persist(model);
            tx.commit();
            
        }
        catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        }
        manager.close();
	}
	
	public void delete(Model model) {
		super.initialize();
        try {

            model = manager.find(Model.class, model.getId());
            manager.remove(model);
            tx.commit();
        }
        finally {
        	manager.close();
            
        }
        
	}
	
	public void update(Model model) {
		super.initialize();
        try {

            manager.merge(model);
            tx.commit();
        }
        finally {
            manager.close();
        }
	}

}
