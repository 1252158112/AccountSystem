package dao;

import model.User;

import java.io.InputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDao {
    public boolean saveUser(Connection con, User user) {
        try{
            Statement createDbStatement = con.createStatement();
            String dbRequire="insert into UserTable(username,password,registerDate) values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getRegisterDate()+"')";
            System.out.println(dbRequire);
            createDbStatement.executeUpdate(dbRequire);
            System.out.println("insert "+user.toString()+"success");
            return true;
        }catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean saveUser(Connection con, InputStream picture, User user) {
        if(picture==null) {
            return this.saveUser(con,user);
        }
        try{
            Statement createDbStatement = con.createStatement();
            String dbRequire="insert into UserTable(username,password,registerDate,picture) values(?,?,?,?)";
            PreparedStatement pt = con.prepareStatement(dbRequire);
            pt.setString(1,user.getUsername());
            pt.setString(2,user.getPassword());
            pt.setString(3,user.getRegisterDate());
            pt.setBinaryStream(4,picture);
            System.out.println("complete create insert");
            pt.executeUpdate();
            System.out.println("insert "+user.toString()+"success");
            return true;
        }catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public byte[] getPictureById(Integer userId,Connection con) throws  SQLException{
        byte[] imgByte=null;
        String sql="select picture from UserTable where userId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,userId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()) {
            Blob blob =rs.getBlob("picture");
            imgByte=blob.getBytes(1,(int)blob.length());
        }
        return imgByte;
    }
    public User findByUsernamePassword(Connection con, String username, String password) {
        String dbRequire="select * from UserTable where username='"+username+"' and password='"+password+"'";
        User user=null;
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                user=new User(resultDb.getInt("userId"),resultDb.getString("username"),resultDb.getString("password"),resultDb.getDate("registerDate"));
                if(resultDb.getDate("vipEndDate")!=null) {
                    user.setVipEndDate(""+resultDb.getDate("vipEndDate"));
                }
                Blob blob =resultDb.getBlob("picture");
                if(blob!=null) {
                    System.out.println("hasPicture");
                    byte[] imgByte=null;
                    imgByte=blob.getBytes(1,(int)blob.length());
                    user.setPicture(new String(imgByte));
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(user);
        return user;
    }
}
