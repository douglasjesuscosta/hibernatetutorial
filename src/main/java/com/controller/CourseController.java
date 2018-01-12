package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.CourseDao;
import com.dao.HeroDao;
import com.model.Course;
import com.model.Model;

public class CourseController extends CrudController{
	
	@Override
	public Model getTableObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listAllModel() {
		CourseDao courseDao = new CourseDao();
		ArrayList<Course> courseList = courseDao.listAll();
		return courseList;
	}

	@Override
	public Model getModel(Model model) {
		CourseDao courseDao = new CourseDao();
		Course course = courseDao.getCourse((Course) model);
		return course;
	}

}
