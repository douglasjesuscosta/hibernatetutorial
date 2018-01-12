package com.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.communication.Pack;
import com.dao.CrudDao;
import com.dao.GenericDao;
import com.enums.Actions;
import intefaces.IModel;
import intefaces.IPack;
import com.model.Model;
import com.util.Return;

public abstract class CrudController{
		
		private HashMap<String, String> variables;
		private String action; 
		private Model filledObject;
		protected CrudDao crudDao;
		
		
		public Pack executeAction(Pack pack){
			Return retorno = new Return();
			try{
				if(pack.getAction() == Actions.INSERT){
					retorno = executeActionInsertUpdate(pack.getModelObject());
				}else if(pack.getAction() == Actions.DELETE){
					retorno = executeActionDelete(pack.getModelObject());
				}
			}catch (Exception e) {
				retorno.setFracasso();
				retorno.addMensagem("Erro: " + e.getMessage());
			}
			
			pack.setReturn(retorno);
			return pack;
		}
		
		public Return executeActionInsertUpdate(Model model){
			Return retorno = new Return();
			CrudDao dao = new CrudDao();
			try{
				if(model != null){
					if(model.getId() == null){
						dao.insert(model);
					}else{
						dao.update(model);
					}
				}
			}catch(Exception e){
				retorno.setFracasso();
				retorno.addMensagem(e.getMessage());
			}
			return retorno;
		}
		
		public Return executeActionDelete(Model object) throws SQLException, ClassNotFoundException{
			Return retorno = new Return();
			CrudDao crudDao = new CrudDao();
			if(!(object == null)){
				crudDao.delete(object);
				retorno.setSucesso();
			}else{
				retorno.setFracasso();
				retorno.addMensagem("ERRO NO PREENCHIMENTO DO OBJETO");
			}
			return retorno;
		}
		
		public abstract Model getModel(Model model);
//		public Pack executeActionSelect(Pack pack){
//			Return retorno = new Return();
//			Model object = pack.getModelObject();
//			HashMap searchParamethers = pack.getSearchParamethers();
//			List<Model> listModel = pack.getListModel();
//			
//			try {
//				if(searchParamethers == null){
//					listModel = this.listAllModel();
//					retorno.setSucesso();
//				}else{
//					listModel = GenericDao.getGenericDao().search(searchParamethers, object);
//				}
//			} catch (Exception e) {
//				retorno.setFracasso();
//				retorno.addMensagem("<EXECUTEACTIONSELET> Erro ao buscar lista da entidade: "+ e.getMessage());
//			}
//			pack.setReturn(retorno);
//			pack.setListModel(listModel);
//			return pack;
//		}
//
//		public void setAction(String action){
//			this.action = action;
//		}
		
//		public Return executeActionInsert(){
//			
//				Return retorno = new Return();
//			try{
//				CrudDao crudDao = new CrudDao();
//				
//				if(filledObject != null){
//					if(filledObject.getId() == null){
//						crudDao.insert(filledObject);
//						retorno.setSucesso();
//					}else{
//						crudDao.update(filledObject);
//						retorno.setSucesso();
//					}
//				}
//			}catch(Exception e){
//				retorno.setFracasso();
//				retorno.addMensagem(e.getMessage());
//			}
//			return retorno;
//		}
		
//		public Return executeActionDelete() throws SQLException, ClassNotFoundException{
//			Return retorno = new Return();
//			CrudDao crudDao = new CrudDao();
//			if(!(filledObject == null)){
//				crudDao.delete(filledObject);
//			}else{
//				retorno.setFracasso();
//				retorno.addMensagem("ERRO NO PREENCHIMENTO DO OBJETO");
//			}
//			return retorno;
//		}
		
		public void setVariables(HashMap<String, String> variables){
			this.variables = variables;
		}
		
		public abstract Model getTableObject();
		
		public void setCompleteObject(Model filledObject){
			this.filledObject = filledObject;
		}
		
		public abstract List listAllModel();
}
