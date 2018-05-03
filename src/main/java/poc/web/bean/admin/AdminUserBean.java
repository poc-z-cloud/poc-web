package poc.web.bean.admin;

import java.io.IOException;
import java.io.ObjectInputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import poc.domain.model.AdminUser;
import poc.service.GenericService;

@Controller
@Scope("view")
public class AdminUserBean extends AbstractListDialogBean<AdminUser>  {
	private static final long serialVersionUID = -5048562065358241306L;

	@Autowired
	private transient GenericService<AdminUser,Long> adminUserService;

	@PostConstruct
	public void init() {
		this.setViewModel(new AdminUser());
		this.setViewModelSample(new AdminUser());
		this.setList(retrieveList());
		
	}
	
	
	@Override
	protected GenericService<AdminUser,Long> getService() {
		return adminUserService;
	}

	@Override
	protected AdminUser newViewModel() {
		return new AdminUser();
	}

	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		this.rewire(ois);
	}
	
	

}
