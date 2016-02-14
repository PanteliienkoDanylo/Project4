package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.Drink;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by danik on 17.01.2016.
 */
public class CommandGetDrinks extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        DAO_FACTORY.createDrinkDao().updateAllCount();

        List<Drink> drinks = DAO_FACTORY.createDrinkDao().findAllDrinks();

        request.setAttribute(DRINKS, drinks);

        return DRINKS_PAGE;
    }
}
