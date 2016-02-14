package ua.epam.project4.model.dao;

import ua.epam.project4.model.dao.entities.DrinkCapacity;
import ua.epam.project4.model.dao.entities.Drink;
import ua.epam.project4.model.dao.entities.Ingredient;

import java.util.List;

/**
 * Created by danik on 04.01.2016.
 */
public interface DrinkDao {

    List<Drink> findAllDrinks();
    void minusCount(Integer id);
    List<DrinkCapacity> getDrinkCapacity(Integer id);
    Drink findDrinkById(Integer id);
    void updateAllCount();
}
