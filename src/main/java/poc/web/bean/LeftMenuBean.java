package poc.web.bean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import poc.domain.aggregate.AdminSystemCategoryAggregate;
import poc.domain.dao.AdminSystemCategoryMapper;
import poc.domain.model.AdminSystemCategory;

@Controller
@Scope("session")
public class LeftMenuBean implements Serializable{
	
//    private MenuModel model;
    
    private List<SubMenuModel> model;
    
	@Autowired
	private transient AdminSystemCategoryMapper adminSystemCategoryMapper;
	
	private List<AdminSystemCategoryAggregate> systemCategoryList;

	public LeftMenuBean() {
		

        
    }
 
//    public MenuModel getModel() {
//        return model;
//    }	
    
	@PostConstruct
	public void init() {
		systemCategoryList = adminSystemCategoryMapper.selectAllWithSystems();
		
		for(AdminSystemCategoryAggregate category:systemCategoryList)
		{
			category.getSystems();
		}
		
    	model = new ArrayList<SubMenuModel>();
    	
    	SubMenuModel subMenu = new SubMenuModel();
    	subMenu.setLabel("Home");
    	
    	MenuItemModel menuItem = new MenuItemModel();
    	menuItem.setId("welcome");
    	menuItem.setLabel("Goto Welcome");
    	menuItem.setUrl("/poc/welcome.xhtml?faces-redirect=true");
    	menuItem.setIcon("ui-icon-home");
    	
    	subMenu.addMenuitem(menuItem);

    	model.add(subMenu);

    	subMenu = new SubMenuModel();
    	subMenu.setLabel("Steps");
    	
    	menuItem = new MenuItemModel();
    	menuItem.setId("step1");
    	menuItem.setLabel("Goto Step1");
    	menuItem.setUrl("/poc/step1.xhtml?faces-redirect=true");
    	menuItem.setIcon("ui-icon-disk");
    	subMenu.addMenuitem(menuItem);
    	
    	menuItem = new MenuItemModel();
    	menuItem.setId("step2");
    	menuItem.setLabel("Goto Step2");
    	menuItem.setUrl("/poc/step2.xhtml?faces-redirect=true");
    	menuItem.setIcon("ui-icon-close");

    	subMenu.addMenuitem(menuItem);
    	
    	menuItem = new MenuItemModel();
    	menuItem.setId("dataTable");
    	menuItem.setLabel("Goto DataTable");
    	menuItem.setUrl("/poc/paginator.xhtml?faces-redirect=true");
    	menuItem.setIcon("ui-icon-close");

    	subMenu.addMenuitem(menuItem);
    	model.add(subMenu);
    	
    	subMenu = new SubMenuModel();
    	subMenu.setLabel("POC");
    	
    	menuItem = new MenuItemModel();
    	menuItem.setId("allinone");
    	menuItem.setLabel("All In One");
    	menuItem.setUrl("/poc/allinone.xhtml?faces-redirect=true");
    	menuItem.setIcon("ui-icon-search");
    	subMenu.addMenuitem(menuItem);
    	
    	menuItem = new MenuItemModel();
    	menuItem.setId("adminRole");
    	menuItem.setLabel("Role All In One");
    	menuItem.setUrl("/poc/adminRoleAIO.xhtml?faces-redirect=true");
    	menuItem.setIcon("ui-icon-search");
    	subMenu.addMenuitem(menuItem);

    	menuItem = new MenuItemModel();
    	menuItem.setId("adminSystemCategory");
    	menuItem.setLabel("System Category");
    	menuItem.setUrl("/poc/adminSystemCategoryAIO.xhtml?faces-redirect=true");
    	menuItem.setIcon("ui-icon-search");
    	subMenu.addMenuitem(menuItem);

    	menuItem = new MenuItemModel();
    	menuItem.setId("adminSystem");
    	menuItem.setLabel("System");
    	menuItem.setUrl("/admin/adminSystem.xhtml?faces-redirect=true");
    	menuItem.setIcon("ui-icon-search");
    	subMenu.addMenuitem(menuItem);

    	
    	model.add(subMenu);
    	
//        model = new DefaultMenuModel();
// 
//        //First submenu
//        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
// 
//        DefaultMenuItem item = new DefaultMenuItem("External");
//        item.setUrl("http://www.primefaces.org");
//        item.setIcon("ui-icon-home");
//        firstSubmenu.addElement(item);
// 
//        model.addElement(firstSubmenu);
// 
//        //Second submenu
//        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
// 
//        item = new DefaultMenuItem("Save");
//        item.setIcon("ui-icon-disk");
////        item.setCommand("#{leftMenuBean.save}");
////        item.setCommand("#{leftMenuBean.action('save','save')}");
//        item.setUpdate("messages");
//        secondSubmenu.addElement(item);
// 
//        item = new DefaultMenuItem("Delete");
//        item.setIcon("ui-icon-close");
////        item.setCommand("#{leftMenuBean.delete}");
////        item.setCommand("#{leftMenuBean.action('delete','delete')}");
////        item.setStyle("#{leftMenuBean.getMenuItemCss('delete')}");
//        
//        item.setAjax(false);
//        secondSubmenu.addElement(item);
// 
//        item = new DefaultMenuItem("Step1");
//        item.setIcon("ui-icon-search");
//        item.setUrl("/poc/step1.xhtml?faces-redirect=true");
////        item.setCommand("#{leftMenuBean.redirect}");
////        item.setCommand("#{leftMenuBean.redirect('step1',''/poc/step1.xhtml?faces-redirect=true')}");
////        item.setStyle("#{leftMenuBean.getMenuItemCss('step1')}");
//        
//        item.setAjax(false);
//        secondSubmenu.addElement(item);
// 
//        item = new DefaultMenuItem("Step2");
//        item.setIcon("ui-icon-search");
//        item.setUrl("/poc/step2.xhtml?faces-redirect=true");
////        item.setCommand("#{leftMenuBean.redirect}");
////        item.setCommand("#{leftMenuBean.redirect('step2',''/poc/step2.xhtml?faces-redirect=true')}");
////        item.setStyle("#{leftMenuBean.getMenuItemCss('step2')}");
//        item.setAjax(false);
//        secondSubmenu.addElement(item);
//
//        model.addElement(secondSubmenu);
    	}
    

