package com.ecommerce.model;
public class CartItem {
    private int id; private int userId; private int productId; private String productName; private int quantity; private double price;
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public int getUserId(){return userId;} public void setUserId(int u){this.userId=u;}
    public int getProductId(){return productId;} public void setProductId(int p){this.productId=p;}
    public String getProductName(){return productName;} public void setProductName(String n){this.productName=n;}
    public int getQuantity(){return quantity;} public void setQuantity(int q){this.quantity=q;}
    public double getPrice(){return price;} public void setPrice(double p){this.price=p;}
}
