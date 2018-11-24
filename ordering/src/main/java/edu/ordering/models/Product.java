package edu.ordering.models;
import javax.persistence.*;

@Entity
public class Product {
	@Id
	private long id;
	private long quantity;
	private float price;
	public Product(long id, long quantity, float price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public static boolean isValid(Product product) {
		return product.getId() > 0 && product.getPrice() >= 0.0 && product.getQuantity()>=0;
	}

}