    public void save() {
        addMessage("Save Success", "Data saved");
    }
     
	public List<SubMenuModel> getModel() {
		return model;
	}

	public void setModel(List<SubMenuModel> model) {
		this.model = model;
	}

	public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Delete Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private String selectedMenuItem = "";

    public String getMenuItemCss(String id) {
       if (id.equalsIgnoreCase(selectedMenuItem)) {
          return "font-weight: bold;background-color:green;";
       }
       return "";
    }

    public void action(String id, String command) {
        selectedMenuItem = id;
        if ("save".equals(command))
        {
        	save();
        }
        else if ("delete".equals(command))
        {
        	delete();
        }
     }    

    public String redirect(String id, String url) {
       selectedMenuItem = id;
       return url;
    }   
    
    
    
    public List<AdminSystemCategoryAggregate> getSystemCategoryList() {
		return systemCategoryList;
	}

	public void setSystemCategoryList(
			List<AdminSystemCategoryAggregate> systemCategoryList) {
		this.systemCategoryList = systemCategoryList;
	}



	public static class SubMenuModel implements Serializable
    {
    	private String label;
    	private List<MenuItemModel> menuitems= new ArrayList<MenuItemModel>();
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public List<MenuItemModel> getMenuitems() {
			return menuitems;
		}
		public void setMenuitems(List<MenuItemModel> menuitems) {
			this.menuitems = menuitems;
		}
		public void addMenuitem(MenuItemModel menuitem) {
			this.menuitems.add(menuitem);
		}
    	
    	
    }
    
    public static class MenuItemModel implements Serializable
    {
    	private String id;
    	private String url;
    	private String icon;
    	private String label;
    	
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
    	
    	
    	
    }
}
