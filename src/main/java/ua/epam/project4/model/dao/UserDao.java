package ua.epam.project4.model.dao;

import ua.epam.project4.model.dao.entities.User;

import java.util.List;

/**
 * Created by danik on 04.01.2016.
 */
public interface UserDao {

    void createUser(User user);
    User findUserByLoginAndPass(String login, String pass);
    List<User> findAllUsers();
    void addBalance(Integer balance, Integer id);
    void minusBalance(Integer balance, Integer id);

}
