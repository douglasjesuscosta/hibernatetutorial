package com.hibernatetutorial;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.*;
import com.dao.CategoryDao;
import com.dao.CourseDao;
import com.dao.GenericDao;
import com.dao.HeroDao;
/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
//        HeroDao heroDao = new HeroDao();
//        
//        Hero hero = new Hero();
//        hero.setId((long) 10);
//        
//        Hero result = heroDao.getHero(hero);
//        System.out.println(result.getName());
        
        CategoryDao categoryDao = new CategoryDao();
        CourseDao courseDao = new CourseDao();
        
        Category category = new Category();
        category.setName("Development");
        categoryDao.insert(category);
        
        Category category1 = new Category();
        category1.setName("Art");
        categoryDao.insert(category1);
        
        Category category2 = new Category();
        category2.setName("Matemathics");
        categoryDao.insert(category2);
        
//        ArrayList<Category> categories = categoryDao.listAll();
//        
//        for(int i =0; i < categories.size(); i++) {
//        	System.out.println(categories.get(i).getName());
//        }
//        
        Course course = new Course();
        course.setCategory(category);
        course.setName("Curso de Java para burros como eu");
        course.setMoneyBack(true);
        courseDao.insert(course);
        
        Course course1 = new Course();
        course1.setName("Curso de Angular");
        course1.setCategory(category);
        course1.setMoneyBack(false);
        courseDao.insert(course1);
//        
//        Course course3 = new Course();
//        course3.setId((long) 2);
//        course3 = courseDao.getCourse(course3);
//        System.out.println(course3.getName());
//        System.out.println(course3.getCategory().getName());
//        course3.setName("Curso de Android");
//        courseDao.update(course3);
//        courseDao.delete(course3);
       
    }
}
