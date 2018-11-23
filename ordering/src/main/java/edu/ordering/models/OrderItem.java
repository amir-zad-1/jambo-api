package edu.ordering.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseModel {

    private long productId;
    private long productName;
    private int quantity;
    private Double price;

    public OrderItem() {
        super();

    }

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    @JsonIgnore
    private Order order;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductName() {
        return productName;
    }

    public void setProductName(long productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isValid() {
    	return (this.price > 0.0 && this.quantity >= 0);
    }
}
