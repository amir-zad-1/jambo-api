package edu.ordering.service;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


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

    public Order createOrder(Order order) {
        float tot = 0;
        for (OrderItem oi : order.getOrderItems()) {
            oi.setOrder(order);
            tot += oi.getPrice()*oi.getQuantity();
        }
        order.setTotal(tot);
        order.setStatus(OrderStatus.CREATED);
        order.setDate(new Date());

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

    public Order cancelOrder(Order o) {
        o.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(o);
        return o;
    }

    public Order getOrderById(long orderId) {
        return this.orderRepository.findOne(orderId);
    }

    private boolean isValid(Order order) {
        return order.getId() > 0;
    }
}
