package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by danik on 20.01.2016.
 */
public class CommandAddBalance extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);

        Integer balance = 0;
        try {
            balance = Integer.parseInt(request.getParameter(BALANCE));
        }catch (NumberFormatException ex){
            return ERROR_PAGE;
        }

        if(balance <= 0){
            return CommandFactory.getInstance().getCommand(DRINKS).execute(request, response);
        }

        DAO_FACTORY.createUserDao().addBalance( balance, user.getId());

        user = DAO_FACTORY.createUserDao().findUserByLoginAndPass(user.getLogin(), user.getPass());


        session.setAttribute(USER, user);
        session.setMaxInactiveInterval(60*60*3);

        return CommandFactory.getInstance().getCommand(DRINKS).execute(request, response);
    }
}
