package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static final String Q1 = "SELECT * FROM user WHERE id = ?";
    public static final String Q2 = "SELECT * FROM user WHERE id >= ? AND id <= ?";

    //id в данный метод нам приходит из сервиса, в сервис он попадает из сервлета, в сервлет он попадает из
    // запроса а запрос формируется из формы
    public User findById(int id) {
        try (var cn = ConnectionManager.getConnection();
            var ps = cn.prepareStatement(Q1)) {
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            if (rs.next()) {
                var userId = rs.getInt("id");
                var fio = rs.getString("fio");
                var email = rs.getString("email");
                return new User(userId, fio, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findByRange(int fromId, int toId) {
        var users = new ArrayList<User>();
        try (var cn = ConnectionManager.getConnection();
            var ps = cn.prepareStatement(Q2)){
            ps.setInt(1, fromId);
            ps.setInt(2, toId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var userId = rs.getInt("id");
                var fio = rs.getString("fio");
                var email = rs.getString("email");
                users.add(new User(userId, fio, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
