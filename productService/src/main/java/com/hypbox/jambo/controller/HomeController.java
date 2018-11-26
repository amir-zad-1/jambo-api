package com.hypbox.jambo.controller;

import com.hypbox.jambo.model.dto.HomeDto;
import com.hypbox.jambo.model.dto.ResetDto;
import com.hypbox.jambo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    @ResponseBody
    public HomeDto getHome() {
        HomeDto response = new HomeDto("Jambo Product RESTful API 0.1.0");
        return response;
    }

    @PostMapping("/reset")
    @ResponseBody
    public ResetDto reset() {
        this.productService.deleteAll();
        this.productService.initialize();
        return new ResetDto(true);
    }

}
