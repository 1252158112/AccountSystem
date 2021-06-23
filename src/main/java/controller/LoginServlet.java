package controller;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    public Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection)getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        UserDao userDao=new UserDao();
        user=userDao.findByUsernamePassword(con,username,password);
        if(user==null) {
            request.setAttribute("message","登录失败，用户名或密码错误");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
        }
        if(request.getParameter("rememberMe")!=null&&request.getParameter("rememberMe").equals("1")) {
            Cookie usernameCookie=new Cookie("cUsername",user.getUsername().trim());
            Cookie passwordCookie=new Cookie("cPassword",user.getPassword().trim());
            usernameCookie.setMaxAge(60*60*24*50);
            passwordCookie.setMaxAge(60*60*24*50);

            System.out.println(usernameCookie.getValue());
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
        String rem="";
        try {
            request.getParameter("rememberMe").trim();
        }catch (Exception e) {
            rem="0";
        }
        if(rem.equals("")) {
            rem=request.getParameter("rememberMe").trim();
        }
        Cookie rememberMeCookie=new Cookie("cRememberMe",rem);
        response.addCookie(rememberMeCookie);
        rememberMeCookie.setMaxAge(60*60*24*50);
        HttpSession session=request.getSession();
        session.setMaxInactiveInterval(60*60);
        session.setAttribute("user",user);
        response.sendRedirect("myhome");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
