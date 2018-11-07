package com.hypbox.jambo.service;


import com.hypbox.jambo.model.entity.Product;
import com.hypbox.jambo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public Product add(Product product) {
        if (!this.isValid(product)) return null;
        this.productRepository.save(product);
        return product;
    }

    public Product update(Product newProduct) {
        Product oldProduct = this.productRepository.getOne(newProduct.getId());
        if (oldProduct == null) return null;
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public Boolean delete(Long productid) {
        Product product = this.productRepository.getOne(productid);
        if (product == null) return null;
        this.productRepository.delete(product);
        return true;
    }

    public Product getById(Long productid) {
        return this.productRepository.getOne(productid);
    }

    public Boolean isValid(Product product) {
        if (product.getPrice() <= 0.0 &&
            product.getTitle() == null && product.getTitle().trim().isEmpty())
            return false;
        return true;
    }

    public List<Product> searchByTitle(String title) {
        List<Product> result = new ArrayList<>();
        if (title == null && title.trim().isEmpty())
            return result;

        result = this.productRepository.getByTitleContainingIgnoreCase(title);
        return result;
    }

    public void initialize() {
        Product p1 = new Product();
        p1.setTitle("Product 1");
        p1.setDesctiption("Product 1 Description");
        p1.setPrice(12.00);
        p1.setImageUrl("http://www.image.com/");
        this.productRepository.save(p1);
    }

}
