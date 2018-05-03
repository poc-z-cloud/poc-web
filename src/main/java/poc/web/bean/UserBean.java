package poc.web.bean;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import poc.domain.model.User;
import poc.service.UserService;

@Controller
@Scope("request")
public class UserBean {
	@Autowired private UserService service;
	
	private User user;

	
	
	public UserBean() {
    	System.out.println("Constructing UserBean");
	}

	@PostConstruct
	public void init() {
	  System.out.println("Init method after properties are set : ");
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    System.out.println("facesContext.isPostback() in init(): "+facesContext.isPostback());
	    if (!facesContext.isPostback())
	    {
	    	user = service.getUser(1);
	    }
  	if (user==null) user = new User();
	  
	} 
	
	
	public String onload()
	{
		System.out.println("******************calling onload()");
		return null;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
    	System.out.println("setUser");

		this.user = user;
	}
	  public String send()
	  {
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    System.out.println("facesContext.isPostback() in send: "+facesContext.isPostback());

	    System.out.println("user:" + user);
	    System.out.println("user.name:" + user.getUserName());

//	    ExtendedRenderKitService service = (ExtendedRenderKitService)
//	      Service.getRenderKitService(facesContext, ExtendedRenderKitService.class);
//	    service.addScript(facesContext, "alert('Script added by ExtendedRenderKitService')");

	    //do real logic
	    return ("success");
	  }
	
	  public String back()
	  {
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    System.out.println("facesContext.isPostback() in back: "+facesContext.isPostback());

	    System.out.println("user:" + user);
	    System.out.println("user.name:" + user.getUserName());


	    //do real logic
	    return ("back");
	  }


}
