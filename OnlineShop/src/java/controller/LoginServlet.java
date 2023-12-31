/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.CartDAO;
import model.Account;
import model.Cart;
import model.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            AccountDAO ad = new AccountDAO();
            String username = request.getParameter("user");
            String password = request.getParameter("pass");
            String remember = request.getParameter("remember");
            Account acc = ad.getAccount(username, password);
            if (acc == null) {
                String error = "Wrong username or password!";
                request.setAttribute("error", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } 
            else if(acc.isIsAdmin()==1){
                Cookie user = new Cookie("usersave", username);
                Cookie pass = new Cookie("passsave", password);
                Cookie rem = new Cookie("rem", remember);
                if (remember == null) {
                    user.setMaxAge(0);
                    pass.setMaxAge(0);
                    rem.setMaxAge(0);
                } else {
                    user.setMaxAge(60 * 60 * 24);
                    pass.setMaxAge(60 * 60 * 24);
                    rem.setMaxAge(60 * 60 * 24);
                }
                response.addCookie(user);
                response.addCookie(pass);
                response.addCookie(rem);
                HttpSession session = request.getSession();
                session.setAttribute("acc", acc);
                request.getRequestDispatcher("homeadmin").forward(request, response);
            }
            else {
                HttpSession session = request.getSession();
                Cookie user = new Cookie("usersave", username);
                Cookie pass = new Cookie("passsave", password);
                Cookie rem = new Cookie("rem", remember);
                if (remember == null) {
                    user.setMaxAge(0);
                    pass.setMaxAge(0);
                    rem.setMaxAge(0);
                } else {
                    user.setMaxAge(60 * 60 * 24);
                    pass.setMaxAge(60 * 60 * 24);
                    rem.setMaxAge(60 * 60 * 24);
                }
                response.addCookie(user);
                response.addCookie(pass);
                response.addCookie(rem);
                session.setAttribute("acc", acc);
                session.setAttribute("accuID", acc.getuID());
                CartDAO cad = new CartDAO();
                int id = (int) session.getAttribute("accuID");
                List<Item> list = cad.getItemfromUserID(id);
                Cart cart = new Cart();
                cart.setItems(list);
                session.setAttribute("cart", cart);
                session.setAttribute("size", list.size());
                request.getRequestDispatcher("home").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
