package edu.ordering.controllers;

import edu.ordering.models.Order;

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


    //@GetMapping("/order")
   @RequestMapping("/order")
    public Order getOrder(@RequestParam(value = "id",required = false,
            defaultValue = "0") Integer id) {
        Order p = new Order(1,"oder");
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


}