package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.DrinkCapacity;
import ua.epam.project4.model.dao.entities.Drink;
import ua.epam.project4.model.dao.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danik on 27.01.2016.
 */
public class CommandTakeDrink extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER);

        Integer id = Integer.parseInt(request.getParameter(ID));


        Drink drink = DAO_FACTORY.createDrinkDao().findDrinkById(id);

        if(user.getBalance() < drink.getPrice() || drink.getCount() == 0){
            return CommandFactory.getInstance().getCommand(DRINKS).execute(request, response);
        }else {

            minusIngredientCapacity(drink);

            DAO_FACTORY.createUserDao().minusBalance(drink.getPrice(), user.getId());
            DAO_FACTORY.createDrinkDao().updateAllCount();

            DAO_FACTORY.createOperationDao().createOperation(user, drink);

            user = DAO_FACTORY.createUserDao().findUserByLoginAndPass(user.getLogin(), user.getPass());

            session.setAttribute(USER, user);
            session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
        }

        return CommandFactory.getInstance().getCommand(DRINKS).execute(request, response);
    }

    private void minusIngredientCapacity(Drink drink){
        List<DrinkCapacity> drinkCapacityList = drink.getDrinkCapacityList();
        for(int i = 0; i < drinkCapacityList.size(); i++){
            DAO_FACTORY.createIngredientDao().minusCapacity(drinkCapacityList.get(i).getCapacity(), drinkCapacityList.get(i).getId());
        }

    }

}
