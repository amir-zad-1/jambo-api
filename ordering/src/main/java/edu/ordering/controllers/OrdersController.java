package edu.ordering.controllers;

import edu.ordering.models.Order;
import edu.ordering.models.Product;
import edu.ordering.service.OrderService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	OrderService orderService;
    //@GetMapping("/order")
   @RequestMapping(value="/order",method = RequestMethod.GET,produces = {"application/json"})
    public Order getOrder(@RequestParam(value = "id",required = false,
            defaultValue = "0") long id) {
        Order p = new Order(1,"order");
        return p;
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
    @RequestMapping(value="/addProduct",method = RequestMethod.POST,produces = {"application/json"})
    public Order addProductToOrder(@RequestBody long idOrder, long idProduct, long quantity, float price) {
    	Product product = new Product(idProduct, quantity, price);
    	Order order = this.orderService.getOrderById(idOrder);
    	if(order != null) {
    		this.orderService.addProduct(order, product);
    	}
    	return order;
    }

}