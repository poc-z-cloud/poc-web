/**
 * ****************************************************************
 * OSAP Application System
 *
 * Created by Nyquist (zhuyo) 2011-02-24
 *
 * The source code for this program is owned by OSAP project in 
 * Ministry of Training, Colleges and Universities (MTCU) 
 * CSC I & IT Cluster (CSC)
 * Technology and Business Solutions.
 * (C) Copyright OSAP Application Copyright Office. 2011
 * ****************************************************************
 */
package poc.web;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class FlashScope implements Scope {

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Flash flash= FacesContext.getCurrentInstance().getExternalContext().getFlash();
		
		if(flash.containsKey(name)) {
			return flash.get(name);
		}else {
			Object object = objectFactory.getObject();
			flash.put(name, object);
			return object;
		}
	}

	@Override
	public Object remove(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().getFlash().remove(name);
	}


	@Override
	public String getConversationId() {
		return null;
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

}
