package poc.web.bean.admin;

import java.io.IOException;
import java.io.ObjectInputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import poc.domain.model.AdminRole;
import poc.service.GenericService;

@Controller
@Scope("view")
public class AdminRoleBean extends AbstractListDialogBean<AdminRole>  {
	private static final long serialVersionUID = -5048562065358241306L;

	@Autowired
	private transient GenericService<AdminRole,Long> adminRoleService;

	@PostConstruct
	public void init() {
		this.setViewModel(new AdminRole());
		this.setViewModelSample(new AdminRole());
		this.setList(retrieveList());
		
	}
	
	
	@Override
	protected GenericService<AdminRole,Long> getService() {
		return adminRoleService;
	}

	@Override
	protected AdminRole newViewModel() {
		return new AdminRole();
	}

	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		this.rewire(ois);
	}
	
	

}
