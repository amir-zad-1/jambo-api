package com.hypbox.jambo.controller;

import com.hypbox.jambo.model.dto.ProductCreateDto;
import com.hypbox.jambo.model.dto.ProductDeleteResponse;
import com.hypbox.jambo.model.dto.ProductPersistedDto;
import com.hypbox.jambo.model.entity.Product;
import com.hypbox.jambo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ResponseBody
    @GetMapping("")
    public List<ProductPersistedDto> getAll() {
        List<Product> reservationList = productService.getAll();
        return reservationList.stream()
                .map(ProductPersistedDto::new)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @GetMapping("/{productid}")
    public ProductPersistedDto getById(@PathVariable("productid") long productid) {
        try {
            Product findProduct = this.productService.getById(productid);
            return new ProductPersistedDto(findProduct);
        } catch (EntityNotFoundException e) {
            throw new Http404Exception();
        }
    }

    @ResponseBody
    @PostMapping("")
    public ProductPersistedDto addProduct(@Valid @RequestBody ProductCreateDto productCreateDto) {
        Product product;
        try {
            product = productCreateDto.toProduct();
            this.productService.add(product);
        } catch (NotValidException | NotAvailableException e) {
            throw new Http400Exception(e.getMessage());
        }
        return new ProductPersistedDto(product);
    }

    @ResponseBody
    @PutMapping("")
    public ProductPersistedDto updateProduct(@Valid @RequestBody ProductPersistedDto productPersistedDto) {
        Product product;
        try {
            product = productPersistedDto.toProduct();
            this.productService.update(product);
        } catch (NotValidException | NotAvailableException e) {
            throw new Http400Exception(e.getMessage());
        }
        return new ProductPersistedDto(product);
    }

    @ResponseBody
    @DeleteMapping("/{productid}")
    public ProductDeleteResponse cancel(@PathVariable("productid") long productid) {
        try {
            Boolean result = this.productService.delete(productid);
            return new ProductDeleteResponse(result);
        } catch (EntityNotFoundException e) {
            throw new Http404Exception();
        }
    }

}
