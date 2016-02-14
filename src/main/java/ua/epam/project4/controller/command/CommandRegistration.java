package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by danik on 16.01.2016.
 */
public class CommandRegistration extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(LOGIN);
        String pass = request.getParameter(PASS);

        if(DAO_FACTORY.createUserDao().findUserByLoginAndPass(login, pass) != null){
            return REGISTRATION_PAGE;
        }

        DAO_FACTORY.createUserDao().createUser(new User(login, pass));

        User user = DAO_FACTORY.createUserDao().findUserByLoginAndPass(login, pass);

        HttpSession session = request.getSession();
        session.setAttribute(USER, user);
        session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);

        return CommandFactory.getInstance().getCommand(DRINKS).execute(request, response);
    }
}
