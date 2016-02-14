package ua.epam.project4.controller.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by danik on 17.01.2016.
 */
public class CommandAddIngredient extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer capacity = 0;
        try {
            capacity = Integer.parseInt(request.getParameter(CAPACITY));
        }catch (NumberFormatException ex){
            return ERROR_PAGE;
        }
        if(capacity <= 0){
            return CommandFactory.getInstance().getCommand(INGREDIENTS).execute(request, response);
        }

        Integer id = Integer.parseInt(request.getParameter(ID));

        DAO_FACTORY.createIngredientDao().addCapacity(capacity, id);

        return CommandFactory.getInstance().getCommand(INGREDIENTS).execute(request, response);
    }
}
