/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Cart;
import model.Customer;
import model.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.History;

/**
 *
 * @author admin
 */
public class CustomerDAO extends DBContext {

    public void insertCustomer(int id, String status, String name, String phone, String address, String city) {
        String sql = "INSERT Customer ([idAcc],[name],[phone],[city],[address],[status]) values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, phone);
            st.setString(4, city);
            st.setString(5, address);
            st.setString(6, status);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }

    public List<History> getCustomer(int id) {
        String sql = "select b.UserId,a.[name],a.city,a.[address],a.phone,b.ProductName,b.ProductImg,b.ProductPrice,b.Amount,a.[status] "
                + "from Customer a, CartBuy b where a.idAcc = b.UserId and b.UserId = ?";
        List<History> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                History his = new History(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10)
                );
                list.add(his);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Customer getCustomerDuplicate(Customer cus) {
        String sql = "select * from Customer where [name] = ? and idAcc =? "
                + "and phone = ? and city = N'?' and [address] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cus.getIdAcc());
            st.setString(2, cus.getName());
            st.setString(3, cus.getPhone());
            st.setString(4, cus.getCity());
            st.setString(5, cus.getAddress());
            st.setString(6, cus.getStatus());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer cust = new Customer(rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getString(6));
                return cust;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void deleteCus(){
        String sql = "truncate table Customer";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        CustomerDAO cud = new CustomerDAO();
        Customer cus = new Customer(2,"Admin","0327720439","Cần Thơ","Thôn 9","wait");
        cud.getCustomerDuplicate(cus);
    }
}
