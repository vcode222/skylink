package com.example.bookingapp;
import java.util.ArrayList;


public class User {
    private String name;
    private String username;
    private String email;
    private String phoneno;
    private String nation;
    private String password;

    private static ArrayList<User> UserDB = new ArrayList<User>();

    public User(String name, String username, String email, String phoneno, String nation, String password) {
        this.setEmail(email);
        this.setName(name);
        this.setNation(nation);
        this.setUsername(username);
        this.setPhoneno(phoneno);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String addUser(User newUser) {
        for (User user : User.UserDB) {
            if (newUser.getUsername().equals(user.getUsername()) == true) {
                return "Username already exists";
            }
        }

        User.UserDB.add(newUser);
        return "Added";
    }

    public static String validatePassword(String username, String pwd) {
        for (User user : User.UserDB) {
            if (user.getUsername().equals(username) == true) {
                if (user.getPassword().equals(pwd) == true) return "Success";
                else return "Wrong Password";
            }
        }

        return "No user with username - " + username + " exits.";
    }

    public static ArrayList<User> getUserDB() {
        return User.UserDB;
    }

    @Override
    public String toString() {
        return "{" + "name:" + this.getName() + ",email:" + this.getEmail() + ",username:" + this.getUsername() + ",phoneno:" + this.getPhoneno() + ",nation:" + this.getNation() + "}";
    }
}
