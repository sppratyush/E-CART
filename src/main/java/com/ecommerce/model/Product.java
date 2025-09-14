package com.ecommerce.model;
public class Product {
    private int id; private String name; private String description; private double price; private int stock;
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getDescription(){return description;} public void setDescription(String d){this.description=d;}
    public double getPrice(){return price;} public void setPrice(double p){this.price=p;}
    public int getStock(){return stock;} public void setStock(int s){this.stock=s;}
}
