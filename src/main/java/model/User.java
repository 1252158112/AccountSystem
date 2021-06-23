package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private Integer userid;
    private String username;
    private String password;
    private Date registerDate;

    public User() {
    }

    private String vipEndDate;
    private String picture;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        String basics= "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", vipEndDate=" + vipEndDate
                ;
        if(picture != null) {
            basics+="picture="+picture.length();
        }
        basics+='}';
        return basics;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterDate() {
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println();
        return format.format(registerDate);
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String  getVipEndDate() {
        return vipEndDate;
    }

    public void setVipEndDate(String vipEndDate) {
        this.vipEndDate = vipEndDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User(int userid, String username, String password, Date registerDate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
    }

    public User(int userid, String username, String password, Date registerDate, String vipEndDate, String picture) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
        this.vipEndDate = vipEndDate;
        this.picture = picture;
    }

    public User(String username, String password, Date registerDate, String picture) {
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
        this.picture = picture;
    }
    public User(String username, String password, Date registerDate) {
        this.username = username;
        this.password = password;
        this.registerDate = registerDate;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
