package poc.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order   implements Serializable{
	private static final long serialVersionUID = -6066784244953455024L;

	int orderNo;
    String productName;
    BigDecimal price;
    int qty;
    boolean editable;

    public Order(){
    	
    }
    public Order(final int orderNo, final String productName, final BigDecimal price, final int qty) {
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
}
