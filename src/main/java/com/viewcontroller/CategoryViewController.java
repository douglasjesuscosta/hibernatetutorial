package com.viewcontroller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.controller.CategoryController;
import com.model.Category;

@javax.inject.Singleton
@Path("Category")
public class CategoryViewController {
	
	
	@GET
	@Produces({ "application/json" })
	public List<Category> getCateegories() {
		
		CategoryController controller = new CategoryController();
		List<Category> categories = controller.listAllModel();
		
		return categories;
	}

}
