package com.ecommerce.servlet;
import com.ecommerce.dao.UserDAO;
import com.ecommerce.util.PasswordUtil;
import com.ecommerce.model.User;
import javax.servlet.*; import javax.servlet.http.*;
import java.io.IOException;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email"); String password = req.getParameter("password");
        try { User u = new UserDAO().findByEmail(email); if(u!=null && PasswordUtil.verify(password, u.getPasswordHash())){ HttpSession s = req.getSession(); s.setAttribute("userId", u.getId()); s.setAttribute("userName", u.getName()); resp.sendRedirect(req.getContextPath()+"/products"); return; } resp.sendRedirect(req.getContextPath()+"/user/login?error=1"); } catch(Exception e){ throw new ServletException(e); }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { req.getRequestDispatcher("/login.jsp").forward(req,resp); }
}
