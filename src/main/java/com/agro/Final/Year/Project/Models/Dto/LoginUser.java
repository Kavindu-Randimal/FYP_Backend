package com.agro.Final.Year.Project.Models.Dto;


import javax.persistence.*;

@Entity
//@Table(name="login_user")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;


    private String userName;
    private String userEmail;
    private String userRole;
    private String password;

    private String privateKey;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public LoginUser() {
    }

    public LoginUser(int id, String userName, String userEmail, String userRole, String password, String privateKey) {
        Id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.password = password;
        this.privateKey = privateKey;
    }

    //    public LoginUser(int id, String userName, String userEmail, String userRole, String password) {
//        Id = id;
//        this.userName = userName;
//        this.userEmail = userEmail;
//        this.userRole = userRole;
//        this.password = password;
//    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "Id=" + Id +
                ", UserName='" + userName + '\'' +
                ", UserEmail='" + userEmail + '\'' +
                ", UserRole='" + userRole + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
