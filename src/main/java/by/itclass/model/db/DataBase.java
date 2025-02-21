package by.itclass.model.db;

import by.itclass.model.entities.User;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class DataBase {
    private static List<User> users = List.of(
            new User(1, "Vasia Pupkin", "vasia123@gmail.com"),
            new User(2, "Ivan Ivanov", "vano@yandex.ru"),
            new User(3, "John Smith", "j.smith@yahoo.com")
    );

    public static boolean isContainsByFio(String fio) {
        return users.stream().anyMatch(it -> it.getFio().equalsIgnoreCase(fio));
    }

    public static User findUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static List<User> findUsersByRange(int fromId, int toId) {
        return users.stream()
                .filter(user -> user.getId() >= fromId && user.getId() <= toId)
                .collect(Collectors.toList());
    }
}
