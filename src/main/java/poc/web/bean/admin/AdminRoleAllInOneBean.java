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
import poc.domain.model.AdminRole;

@Controller
@Scope("view")
public class AdminRoleAllInOneBean extends AbstractAllInOneBean<AdminRole> implements Serializable{
	private static final long serialVersionUID = 1L;

	private static List<String> componentIds;

	@Autowired
	private transient AdminRoleMapper adminRoleMapper;

	@PostConstruct
	public void init() {
		this.setViewModel(new AdminRole());
		this.setList(adminRoleMapper.selectAll());
		if (componentIds==null)
		{
			String[] aComponentIds={"id","name","description","sortOrder"};
			componentIds = new ArrayList<String>(Arrays.asList(aComponentIds));
		}
	}

	public String saveAction() {

		try {
			adminRoleMapper.updateByPrimaryKey(this.getViewModel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

		try {
			adminRoleMapper.insert(this.getViewModel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "list";
	}

	@Override
	protected List<String> getComponentIds() {
		return componentIds;
	}

	public String deleteAction(final AdminRole role) {

		try {
			adminRoleMapper.deleteByPrimaryKey(role.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "list";
	}
	

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
	{
		this.rewire(ois);
	}

}
