package com.viewcontroller;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.controller.HeroController;
import com.model.Hero;

/**
 * @author vikas
 */
@javax.inject.Singleton
@Path("Hero")
public class HeroViewController{
	//private EntityManager em;
	public HeroViewController() {
		//super(Person.class);
	}	
	@PUT
	@Consumes({ "application/xml", "application/json" })
	public Response edit(Hero entity) {
		return null;
		
		
	}
	@DELETE
	@Path("remove/{id}")
	public Response remove(@PathParam("id") Integer id) {
		return null;
		
	}
	@GET
	@Path("{id}")
	@Produces({ "application/json" })
	public Hero find(@PathParam("id") int id) {
		HeroController heroController = new HeroController();
		Hero hero = new Hero();
		hero.setId((long) id); 
		
		return (Hero) heroController.getModel(hero);
		
	}

	@GET
	@Produces({ "application/json" })
	public List<Hero> findAll() {
		HeroController heroController = new HeroController();
		
		return heroController.listAllModel();
		
	}

//	@GET
//	@Path("{from}/{to}")
//	@Produces({ "application/xml", "application/json" })
//	public List<Person> findRange(@PathParam("from") Integer from,
//			@PathParam("to") Integer to) {
//				return null;
//		
//	}
//
//	@GET
//	@Path("count")
//	@Produces("text/plain")
//	public String countREST() {
//		return null;
//		
//	}

}