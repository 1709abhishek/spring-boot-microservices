package com.example.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {

    //JPA/Hibernate > Database
    //UserDAOService > Static List
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Abhishek", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Kamikaze", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Kami", LocalDate.now().minusYears(30)));
    }


    public static List<User> getUsers() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void removeUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User saveUser(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}