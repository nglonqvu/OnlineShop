/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Customer {
    private int idAcc;
    private String name;
    private String phone;
    private String address,status,city;

    public Customer() {
    }

    public Customer(int idAcc, String name, String phone, String address, String status,String city) {
        this.idAcc = idAcc;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.city = city;
    }

    public int getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(int idAcc) {
        this.idAcc = idAcc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }      

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" + "idAcc=" + idAcc + ", name=" + name + ", phone=" + phone + ", address=" + address + ", status=" + status + ", city=" + city + '}';
    }
    
    
}