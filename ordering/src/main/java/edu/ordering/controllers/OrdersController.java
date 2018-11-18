package edu.ordering.controllers;

import edu.ordering.models.Order;
import edu.ordering.models.Product;
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

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, produces = {"application/json"})
    public Order addProductToOrder(@RequestBody long idOrder, long idProduct, long quantity, float price) {
        Product product = new Product(idProduct, quantity, price);
        Order order = this.orderService.getOrderById(idOrder);
        if (order != null) {
            this.orderService.addProduct(order, product);
        }
        return order;
    }

}