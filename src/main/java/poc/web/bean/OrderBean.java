package poc.web.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;



//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import poc.domain.dao.OrderDao;
import poc.domain.model.Order;
import poc.spring.SpringApplicationContext;

@Controller
@Scope("view")
public class OrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	transient int i;
	transient int nbOrder;
	private int orderNo;
	private String productName;
	private BigDecimal price;
	private int qty;
	private boolean editable = false;
	private List<Order> orderList = new ArrayList<Order>();

// the mapper is not serializable, so it cannot be autowired in view scope	
//	@Autowired
//	private OrderMapper orderMapper;
	

	@PostConstruct
	public void init() {
		System.out.println("Init method after properties are set : ");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		System.out.println("facesContext: " + facesContext);
		System.out.println("facesContext.isPostback() in init(): "
				+ facesContext.isPostback());
//		if (!facesContext.isPostback()) {
//			orderList = orderMapper.getOrders();
//			System.out.println("orderList.size(): " + orderList.size());
//		}
//		if (orderList == null)
//			orderList = new ArrayList<Order>();

		orderList = getOrderMapper().getOrders();
	}

	private OrderDao getOrderMapper()
	{
		return SpringApplicationContext.getApplicationContext().getBean("orderDao",OrderDao.class);
	}
	public ArrayList<Order> getOrderList() {

		return (ArrayList<Order>) orderList;

	}

	public final int getNbOrder() {
		nbOrder = orderList.size();
		return nbOrder;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(final int orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(final String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(final int qty) {
		this.qty = qty;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(final boolean editable) {
		this.editable = editable;
	}

	public String saveAction() {

		final Order order = new Order(this.orderNo, this.productName,
				this.price, this.qty);
		
		getOrderMapper().updateOrder(order);
		
//		orderList = getOrderMapper().getOrders();

		// return to current page
		return "list";

	}

	public String editAction(final Order order) {

		this.setEditable(true);
		UIViewRoot viewRoot= FacesContext.getCurrentInstance().getViewRoot();
		List<UIComponent> coms = viewRoot.getChildren();

		UIComponent input=findComponent(viewRoot, "orderNo");
		
		
		((UIInput)findComponent(viewRoot, "orderNo")).setSubmittedValue(null);
		((UIInput)findComponent(viewRoot,"productName")).setSubmittedValue(null);
		((UIInput)findComponent(viewRoot,"price")).setSubmittedValue(null);
		((UIInput)findComponent(viewRoot,"qty")).setSubmittedValue(null);
		
		
		this.orderNo=order.getOrderNo();
		this.productName=order.getProductName();
		this.price=order.getPrice();
		this.qty=order.getQty();
		
//		this.setOrderNo(order.getOrderNo());
//		this.setProductName(order.getProductName());
//		this.setPrice(order.getPrice());
//		this.setQty(order.getQty());
		
		return null;
	}

	public String addAction() {

		final Order order = new Order(this.orderNo, this.productName,
				this.price, this.qty);
//		orderList.add(order);
		
		getOrderMapper().addOrder(order);
		
//		orderList = getOrderMapper().getOrders();
//		setEditable(false);
//		// setOrderNo(null);
//		setProductName(null);
//		setPrice(null);
//		setQty(0);
		return "list";
	}

	public String deleteAction(final Order order) {

		getOrderMapper().deleteOrder(order.getOrderNo());
		
		orderList = getOrderMapper().getOrders();
		
//		orderList.remove(order);
		return "list";
	}
	
	/**
	   * Finds component with the given id
	   */
	  private UIComponent findComponent(UIComponent c, String id) {
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

}
