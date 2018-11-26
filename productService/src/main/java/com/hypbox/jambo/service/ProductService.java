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

        p1 = new Product();
        p1.setTitle("Spring Festival Traditional Clothes-Dragon robe");
        p1.setDescription("The Qing Dynasty Costume/Queen's dress/Ancient Chinese Cosplay/Emperors Clothing/New Year's dress/Halloween Costume/Campus Party Dress");
        p1.setPrice(97.50);
        p1.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/612gVDCvtML._SX679_.jpg");
        p1.setSupplierUrl("https://www.amazon.com/Emperors-Clothing-Halloween-Traditional-Clothes-Dragon/dp/B07C5Z1BVK/ref=sr_1_20?ie=UTF8&qid=1543246731&sr=8-20&keywords=china+new+year");
        this.add(p1);

        p1 = new Product();
        p1.setTitle("Capelin Caviar 1.75 oz each");
        p1.setDescription("Get it as soon as Dec 11 - 21 when you choose Standard Shipping at checkout. Ships from and sold by Super Sales 365");
        p1.setPrice(56.83);
        p1.setImageUrl("https://www.caviarrusse.com/spree/products/1/product/Caspian_Sea_000_Beluga_Caviar.jpg?1480732399");
        p1.setSupplierUrl("https://www.amazon.ca/Capelin-Caviar-1-75-Items-Order/dp/B01ASW5MFW/ref=sr_1_11?s=grocery&ie=UTF8&qid=1543247252&sr=1-11&keywords=caviar");
        this.add(p1);
    }

}
