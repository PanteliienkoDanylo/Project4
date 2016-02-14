package ua.epam.project4.model.dao;

import ua.epam.project4.model.dao.entities.Ingredient;
import ua.epam.project4.model.dao.entities.User;

import java.util.List;

/**
 * Created by danik on 04.01.2016.
 */
public interface IngredientDao {

    Ingredient findIngredientById(Integer id);
    List<Ingredient> findAllIngredients();
    void addCapacity(Integer capacity, Integer id);
    void minusCapacity(Integer capacity, Integer id);
}
