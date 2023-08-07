/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author admin
 */
public class History {
    private int id,amount,cartid;
    private String name,city,address,phone,pName,pImg,status;
    private double pPrice;

    public History() {
    }

    public History(int cartid,int id,  String name, String city, String address, String phone, String pName, String pImg,double pPrice, int amount, String status) {
        this.cartid = cartid;
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.pName = pName;
        this.pImg = pImg;
        this.status = status;
        this.pPrice = pPrice;
    }
    
    
    
    public History(int id,  String name, String city, String address, String phone, String pName, String pImg,double pPrice, int amount, String status) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.pName = pName;
        this.pImg = pImg;
        this.status = status;
        this.pPrice = pPrice;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }


    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", amount=" + amount + ", cartid=" + cartid + ", name=" + name + ", city=" + city + ", address=" + address + ", phone=" + phone + ", pName=" + pName + ", pImg=" + pImg + ", status=" + status + ", pPrice=" + pPrice + '}';
    }

    
    
    
    
    

    
}
