package ua.epam.project4.model.dao.mysql;

import ua.epam.project4.model.dao.DrinkDao;
import ua.epam.project4.model.dao.IngredientDao;
import ua.epam.project4.model.dao.OperationDao;
import ua.epam.project4.model.dao.UserDao;
import ua.epam.project4.model.dao.entities.DaoFactory;


public class MySqlDaoFactory extends DaoFactory {
    @Override
    public DrinkDao createDrinkDao() {
        return new MySqlDrinkDao();
    }

    @Override
    public IngredientDao createIngredientDao() {
        return new MySqlIngredientDao();
    }

    @Override
    public UserDao createUserDao() {
        return new MySqlUserDao();
    }

    @Override
    public OperationDao createOperationDao() {
        return new MySqlOperationDao();
    }
}
