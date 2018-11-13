package edu.ordering.models;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "orders")
public class Order extends BaseModel {

    private String description;
//    private List<Product> products;
    private float subtotal;
    private float total;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public String getDescription() {
        return description;
    }

    public Order() {
        super();

    }

    public Order(long id, String description) {
        this.id = id;
        this.description = description;
//        products = new ArrayList<>();
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void addProduct(Product product) {
//        this.products.add(product);
    }
}
