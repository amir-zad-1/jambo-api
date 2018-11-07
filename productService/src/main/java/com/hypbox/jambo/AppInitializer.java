package com.hypbox.jambo;

import com.hypbox.jambo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppInitializer {

    @Autowired
    ProductService productService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        productService.initialize();
    }

}
