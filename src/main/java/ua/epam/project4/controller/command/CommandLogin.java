package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by danik on 14.01.2016.
 */
public class CommandLogin extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter(LOGIN);
        String pass = request.getParameter(PASS);
        User user = DAO_FACTORY.createUserDao().findUserByLoginAndPass(login, pass);

        if(user == null){
            return LOGIN_PAGE;
        }

        HttpSession session = request.getSession();
        session.setAttribute(USER, user);
        session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
        

        return CommandFactory.getInstance().getCommand(DRINKS).execute(request, response);
    }
}
