package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by danik on 14.01.2016.
 */
public class CommandGetUsers extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<User> users = DAO_FACTORY.createUserDao().findAllUsers();

        request.setAttribute(USERS, users);

        return USERS_PAGE;
    }
}
