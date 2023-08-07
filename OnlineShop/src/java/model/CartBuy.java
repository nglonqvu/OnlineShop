/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CartBuy {
    private int cartID;
    private int userID;
    private int productId;
    private String productName;
    private String productImg;
    private double productPrice;
    private int amount;
    private List<Item> items = new ArrayList<>();

    public CartBuy() {
    }

    public CartBuy(int amount, int productId) {
        this.amount = amount;
        this.productId = productId;
    }

    public CartBuy(int userID, int productId, String productName, double productPrice, String productImg, int amount) {
        this.productId = productId;
        this.userID = userID;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.amount = amount;
    }

    public CartBuy(int productId, String productName, double productPrice, String productImg, int amount) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.amount = amount;
    }

    public CartBuy(int cartID, int userID, int productId, String productName, double productPrice, String productImg, int amount) {
        this.cartID = cartID;
        this.userID = userID;
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.amount = amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    
    
    public CartBuy(int userID) {
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

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
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

}
