/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.CartBuyDAO;
import dal.CartDAO;
import dal.CategoryDAO;
import dal.ProductDAO;
import model.Cart;
import model.Category;
import model.Item;
import model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Account;

/**
 *
 * @author admin
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        Cart cart;
        Object o = session.getAttribute("cart");
        if (o == null) {
            cart = new Cart();
        } else {
            cart = (Cart) o;
        }
        Account acc = (Account) session.getAttribute("acc");
        if (acc == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            String pid = request.getParameter("pid");
            String num = request.getParameter("quantity");
            String uuid = request.getParameter("uid");
            int uid = Integer.parseInt(uuid);
            int quantity;
            int id = Integer.parseInt(pid);
            ProductDAO pd = new ProductDAO();
            Product p = pd.getProductDetail(id);
            CartBuyDAO cbd = new CartBuyDAO();
            try {
                CartDAO cd = new CartDAO();
                quantity = Integer.parseInt(num);
                if (quantity < 2) {
                    Item i = new Item(uid, p.getId(), p.getName(), p.getMoney(), p.getImage(), quantity + 3);
                    Item add = new Item(uid, p.getId(), p.getName(), p.getMoney(), p.getImage(), quantity + 3);
                    if (cd.getAmount(id) == 0) {
                    cd.insertItem(add);
                    cbd.insertItem(add);
                } else {
                    Item update_item = new Item(cd.getAmount(id) + quantity, p.getId());
                    cd.changeAmount(update_item);
                    cbd.changeAmount(i);
                    cart.addItem(i);
                }
                }   
                else if (quantity >3){
                    Item i = new Item(uid, p.getId(), p.getName(), p.getMoney(), p.getImage(), quantity - 2);
                    Item add = new Item(uid, p.getId(), p.getName(), p.getMoney(), p.getImage(), quantity - 2);
                    if (cd.getAmount(id) == 0) {
                    cd.insertItem(add);
                    cbd.insertItem(add);
                } else {
                    Item update_item = new Item(cd.getAmount(id) + quantity, p.getId());
                    cd.changeAmount(update_item);
                    cbd.changeAmount(i);
                    cart.addItem(i);
                }
                }
                
                
            } catch (NumberFormatException e) {
                quantity = 1;
            }
            List<Item> list = cart.getItems();
            CategoryDAO cd = new CategoryDAO();
            List<Category> listC = cd.getAllCategory();
            request.setAttribute("listC", listC);
            session.setAttribute("size", list.size());
            session.setAttribute("cart", cart);
            session.setAttribute("detailP", p);
            request.getRequestDispatcher("detail.jsp").forward(request, response);
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
