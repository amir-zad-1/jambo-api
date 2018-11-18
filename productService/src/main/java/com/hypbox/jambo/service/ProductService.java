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
        if (!this.isValid(newProduct)) return null;
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
        p1.setTitle("Seiko 43mm Men's Chronograph Casual Watch");
        p1.setDescription("This Seiko's SKS633P1 chronograph watch bridges the gap between dressy and sporty, making it ideal for everyday wear.");
        p1.setPrice(129.99);
        p1.setImageUrl("https://multimedia.bbycastatic.ca/multimedia/products/1500x1500/128/12872/12872862.jpg");
        p1.setSupplierUrl("https://www.bestbuy.ca/en-ca/product/seiko-43mm-men-s-chronograph-casual-watch-hard-coated-silver-black/12872862.aspx?");
        this.add(p1);
    }

}
