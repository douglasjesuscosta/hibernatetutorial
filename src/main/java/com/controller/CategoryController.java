package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.CategoryDao;
import com.dao.HeroDao;
import com.model.Category;
import com.model.Hero;
import com.model.Model;

public class CategoryController extends CrudController{
	@Override
	public Model getTableObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listAllModel() {
		CategoryDao categoryDao = new CategoryDao();
		ArrayList<Category> categoryList = categoryDao.listAll();
		return categoryList;
	}

	@Override
	public Model getModel(Model model) {
		CategoryDao categoryDao = new CategoryDao();
		Category category = categoryDao.getCategory((Category) model);
		return category;
	}
}
