package poc.domain.dao;

import java.io.Serializable;
import java.util.List;

import poc.domain.model.Order;

public interface OrderDao extends Serializable {
	Order getOrder(int orderNo);
	void addOrder(Order order);
	void updateOrder(Order order);
	void deleteOrder(int orderNo);
	List<Order> getOrders();
}
