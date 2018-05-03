package poc.web.bean.admin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.web.context.support.WebApplicationContextUtils;

import poc.domain.dao.BaseMapper;
import poc.domain.model.AdminSystem;
import poc.domain.model.BaseModel;
import poc.domain.model.Car;
import poc.service.GenericService;

public abstract class AbstractListDialogBean<T extends BaseModel> implements Serializable{

	private T viewModel;

	private List<T> list;

	private T viewModelSample; //for setting filter

	private List<T> selectedList; //for multiple selections
	
	public AbstractListDialogBean() {
		super();
	}
	
	protected List<T> retrieveList()
	{
		return getService().selectAll();
	}

	
    public void onOK() {
    	
    	if (this.getViewModel().getId()==null)
    	{
			this.getService().insertSelective(this.getViewModel());
    	}
    	else
    	{
    		this.getService().updateByPrimaryKey(this.getViewModel());
    	}
    	
    	//refresh lsit
    	this.setList(retrieveList());
    	
    }    	
    
    public void onDelete() {
        for(T t:this.getSelectedList())
        {
			this.getService().deleteByPrimaryKey(t.getId());
        }
        
    	//refresh lsit
    	this.setList(retrieveList());
    }    

    public void onAdd() {
    	this.setViewModel(newViewModel());
    }
    
//	protected abstract BaseMapper getMapper();
	protected abstract GenericService<T,Long> getService();
//	protected abstract List<T> retrieveList();
	protected abstract T newViewModel();
	
    
    
    public void onSetFilter() {
    	//this.setViewModel(new AdminSystem());
    }    

    public void onFilter() {
    	//this.setViewModel(new AdminSystem());
    }    
    
	
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Item Selected", ((T) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((T) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }	
	

	public T getViewModel() {
		return viewModel;
	}

	public void setViewModel(T viewModel) {
		this.viewModel = viewModel;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getViewModelSample() {
		return viewModelSample;
	}

	public void setViewModelSample(T viewModelSample) {
		this.viewModelSample = viewModelSample;
	}
	
	public List<T> getSelectedList() {
		return selectedList;
	}


	public void setSelectedList(List<T> selectedList) {
		this.selectedList = selectedList;
	}


	protected void rewire(ObjectInputStream ois)
            throws ClassNotFoundException, IOException {
		ServletContext servletContext = null;
        ois.defaultReadObject();
        servletContext = (ServletContext) FacesContext
                     .getCurrentInstance().getExternalContext().getContext();
        WebApplicationContextUtils
                     .getRequiredWebApplicationContext(servletContext)
                     .getAutowireCapableBeanFactory().autowireBean(this);
    }

}