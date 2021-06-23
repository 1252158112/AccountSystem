package controller;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet",value = "/register")
@MultipartConfig(maxFileSize = 16177215)
public class RegisterServlet extends HttpServlet {
    public Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("in Register");
        con=(Connection)getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        InputStream inputStream=null;
        Part filePart =request.getPart("picture");
        if(filePart!=null&&filePart.getSize()!=0) {
            System.out.println("try add file");
            System.out.println(filePart.getName()+"size:"+filePart.getSize());
            inputStream=filePart.getInputStream();
        }
        Date date=new Date();
        User user = new User(username, password,date);
        UserDao userDao=new UserDao();
        if(userDao.saveUser(con,inputStream,user)) {
            request.setAttribute("message","注册成功");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

        }else {
            request.setAttribute("message","注册失败，用户名已存在");
            request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come here");
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
}
