package com.hypbox.jambo.model.dto;

import com.hypbox.jambo.model.entity.Product;

public class ProductCreateDto {


    private String title;
    private String description;
    private String imageUrl;
    private Double price;

    public ProductCreateDto(Product product) {
        this.description = product.getDesctiption();
        this.title = product.getTitle();
        this.imageUrl = product.getImageUrl();
        this.price = product.getPrice();
    }

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

}
