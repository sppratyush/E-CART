package com.ecommerce.servlet;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;
import javax.servlet.*; import javax.servlet.http.*;
import java.io.IOException; import java.util.*;
public class ProductListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try { List<Product> products = new ProductDAO().listAll(); req.setAttribute("products", products); RequestDispatcher rd = req.getRequestDispatcher("/products.jsp"); rd.forward(req, resp); } catch(Exception e){ throw new ServletException(e); }
    }
}
