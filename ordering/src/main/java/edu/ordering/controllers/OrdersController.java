package edu.ordering.controllers;

import edu.ordering.models.Order;
import edu.ordering.models.OrderItem;
import edu.ordering.models.Product;
import edu.ordering.service.OrderItemService;
import edu.ordering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;
    private OrderItemService orderItemService;
    @ResponseBody
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") long orderId) {
        Order o = orderService.getOrderById(orderId);
        return o;
    }


    @GetMapping("/")
    public List<Order> index() {
        return orderService.getAll();
    }

    @ResponseBody
    @PostMapping("/")
    public Order placeOrder( @RequestBody Order order) {
        return    this.orderService.createOrder(order);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, produces = {"application/json"})
    public Order addProductToOrder(@RequestBody long idOrder, long idProduct, long quantity, float price) {
        Product product = new Product(idProduct, quantity, price);
        Order order = this.orderService.getOrderById(idOrder);
        if (order != null) {
            this.orderService.addProduct(order, product);
        }
        return order;
    }

    @ResponseBody
    @GetMapping("/{orderId}/cancel")
    public Order cancelOrder(@PathVariable("orderId") long orderId) {

        Order o = orderService.getOrderById(orderId);
        return orderService.cancelOrder(o);
    }
    @ResponseBody
    @PostMapping("/addOrderItem")
    public Order addOrderItem(@RequestBody long orderId, long orderItemId, int quantity, double price) {
    	Order order = this.getOrder(orderId);
    	if(order  != null) {
    		OrderItem orderItem =  this.orderItemService.getOrderItemById(orderItemId);
    		if(orderItem != null) {
    			orderItem.setPrice(price);
    			orderItem.setQuantity(quantity);
    		}else {
    			orderItem = new OrderItem();
    			orderItem.setPrice(price);
    			orderItem.setId(orderItemId);
    			orderItem.setQuantity(quantity);
    		}
    		order.addOrderItem(orderItem);
    	}
    	return order;
    }
    @ResponseBody
    @PostMapping("/addItems")
    public Order addOrderItemList(@RequestBody long orderId,List<OrderItem> orderItems) {
    	Order order = this.getOrder(orderId);
    	if(order != null) {
    		order.setOrderItems(orderItems);
    	}
    	return order;
    }
}