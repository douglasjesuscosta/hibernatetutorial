package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;

import com.connection.ConnectionBd;
import com.model.Category;
import com.model.Course;

public class CategoryDao extends CrudDao{
	
	public Category getCategory(Category category){
		super.initialize();
        
		Category result = manager.find(Category.class, category.getId());
		manager.close();
		return result;
		
	}
	
	public ArrayList<Category> listAll(){
		super.initialize();
    
        Query query = manager.createQuery("from Category");
        List results = query.getResultList();
		
        manager.close();
		return (ArrayList<Category>) results;
		
	}
}
