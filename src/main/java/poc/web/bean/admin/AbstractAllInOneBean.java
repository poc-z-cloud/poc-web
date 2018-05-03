package poc.web.bean.admin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

import poc.domain.model.AdminRole;

public abstract class AbstractAllInOneBean<T> implements Serializable{

	private boolean editable = false;
	private transient int numberOfRecords;

	
	// this viewModel can be domain model directly, aggregate of domain models or delegation of domain models 
	private T viewModel;

	private List<T> list;

	public AbstractAllInOneBean() {
		super();
	}

	
	public String editAction(final T t) {

		//TODO: this can be rewrite with ajax call
		this.setEditable(true);
		UIViewRoot viewRoot= FacesContext.getCurrentInstance().getViewRoot();
		List<UIComponent> coms = viewRoot.getChildren();

		for (String componentId: getComponentIds())
		{
			((UIInput)findComponent(viewRoot, componentId)).setSubmittedValue(null);
		}
//		((UIInput)findComponent(viewRoot, "id")).setSubmittedValue(null);
//		((UIInput)findComponent(viewRoot,"name")).setSubmittedValue(null);
//		((UIInput)findComponent(viewRoot,"description")).setSubmittedValue(null);
//		((UIInput)findComponent(viewRoot,"sortOrder")).setSubmittedValue(null);
		
		
		this.setViewModel(t);
		
		return null;
	}	
	//utilities
	
	protected abstract List<String> getComponentIds();


	/**
	 * Method used for Deserialization and autowire back DI service 
	 * @param ois
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
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
		
	
	/**
	 * Finds component with the given id
	 */
	protected UIComponent findComponent(UIComponent c, String id) {
		if (id.equals(c.getId())) {
			return c;
		}
		Iterator<UIComponent> kids = c.getFacetsAndChildren();
		while (kids.hasNext()) {
			UIComponent found = findComponent(kids.next(), id);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
	
	  
	
	//getters/setters
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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

	public int getNumberOfRecords() {
		return this.getList().size();
	}

	
}