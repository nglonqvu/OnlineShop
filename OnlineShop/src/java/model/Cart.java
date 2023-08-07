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
public class Cart {
    private List<Item> items;

    @Override
    public String toString() {
        return "Cart{" + "items=" + items + '}';
    }

    public Cart(List<Item> items) {
        this.items = items;
    }
    
    public Cart() {
        items = new ArrayList<>();
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public Item getItem(){
        for (Item item : items) {
            return item;
        }
        return null;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public Item getItembyID(int id){
        for (Item o : items) {
            if( id == o.getProductId()){
                return o;
            }
        }
        return null;
    }
    
    public int getAmountbyId(int id){
        return getItembyID(id).getAmount();
    }
    
    public void addItem(Item item){
        if(getItembyID(item.getProductId())!=null){
            Item m = getItembyID(item.getProductId());
            m.setAmount(m.getAmount()+item.getAmount());
        }
        else{
            items.add(item);
        }
    }
    
    public void removeItem(int id){
        if(getItembyID(id)!=null){
            items.remove(getItembyID(id));
        }
    }
    
    public double getTotalMoney(){
        double total = 0;
        for (Item o : items) {
            total = o.getAmount()*o.getProductPrice();
        }
        return total;
    }
}
