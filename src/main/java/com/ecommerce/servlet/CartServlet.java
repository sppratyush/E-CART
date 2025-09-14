package com.ecommerce.servlet;
import com.ecommerce.dao.CartDAO;
import com.ecommerce.model.CartItem;
import javax.servlet.*; import javax.servlet.http.*;
import java.io.IOException; import java.util.List;
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        try {
            if(path==null || "/".equals(path)){
                Integer userId = (Integer) req.getSession().getAttribute("userId");
                if(userId==null) userId = 1;
                List<CartItem> items = new CartDAO().listByUserId(userId);
                req.setAttribute("cartItems", items);
                req.getRequestDispatcher("/cart.jsp").forward(req, resp);
                return;
            }
            if(path.startsWith("/add")){
                int productId = Integer.parseInt(req.getParameter("productId"));
                Integer userId = (Integer) req.getSession().getAttribute("userId");
                if(userId==null) userId = 1;
                new CartDAO().addToCart(userId, productId, 1);
                resp.sendRedirect(req.getContextPath()+"/cart");
                return;
            }
            if(path.startsWith("/remove")){
                int id = Integer.parseInt(req.getParameter("id"));
                new CartDAO().removeById(id);
                resp.sendRedirect(req.getContextPath()+"/cart");
                return;
            }
            resp.sendError(404);
        } catch(Exception e){
            throw new ServletException(e);
        }
    }
}
