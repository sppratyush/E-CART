package com.ecommerce.servlet.admin;
import javax.servlet.*; import javax.servlet.http.*;
import java.io.IOException;
public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/dashboard.jsp").forward(req,resp);
    }
}
