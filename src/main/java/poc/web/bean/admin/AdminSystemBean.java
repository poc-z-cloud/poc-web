package poc.web.bean.admin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import poc.domain.model.AdminRole;
import poc.domain.model.AdminSystem;
import poc.domain.model.AdminSystemCategory;
import poc.service.AuthorizationService;
import poc.service.GenericService;
import poc.web.PickListConverter;

@Controller
@Scope("view")
public class AdminSystemBean extends AbstractListDialogBean<AdminSystem>  {
	private static final long serialVersionUID = -332099255973362487L;

	@Autowired
	private transient GenericService<AdminSystem,Long> adminSystemService;

	@Autowired
	private transient GenericService<AdminSystemCategory,Long> adminSystemCategoryService;
	
	@Autowired
	private transient AuthorizationService authorizationService;

	private List<AdminSystemCategory> categoryList;
	
	private DualListModel<AdminRole> dualListRoles;
	
	private PickListConverter pickListConverter = new PickListConverter();

	@PostConstruct
	public void init() {
		this.setViewModel(new AdminSystem());
		this.setViewModelSample(new AdminSystem());
		this.setList(retrieveList());
		
		this.categoryList= adminSystemCategoryService.selectAll();
		//loadRoles();
	}
	
	
	@Override
	protected GenericService<AdminSystem,Long> getService() {
		return adminSystemService;
	}

	@Override
	protected AdminSystem newViewModel() {
		return new AdminSystem();
	}

	public void onGrantRoles()
	{
		System.out.println("onGrantRoles...");
		//Long systemId=this.getViewModel().getId();

		List<AdminRole> rolsTarget = dualListRoles.getTarget();
		
		authorizationService.updateSystemRole(this.getViewModel(), rolsTarget);
	}
	
	public void loadRoles()
	{
		
		System.out.println("loadRoles...");		
//		List<AdminRole> rolesSource = new ArrayList<AdminRole>();
//		AdminRole role = new AdminRole();
//		role.setId(1L);
//		role.setName("Admin");
//		rolesSource.add(role);
//
//		role = new AdminRole();
//		role.setId(2L);
//		role.setName("Tester");
//		rolesSource.add(role);
//		
//        List<AdminRole> rolsTarget = new ArrayList<AdminRole>();
//        
//        role = new AdminRole();
//		role.setId(3L);
//		role.setName("Profile");
//		rolsTarget.add(role);
//
//		role = new AdminRole();
//		role.setId(4L);
//		role.setName("POC");
//		rolsTarget.add(role);
         
		Long systemId=this.getViewModel().getId();
		List<AdminRole> rolesSource =authorizationService.retrieveAvailableRolesBySystemId(systemId);
        List<AdminRole> rolsTarget = authorizationService.retrieveGrantedRolesBySystemId(systemId);

		dualListRoles =  new DualListModel<AdminRole>(rolesSource, rolsTarget);
	}
	
	private void readObject(ObjectInputStream ois)
			throws ClassNotFoundException, IOException {
		this.rewire(ois);
	}


	public List<AdminSystemCategory> getCategoryList() {
		if (categoryList==null) categoryList= new ArrayList<AdminSystemCategory>();
		return categoryList;
	}


	public void setCategoryList(List<AdminSystemCategory> categoryList) {
		this.categoryList = categoryList;
	}
	
	
	
	public DualListModel<AdminRole> getDualListRoles() {
		if (dualListRoles==null) dualListRoles= new DualListModel<AdminRole>();
		return dualListRoles;
	}


	public void setDualListRoles(DualListModel<AdminRole> dualListRoles) {
		this.dualListRoles = dualListRoles;
	}


	public PickListConverter getPickListConverter() {
		return pickListConverter;
	}


	public void setPickListConverter(PickListConverter pickListConverter) {
		this.pickListConverter = pickListConverter;
	}


	
	
}
