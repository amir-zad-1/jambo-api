package com.hypbox.jambo.controller;

import com.hypbox.jambo.model.dto.HomeDto;
import com.hypbox.jambo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ProductController {

    @GetMapping("")
    @ResponseBody
    public HomeDto getHome() {
        HomeDto response = new HomeDto("Volcano RESTful API 0.1.0");
        return response;
    }

}
