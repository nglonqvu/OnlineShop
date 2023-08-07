/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class AccountDAO extends DBContext {

    public Account getAccount(String username, String password) {
        String sql = "select * from [dbo].[Account] where [user] = ? and pass = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account acc = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5));
                return acc;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account getAccount(String username) {
        String sql = "select * from [dbo].[Account] where [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account acc = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5));
                return acc;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Account> getAllAccount() {
        String sql = "select * from [dbo].[Account]";
        List<Account> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5));
                list.add(acc);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteAccount(String name) {
        String sql = "delete Account where [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Account getAccountDuplicate(String username) {
        String sql = "select * from [dbo].[Account] where [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account acc = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5));
                return acc;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertAcc(Account acc) {
        String sql = "INSERT [dbo].[Account] ([user], [pass], [isSell], [isAdmin]) VALUES (?, ?, 1, 0)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, acc.getUsername());
            st.setString(2, acc.getPassword());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }

    public void changePass(String user, String newpass) {
        String sql = "update Account\n"
                + "set pass = ? where \n"
                + "[user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newpass);
            st.setString(2, user);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }
    
    public void UpdateAccount(String name) {
        String sql = "update Account set isAdmin = 1,isSell = 0 where [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }
    
    public void UpdateAccount1(String name) {
        String sql = "update Account set isAdmin = 0,isSell = 1 where [user] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        AccountDAO ad = new AccountDAO();
        List<Account> list = new ArrayList<>();
        list = ad.getAllAccount();
        for (Account account : list) {
            System.out.println(account);
        }
    }
}
