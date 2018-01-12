package com.communication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import com.enums.Actions;
import intefaces.IModel;
import intefaces.IPack;
import com.model.Model;
import com.util.Return;

public class Pack implements IPack{
	
	private Actions action;
	private Model model;
	private Return a_return;
	private HashMap<String, Object> searchParamethers;
	private List<Model> listModel;

	public Pack(Actions action, Model model, Return returno){
		setAction(action);
		setModelObject(model);
		setReturn(returno);
	}
	
	public Pack(){
		
	}
	
	public void setAction(Actions action) {
		this.action = action;
	}

	
	public Actions getAction() {
		return action;
	}

	
	public void setModelObject(Model model) {
		this.model = model;

	}

	
	public Model getModelObject() {
		return model;
	}

	
	public void setReturn(Return a_return) {
		this.a_return = a_return;

	}

	
	public Return getReturn() {
		return a_return;
	}

	public List<Model> getListModel() {
		return listModel;
	}

	public void setListModel(List<Model> listModel) {
		this.listModel = listModel;
	}

	public HashMap<String, Object> getSearchParamethers() {
		return searchParamethers;
	}

	public void setSearchParamethers(HashMap<String, Object> searchParamethers) {
		this.searchParamethers = searchParamethers;
	}
	
	

}
