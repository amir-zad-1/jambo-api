package edu.ordering.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import edu.ordering.models.Order;
import edu.ordering.models.OrderItem;
import edu.ordering.models.OrderStatus;
import edu.ordering.models.Product;
import edu.ordering.repositories.OrderItemRepository;

public class OrderItemService {

	@Autowired
    @Qualifier("orderItemRepository")
    private OrderItemRepository orderItemRepository;
	public OrderItemService() {
		// TODO Auto-generated constructor stub
	}

    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    public void deleteAll() {
        orderItemRepository.deleteAll();
    }

    public OrderItem addOrder(OrderItem orderItem) {
        if (orderItem.isValid()) {
            this.orderItemRepository.save(orderItem);
            return orderItem;
        } else {
            return null;
        }
    }

    public boolean delete(long orderItemId) {
        OrderItem orderItem = this.orderItemRepository.getOne(orderItemId);
        if (orderItem != null) {
            this.orderItemRepository.delete(orderItem);
            return true;
        } else {
            return false;
        }
    }


    public OrderItem getOrderItemById(long orderItemId) {
        return this.orderItemRepository.findOne(orderItemId);
    }

}
