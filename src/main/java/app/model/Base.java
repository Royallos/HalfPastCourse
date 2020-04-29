package app.model;

import app.entity.User;

import java.util.ArrayList;
import java.util.List;


public class Base {

    private static Base base = new Base();
    public List<User> userList = new ArrayList<>();

    public static Base getBase(){
        return base;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getUser(){
        return userList;
    }
}
