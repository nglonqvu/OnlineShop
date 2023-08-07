/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Product {
    private int id;
    private String name;
    private String image;
    private double money;
    private String title;
    private String description;
    private int quantity;
    private int cateId;

    public Product() {
    }

    public Product(int id, String name, String image, double money, String title, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.money = money;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
    }

    public Product(String name, String image, double money, String title, String description, int cateId, int quantity) {
        this.name = name;
        this.image = image;
        this.money = money;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.cateId = cateId;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", image=" + image + ", money=" + money + ", title=" + title + ", description=" + description + ", quantity=" + quantity + ", cateId=" + cateId + '}';
    }
    
    
    
    
    
    
}
