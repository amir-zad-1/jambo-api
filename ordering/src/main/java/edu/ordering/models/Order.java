package edu.ordering.models;

public class Order {
    private int id;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order(int id, String description){
        this.id = id;
        this.description = description;
    }
}
