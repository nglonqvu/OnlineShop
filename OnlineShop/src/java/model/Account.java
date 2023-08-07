/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Account {

    private int uID;
    private String username;
    private String password;
    private boolean isSell;
    private boolean isAdmin;

    public Account() {
    }

    public Account(int uID, String username, String password, boolean isSell, boolean isAdmin) {
        this.uID = uID;
        this.username = username;
        this.password = password;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isIsSell() {
        return isSell?1:0;
    }

    public void setIsSell(boolean isSell) {
        this.isSell = isSell;
    }

    public int isIsAdmin() {
        return isAdmin?1:0;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "uID=" + uID + ", username=" + username + ", password=" + password + ", isSell=" + isSell + ", isAdmin=" + isAdmin + '}';
    }
    
}
