/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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

/**
 *
 * @author admin
 */
@WebServlet(name = "ProcessServlet", urlPatterns = {"/process"})
public class ProcessServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessSevlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessSevlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();
        CartDAO cad = new CartDAO();
        CartBuyDAO cbd = new CartBuyDAO();
        Cart cart;
        Object o = session.getAttribute("cart");
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String pid = request.getParameter("id");
        String num = request.getParameter("num");
        int quantity;
        int id = Integer.parseInt(pid);
        ProductDAO pd = new ProductDAO();
        Product p = pd.getProductDetail(id);
        try {
            quantity = Integer.parseInt(num);
            if (quantity == -1 && cart.getAmountbyId(id) <= 1) {
                Item delete_item = new Item(cart.getAmountbyId(id) - 1, p.getId());
                if (cart.getAmountbyId(id) <= 1) {
                    cad.deleteItemfromCart(id);
                    cbd.deleteItemfromCart(id);
                }
                cad.changeAmount(delete_item);
                cbd.changeAmount(delete_item);
                cart.removeItem(id);
            } else {
                    Item i = new Item(p.getId(), p.getName(), p.getMoney(), p.getImage(), quantity);
                    cart.addItem(i);
                    Item update_item = new Item(cart.getAmountbyId(id), p.getId());
                    cad.changeAmount(update_item);
                    cbd.changeAmount(update_item);               
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
        request.getRequestDispatcher("detail_cart.jsp").forward(request, response);
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
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String pid = request.getParameter("pid");
        int id = Integer.parseInt(pid);
        ProductDAO pd = new ProductDAO();
        Product p = pd.getProductDetail(id);
        cart.removeItem(id);
        CartDAO cad = new CartDAO();
        CartBuyDAO cbd = new CartBuyDAO();
        cad.deleteItemfromCart(id);
        cbd.deleteItemfromCart(id);
        List<Item> list = cart.getItems();
        CategoryDAO cd = new CategoryDAO();
        List<Category> listC = cd.getAllCategory();
        request.setAttribute("listC", listC);
        session.setAttribute("size", list.size());
        session.setAttribute("cart", cart);
        session.setAttribute("detailP", p);
        request.getRequestDispatcher("detail_cart.jsp").forward(request, response);
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
