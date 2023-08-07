/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CartDAO extends DBContext {

    public void insertItem(Item item) {
        String sql = "INSERT Cart ([UserId],[ProductID],[ProductName],[ProductPrice],[ProductImg],[Amount]) values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, item.getUserID());
            st.setInt(2, item.getProductId());
            st.setString(3, item.getProductName());
            st.setDouble(4, item.getProductPrice());
            st.setString(5, item.getProductImg());
            st.setInt(6, item.getAmount());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }

    public void changeAmount(Item i) {
        String sql = "update Cart set Amount = ? where productId = ?";
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
        String sql = "delete cart where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }

    public void deleteItemfromCartbyUserID(int id) {
        String sql = "delete cart where userID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }
    
    public List<Item> getItemfromUserID(int id) {
        String sql = "select [UserId],[ProductID],[ProductName],[ProductPrice],[ProductImg],[Amount] from Cart where UserID = ?";
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
        String sql = "select amount from Cart where ProductID = ?";
        
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
    
    public int reduceQuan(List<Item> item) {
        String sql = "update Product set quantity = quantity - ?  where id = ?";       
        try {
            for (Item item1 : item) {
                PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, item1.getAmount());
            st.setInt(2, item1.getProductId());
            st.executeUpdate();
            }
            
        } catch (Exception e) {
        }
        return 0;
    }
    
}
