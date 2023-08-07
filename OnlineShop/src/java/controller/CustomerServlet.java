/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CartBuyDAO;
import dal.CartDAO;
import dal.CustomerDAO;
import dal.HistoryDAO;
import model.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.CartBuy;
import model.Customer;
import model.History;
import model.Item;

/**
 *
 * @author admin
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            int uid = Integer.parseInt(request.getParameter("uid"));
            Object o = session.getAttribute("cart");
            CartDAO cd = new CartDAO();
            Cart cart = (Cart) o;
            cd.reduceQuan(cart.getItems());
            CustomerDAO cud = new CustomerDAO();   
            cd.deleteItemfromCartbyUserID(uid);
            String name = request.getParameter("infname");
            String phone = request.getParameter("infphone");
            String address = request.getParameter("infaddress");
            String status = request.getParameter("status");
            String city = request.getParameter("city");
            cud.insertCustomer(uid, status, name, phone, address, city);
            List<History> list = cud.getCustomer(uid);
            HistoryDAO hd = new HistoryDAO();
            hd.insertHist(list,uid);
            List<History> listCartBuy = hd.getAllHist(uid);
            session.setAttribute("listH", listCartBuy);
            cud.deleteCus();
            CartBuyDAO cbd = new CartBuyDAO();
            cbd.deleteCartbuy();
            session.removeAttribute("cartbuy");
            session.removeAttribute("cart");
            session.removeAttribute("size");
            request.getRequestDispatcher("history_cart.jsp").forward(request, response);
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            processRequest(request, response);
        }
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
