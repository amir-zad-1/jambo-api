package edu.ordering.service;

import java.util.List;
import java.util.ArrayList;
import edu.ordering.repository.OrderRepository;
import edu.ordering.models.*;
public class OrderService {
	private OrderRepository orderRepository;
	public OrderService() {
		// TODO Auto-generated constructor stub
	}
	public List<Order> getAll(){
		return orderRepository.findAll();
	}
	public void deleteAll() {
		orderRepository.deleteAll();
	}
	public Order addOrder(Order order) {
		if(this.isValid(order)) {
			this.orderRepository.save(order);
			return order;
		}else {
			return null;
		}
	}
	public Order addProduct(Order order,Product product) {
		if(this.isValid(order) && Product.isValid(product)) {
			order.addProduct(product);
			return order;
		}else {
			return null;
		}
	}
	public boolean delete(Long orderId) {
		Order order = this.orderRepository.getOne(orderId);
		if(order != null) {
			this.orderRepository.delete(order);
			return true;
		}else {
			return false;
		}
	}
	public Order getOrderById(long orderId) {
		return this.orderRepository.getOne(orderId);
	}
	private boolean isValid(Order order) {
		return order.getId() > 0;
	}
}
