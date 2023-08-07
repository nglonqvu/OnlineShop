/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Category;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ProductDAO extends DBContext {

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            Connection con = new DBContext().connection;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProduct1() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            Connection con = new DBContext().connection;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchProduct(String search) {
        String sql = "select * from Product where [name] like ?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchAllProductbyCate(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product where cateID = ?";
        try {
            Connection con = new DBContext().connection;
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductDetail(int id) {
        String sql = "select * from Product where ID = ?";
        try {
            Connection con = new DBContext().connection;
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(8));
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Product getProductDetail1(String name) {
        
        String sql = "select * from Product where name = ?";
        try {
            Connection con = new DBContext().connection;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertProduct(Product p) {
        String sql = "insert Product values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setString(2, p.getImage());
            st.setDouble(3, p.getMoney());
            st.setString(4, p.getTitle());
            st.setString(5, p.getDescription());
            st.setInt(6, p.getCateId());
            st.setInt(7, p.getQuantity());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(String name) {
        String sql = "delete product where name = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void UpdateProduct(Product p, String name) {
        String sql = "UPDATE Product\n"
                + "SET name = ? , image = ?, price = ? , title = ? , description =?, cateID = ? ,quantity = ?\n"
                + "WHERE name = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
             st.setString(1, p.getName());
            st.setString(2, p.getImage());
            st.setDouble(3, p.getMoney());
            st.setString(4, p.getTitle());
            st.setString(5, p.getDescription());
            st.setInt(6, p.getCateId());
            st.setInt(7, p.getQuantity());
            st.setString(8, name);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void UpdateProductQuantity(String name, int amount) {
        String sql = "UPDATE Product\n"
                + "SET quantity = quantity + ?\n"
                + "WHERE name = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
             st.setInt(1, amount);
             st.setString(2, name);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Product getProductDuplicate(String pname) {
        String sql = "select * from [dbo].[Product] where [name] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pname);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
                return p;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
        pd.UpdateProductQuantity("Samsung Galaxy S23 Ultra", 10);
    }
}
