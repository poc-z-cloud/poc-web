package poc.web.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class SignInBean implements Serializable {

	public String signOut()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		if (session!=null)
		{
			session.invalidate();
		}
		
		return "/poc/welcome.xhtml?faces-redirect=true";
	}
}
