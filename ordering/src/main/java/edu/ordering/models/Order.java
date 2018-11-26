package edu.ordering.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "orders")
public class Order extends BaseModel {

    private String description;
    //    private List<Product> products;
    private float subtotal;
    private float total;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "addressId", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }



    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private java.util.Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "customerName")
    private String customerName;

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
    
    public void addOrderItem(OrderItem orderItem) {
    	this.orderItems.add(orderItem);
    }
    public void addProduct(Product product) {
//        this.products.add(product);
    }
}
