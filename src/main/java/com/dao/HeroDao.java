package com.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.ConnectionBd;
import com.model.Hero;
import com.model.Model;

public class HeroDao extends CrudDao{
	
	public HeroDao () {}
	
	
	public Hero getHero(Hero hero){
		super.initialize();
        
        String sql = "SELECT * FROM hero Where id = :hero_id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Hero.class);
        query.setParameter("hero_id", hero.getId());
        ArrayList<Hero> results = (ArrayList<Hero>) query.list();
		
		return results.get(0);
		
	}
	
	public ArrayList<Hero> listAll(){
		super.initialize();
        
        String sql = "SELECT * FROM hero";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Hero.class);
        List results = query.list();
		
		return (ArrayList<Hero>) results;
		
	}

}
