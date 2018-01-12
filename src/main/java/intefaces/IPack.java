package intefaces;

import java.util.HashMap;
import java.util.List;

import com.enums.Actions;
import com.util.Return;

import com.model.Model;

public interface IPack {
	
	public void setAction(Actions action);
	public Actions getAction();
	
	public void setModelObject(Model model);
	public Model getModelObject();
	
	public void setReturn(Return a_return);
	public Return getReturn();
	
	public void setListModel(List<Model> listModel);
	public List<Model> getListModel();
	
	public void setSearchParamethers(HashMap<String, Object> searchParamethers);
	public HashMap<String, Object> getSearchParamethers();
		
}
