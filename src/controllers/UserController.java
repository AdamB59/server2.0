package controllers;

import com.google.gson.Gson;
import database.DBConnector;
import model.User;

import java.util.ArrayList;

/**
 * Created by mortenlaursen on 17/10/2016.
 */
public class UserController {
    Gson gson;


    public UserController() {
        this.gson = new Gson();
    }

    public String getUsers() {
        return gson.toJson(DBConnector.getUsers());
    }

    public String getUser(int id) {
        return gson.toJson(DBConnector.getUser(id));
    }

    public boolean editUser(int id) {
        return DBConnector.editUser(id);
    }

    public boolean deleteUser(int id) {
        return DBConnector.deleteUser(id);
    }

    public boolean addUser(String data) {
        User u = gson.fromJson(data,User.class);
        return DBConnector.addUser(u);
    }

}
