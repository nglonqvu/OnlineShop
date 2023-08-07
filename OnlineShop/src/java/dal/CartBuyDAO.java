/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Item;

/**
 *
 * @author admin
 */
public class CartBuyDAO extends DBContext{
    public void insertItem(Item i) {
        String sql = "INSERT CartBuy values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, i.getUserID());
            st.setInt(2, i.getProductId());
            st.setString(3, i.getProductName());
            st.setDouble(4, i.getProductPrice());
            st.setString(5, i.getProductImg());
            st.setInt(6, i.getAmount());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }
    
    public void changeAmount(Item i) {
        String sql = "update CartBuy set Amount = ? where productId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, i.getAmount());
            st.setInt(2, i.getProductId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }
    

    public void deleteItemfromCart(int id) {
        String sql = "delete cartbuy where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }

    public List<Item> getItemfromUserID(int id) {
        String sql = "select [UserId],[ProductID],[ProductName],[ProductPrice],[ProductImg],[Amount] from Cartbuy where UserID = ?";
        List<Item> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Item i = new Item(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6));
                list.add(i);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getAmount(int id) {
        String sql = "select amount from Cartbuy where ProductID = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                int i = rs.getInt(1);
                return i;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public void deleteCartbuy(){
        String sql = "truncate table Cartbuy";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        CartBuyDAO cbd = new CartBuyDAO();
        Item i = new Item(2,	1,	"Samsung Galaxy S23 Ultra"	,1350	,"https://cdn.tgdd.vn/Products/Images/42/301796/samsung-galaxy-s23-ultra-xanh-200x200.jpg"	,1);
        System.out.println(i);
        cbd.insertItem(i);
    }
}
