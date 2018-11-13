package com.hypbox.jambo.model.dto;

import com.hypbox.jambo.model.entity.Product;

public class ProductPersistedDto extends ProductCreateDto {

    private Long id;

    public ProductPersistedDto(Product product) {
        super(product);
        this.setId(product.getId());
    }

    public ProductPersistedDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Product toProduct() {
        Product product = super.toProduct();
        product.setId(this.getId());
        return product;
    }
}
