package com.ecommerce.servlet;
import com.ecommerce.dao.UserDAO;
import com.ecommerce.util.PasswordUtil;
import javax.servlet.*; import javax.servlet.http.*;
import java.io.IOException;
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name"); String email=req.getParameter("email"); String password=req.getParameter("password");
        try{ String hashed = PasswordUtil.hash(password); new UserDAO().create(name,email,hashed); resp.sendRedirect(req.getContextPath()+"/user/login"); } catch(Exception e){ throw new ServletException(e); }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { req.getRequestDispatcher("/register.jsp").forward(req,resp); }
}
