package edu.ordering.controllers;

import edu.ordering.models.Order;
import edu.ordering.models.Product;
import edu.ordering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    //@GetMapping("/order")
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @ResponseBody
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") long orderId) {
        Order o = orderService.getOrderById(orderId);
        return o;
    }


    @GetMapping("/")
    public String index(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "index";
    }

    @GetMapping("/account/login")
    public String login(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "login";
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