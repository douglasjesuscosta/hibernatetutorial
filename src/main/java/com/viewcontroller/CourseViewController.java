package com.viewcontroller;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.controller.HeroController;
import com.model.Course;
import com.model.Hero;
import com.controller.CourseController;


@javax.inject.Singleton
@Path("Course")
public class CourseViewController {
	
	@PUT
	@Consumes({ "application/xml", "application/json" })
	public Response edit(Course entity) {
		CourseController controller = new CourseController();
		controller.executeActionInsertUpdate(entity);
		return null;
	}
	
	@POST
	@Consumes({ "application/xml", "application/json" })
	public Response save(Course course) {
		CourseController controller = new CourseController();
		controller.executeActionInsertUpdate(course);
		return null;
	}
	
	
	@GET
	@Produces({ "application/json" })
	public List<Course> findAll() {
		CourseController courseController = new CourseController();
		
		return courseController.listAllModel();
		
	}
	
	@DELETE
	@Path("remove/{id}")
	public Response remove(@PathParam("id") Integer id) {
		CourseController courseController = new CourseController();
		
		Course course = new Course();
		course.setId((long) id);
		ResponseBuilder response;
		
		
		try {
			courseController.executeActionDelete(course);
			response = Response.ok(course);
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.serverError();
		}
		return response.build();
	
	}
}
