package dhy.jc.reader.model;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

/**
 * 用户实体类
 * Created by Administrator on 2016/11/18.
 */
@Alias("User")
@Component("user")
public class User {
    private int id;
    private String username;
    private String password;
    private String mobile;
    private String email;
    private int type;           //用户种类
    private String qq;
    private String wechat;
    private int bookage;
    private int gender;

    public User() {
    }

    public User(int bookage, String email, int gender, int id, String mobile, String password, String qq, int type, String username, String wechat) {
        this.bookage = bookage;
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.qq = qq;
        this.type = type;
        this.username = username;
        this.wechat = wechat;
    }

    public int getBookage() {
        return bookage;
    }

    public void setBookage(int bookage) {
        this.bookage = bookage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
