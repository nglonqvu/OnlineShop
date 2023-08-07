/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryDAO extends DBContext{
    public List<Category> getAllCategory(){
        List<Category> listC = new ArrayList<>();
        String sql ="select * from category where cid<= 4";
        try {
            Connection con = new DBContext().connection;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Category cate = new Category(rs.getInt(1), rs.getString(2));
                listC.add(cate);
            }
        } catch (Exception e) {
        }
        return listC;
    }
    
    public List<Category> getAllCategory1(){
        List<Category> listC = new ArrayList<>();
        String sql ="select * from category";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Category cate = new Category(rs.getInt(1), rs.getString(2));
                listC.add(cate);
            }
        } catch (Exception e) {
        }
        return listC;
    }
    
    public void insertCate(String cate){
        String sql = "insert Category values (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cate);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteCate(String cate){
        String sql = "delete Category where cname = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cate);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void UpdateCate(String cateold , String catenew){
        String sql = "update Category set cname = ? where cname = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, catenew);
            st.setString(2, cateold);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Category getDuplicate(String cate){
        String sql = "select * from [dbo].[Category] where [cname] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cate);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category cat = new Category(rs.getInt(1), 
                        rs.getString(2));
                return cat;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        CategoryDAO ca = new CategoryDAO();
        List<Category> list = ca.getAllCategory1();
        for (Category category : list) {
            System.out.println(category);
        }
        
    }
}
