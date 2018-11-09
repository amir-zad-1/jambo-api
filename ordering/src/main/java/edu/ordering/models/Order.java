package edu.ordering.models;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private List<Product> products;
    private float subtotal;
    private float total;
    public String getDescription() {
        return description;
    }

    public Order(long id, String description){
        this.id = id;
        this.description = description;
        products = new ArrayList<>();
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    	this.products.add(product);
    }
}
