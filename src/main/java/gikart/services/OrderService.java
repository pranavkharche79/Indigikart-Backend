package gikart.services;

import java.util.List;

import gikart.entities.Customer;
import gikart.entities.Order;

public interface OrderService {

	Order saveOrder(Order order);
	List<Order> getAllOrders();
	List<Order> getCustomerOrders(Customer customer);
	Order findById(int id);
}
