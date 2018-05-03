package poc.web.bean.admin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import poc.domain.dao.AdminRoleMapper;
import poc.domain.dao.AdminSystemCategoryMapper;
import poc.domain.model.AdminRole;
import poc.domain.model.AdminSystem;
import poc.domain.model.AdminSystemCategory;
import poc.service.GenericService;

@Controller
@Scope("view")
public class AdminSystemCategoryAllInOneBean extends AbstractAllInOneBean<AdminSystemCategory> implements Serializable{
	private static final long serialVersionUID = 1L;

	private static List<String> componentIds;

//	@Autowired
//	private transient AdminSystemCategoryMapper adminSystemCategoryMapper;

	@Autowired
	private transient GenericService<AdminSystemCategory,Long> adminSystemCategoryService;

	@PostConstruct
	public void init() {
		this.setViewModel(new AdminSystemCategory());
		this.setList(adminSystemCategoryService.selectAll());
		if (componentIds==null)
		{
			String[] aComponentIds={"id","name","description","sortOrder"};
			componentIds = new ArrayList<String>(Arrays.asList(aComponentIds));
		}
	}

	public String saveAction() {

		adminSystemCategoryService.updateByPrimaryKey(this.getViewModel());
		
		return "list";

	}

//	public String editAction(final AdminRole role) {
//
//		//TODO: this can be rewrite with ajax call
//		this.setEditable(true);
//		UIViewRoot viewRoot= FacesContext.getCurrentInstance().getViewRoot();
//		List<UIComponent> coms = viewRoot.getChildren();
//
//		((UIInput)findComponent(viewRoot, "id")).setSubmittedValue(null);
//		((UIInput)findComponent(viewRoot,"name")).setSubmittedValue(null);
//		((UIInput)findComponent(viewRoot,"description")).setSubmittedValue(null);
//		((UIInput)findComponent(viewRoot,"sortOrder")).setSubmittedValue(null);
//		
//		
//		this.setViewModel(role);
//		
//		return null;
//	}

	public String addAction() {

		adminSystemCategoryService.insert(this.getViewModel());
		
		return "list";
	}

	@Override
	protected List<String> getComponentIds() {
		return componentIds;
	}

	public String deleteAction(final AdminSystemCategory o) {

		adminSystemCategoryService.deleteByPrimaryKey(o.getId());
		
		return "list";
	}
	

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
	{
		this.rewire(ois);
	}

}
