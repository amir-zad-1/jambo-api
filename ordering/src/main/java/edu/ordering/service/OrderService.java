package edu.ordering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.ordering.repositories.OrderRepository;
import edu.ordering.models.*;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderService {

    @Autowired
    @Qualifier("orderRepository")
    private OrderRepository orderRepository;

    public OrderService() {
        // TODO Auto-generated constructor stub
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

    public Order addOrder(Order order) {
        if (this.isValid(order)) {
            this.orderRepository.save(order);
            return order;
        } else {
            return null;
        }
    }

    public Order addProduct(Order order, Product product) {
        if (this.isValid(order) && Product.isValid(product)) {
            order.addProduct(product);
            return order;
        } else {
            return null;
        }
    }

    public Order createOrder(Order order){
        for (OrderItem oi:order.getOrderItems()) {
            oi.setOrder(order);
        }
        
        orderRepository.save(order);
        return order;
    }

    public boolean delete(Long orderId) {
        Order order = this.orderRepository.getOne(orderId);
        if (order != null) {
            this.orderRepository.delete(order);
            return true;
        } else {
            return false;
        }
    }

    public Order getOrderById(long orderId) {
        return this.orderRepository.findOne(orderId);
    }

    private boolean isValid(Order order) {
        return order.getId() > 0;
    }
}
