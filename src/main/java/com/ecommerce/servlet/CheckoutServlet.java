package com.ecommerce.servlet;
import com.ecommerce.dao.CartDAO;
import com.ecommerce.dao.OrderDAO;
import com.ecommerce.model.CartItem;
import javax.servlet.*; import javax.servlet.http.*;
import java.io.IOException; import java.util.List;
public class CheckoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { req.getRequestDispatcher("/checkout.jsp").forward(req,resp); }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer userId = (Integer) req.getSession().getAttribute("userId");
            if(userId==null) userId = 1;
            List<CartItem> items = new CartDAO().listByUserId(userId);
            double total = 0; for(CartItem it: items) total += it.getPrice() * it.getQuantity();
            int orderId = new OrderDAO().createOrder(userId, total, items);
            resp.sendRedirect(req.getContextPath()+"/orders");
        } catch(Exception e){ throw new ServletException(e); }
    }
}
