/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Item {
    private int userID;
    private int productId;
    private String productName;
    private String productImg;
    private double productPrice;
    private int amount;

    public Item() {
    }
    
    public Item(int amount , int productId) {
        this.amount = amount;
        this.productId = productId;
    }

    public Item( int userID ,int productId, String productName, double productPrice, String productImg, int amount) {
        this.productId = productId;
        this.userID = userID;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.amount = amount;
    }
    
    public Item( int productId, String productName, double productPrice, String productImg, int amount) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.amount = amount;
    }  
    
    public Item(int userID) {
        this.userID = userID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
    
    
    public double getProductPrice() {
        return productPrice;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +" userID=" + userID + ", productId=" + productId + ", productName=" + productName + ", productImg=" + productImg + ", productPrice=" + productPrice + ", amount=" + amount + '}';
    }

    

}
