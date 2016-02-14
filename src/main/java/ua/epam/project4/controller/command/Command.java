package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.DaoFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by danik on 14.01.2016.
 */
public abstract class Command {

    public static final String LOGIN = "login";
    public static final String PASS = "pass";
    public static final String USER = "user";
    public static final String BALANCE = "balance";
    public static final String USERS = "users";
    public static final String INGREDIENTS = "ingredients";
    public static final String DRINKS = "drinks";
    public static final String OPERATIONS = "operations";
    public static final String ID = "id";
    public static final String CAPACITY = "capacity";
    public static final String ERROR_PAGE = "404.jsp";
    public static final String MAIN_PAGE = "main.jsp";
    public static final String LOGIN_PAGE = "login.jsp";
    public static final String USERS_PAGE = "app/users.jsp";
    public static final String DRINKS_PAGE = "app/drinks.jsp";
    public static final String OPERATIONS_PAGE = "app/operations.jsp";
    public static final String INGREDIENTS_PAGE = "app/ingredients.jsp";
    public static final String REGISTRATION_PAGE = "registration.jsp";
    public static final String DEFAULT_PAGE = "index.jsp";
    public static final Integer MAX_INACTIVE_INTERVAL = 60*60*3;

    static final DaoFactory DAO_FACTORY;

    static {
        DAO_FACTORY = DaoFactory.getInstance();
    }

    public abstract String execute(HttpServletRequest request, HttpServletResponse response);
}
