package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;

import com.connection.ConnectionBd;
import com.model.Course;



public class CourseDao extends CrudDao {
//	public Course getCourse(Course course){
//		super.initialize();
//        
//        String sql = "SELECT * FROM course Where id = :course_id";
//        SQLQuery query = session.createSQLQuery(sql);
//        query.addEntity(Course.class);
//        query.setParameter("hero_id", course.getId());
//        ArrayList<Course> results = (ArrayList<Course>) query.list();
//		
//		return results.get(0);
//		
//	}
	public Course getCourse(Course course){
		super.initialize();
		Course result = manager.find(Course.class, course.getId());
		
		manager.close();
		return result;
		
	}
	
	
	public ArrayList<Course> listAll(){
		super.initialize();
        
		
		Query query = manager.createQuery("from Course");
		List<Course> results = query.getResultList();
		
		manager.close();
		return (ArrayList<Course>) results;
		
	}

}
