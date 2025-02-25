package by.itclass.model.services;

import by.itclass.model.dao.UserDao;
import by.itclass.model.db.DataBase;
import by.itclass.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public List<User> getUsersByCriteria(Map<String, String[]> params) {
        var users = new ArrayList<User>();
        var criteria = params.get("criteria")[0];
        switch (criteria) {
            case "id" -> {
                var id = params.get("id")[0];
                var user = DataBase.findUserById(Integer.parseInt(id));
                if (user != null) {
                    users.add(user);
                }
            }
            case "range" -> {
                var from = Integer.parseInt(params.get("fromId")[0]);
                var to = Integer.parseInt(params.get("toId")[0]);
                users = (ArrayList<User>) DataBase.findUsersByRange(from, to);
            }
        }
        return users;
    }

    public List<User> getUsersFomDbByCriteria(Map<String, String[]> params) {
        var users = new ArrayList<User>();
        var criteria = params.get("criteria")[0];
        switch (criteria) {
            case "id" -> {
                var id = params.get("id")[0];
                //var user = DataBase.findUserById(Integer.parseInt(id));
                var user = userDao.findById(Integer.parseInt(id));
                if (user != null) {
                    users.add(user);
                }
            }
            case "range" -> {
                var from = Integer.parseInt(params.get("fromId")[0]);
                var to = Integer.parseInt(params.get("toId")[0]);
                //users = (ArrayList<User>) DataBase.findUsersByRange(from, to);
                users = (ArrayList<User>) userDao.findByRange(from, to);
            }
        }
        return users;
    }
}
