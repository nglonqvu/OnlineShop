/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CartBuy;
import model.Customer;
import model.History;
import model.Item;
import model.Product;

/**
 *
 * @author admin
 */
public class HistoryDAO extends DBContext {

    public void insertHist(List<History> his, int uid) {
        String sql = "INSERT History values (?,?,?,?,?,?,?,?,?,?)";
        try {
            for (History p : his) {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, uid);
                st.setString(2, p.getName());
                st.setString(3, p.getCity());
                st.setString(4, p.getAddress());
                st.setString(5, p.getPhone());
                st.setString(6, p.getpName());
                st.setString(7, p.getpImg());
                st.setDouble(8, p.getpPrice());
                st.setInt(9, p.getAmount());
                st.setString(10, p.getStatus());
                st.executeUpdate();
                st.close();
            }

        } catch (Exception e) {
        }
    }

    public List<History> getAllHist(int id) {
        String sql = "select * from History where userid = ?";
        List<History> his = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                History hist = new History(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDouble(9),
                        rs.getInt(10),
                        rs.getString(11));
                his.add(hist);
            }
            
        } catch (Exception e) {
        }
        return his;
    }
    
    public List<History> getAllHistory() {
        String sql = "select * from History";
        List<History> his = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                History hist = new History(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDouble(9),
                        rs.getInt(10),
                        rs.getString(11));
                his.add(hist);
            }
            
        } catch (Exception e) {
        }
        return his;
    }
    
    public void UpdateHistory(int cartid) {
        String sql = "update History set [status] = 'Delivering' where cartid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartid);           
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteHistory(int cartid) {
        String sql = "delete history where cartid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartid);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        HistoryDAO hd = new HistoryDAO();
        hd.deleteHistory(1);
    }
}
