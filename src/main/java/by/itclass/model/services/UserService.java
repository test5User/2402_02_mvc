package by.itclass.model.services;

import by.itclass.model.db.DataBase;
import by.itclass.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
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
}
