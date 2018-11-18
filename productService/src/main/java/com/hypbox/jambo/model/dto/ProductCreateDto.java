package com.hypbox.jambo.model.dto;

import com.hypbox.jambo.model.entity.Product;

public class ProductCreateDto {


    private String title;
    private String description;
    private String imageUrl;
    private String supplierUrl;
    private Double price;

    public ProductCreateDto(Product product) {
        this.description = product.getDescription();
        this.title = product.getTitle();
        this.imageUrl = product.getImageUrl();
        this.price = product.getPrice();
        this.supplierUrl = product.getSupplierUrl();
    }

    public ProductCreateDto() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSupplierUrl() {
        return supplierUrl;
    }

    public void setSupplierUrl(String supplierUrl) {
        this.supplierUrl = supplierUrl;
    }

    public Product toProduct() {
        Product product = new Product();
        product.setSupplierUrl(this.getSupplierUrl());
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setImageUrl(this.getImageUrl());
        product.setPrice(this.getPrice());
        product.setSupplierUrl(this.getSupplierUrl());
        return product;
    }
}
