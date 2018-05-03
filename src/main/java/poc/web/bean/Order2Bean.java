package poc.web.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("order")
@Scope("view")
public class Order2Bean implements Serializable{
    private static final long serialVersionUID = 1L;
    transient int i;
    transient int nbOrder;
    String orderNo;
    String productName;
    BigDecimal price;
    int qty;
    boolean editable = false;
    private static final ArrayList<Order> orderList = new ArrayList<Order>();
 
    public ArrayList<Order> getOrderList() {
 
        return orderList;
 
    }
 
    public final int getNbOrder() {
        nbOrder = orderList.size();
        return nbOrder;
    }
 
    public String getOrderNo() {
        return orderNo;
    }
 
    public void setOrderNo(final String orderNo) {
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
 
        //get all existing value but set "editable" to false 
        for (Order order : orderList) {
            order.setEditable(false);
        }
 
        //return to current page
        return null;
 
    }
 
    public String editAction(final Order order) {
 
        order.setEditable(true);
        return null;
    }
 
    public String addAction() {
 
        final Order order = new Order(this.orderNo, this.productName, this.price, this.qty);
        orderList.add(order);
        setEditable(false);
        setOrderNo(null);
        setProductName(null);
        setPrice(null);
        setQty(0);
        return null;
    }
 
    public String deleteAction(final Order order) {
 
        orderList.remove(order);
        return null;
    }
 
    public static class Order {
 
        String orderNo;
        String productName;
        BigDecimal price;
        int qty;
        boolean editable;
 
        public Order(final String orderNo, final String productName, final BigDecimal price, final int qty) {
            this.orderNo = orderNo;
            this.productName = productName;
            this.price = price;
            this.qty = qty;
        }
 
        public boolean isEditable() {
            return editable;
        }
 
        public void setEditable(final boolean editable) {
            this.editable = editable;
        }
 
        public String getOrderNo() {
            return orderNo;
        }
 
        public void setOrderNo(final String orderNo) {
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
    }
}
