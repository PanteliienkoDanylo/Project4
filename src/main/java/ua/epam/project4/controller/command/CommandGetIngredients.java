package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.Ingredient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by danik on 17.01.2016.
 */
public class CommandGetIngredients extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<Ingredient> ingredients = DAO_FACTORY.createIngredientDao().findAllIngredients();

        request.setAttribute(INGREDIENTS, ingredients);

        return INGREDIENTS_PAGE;
    }
}
