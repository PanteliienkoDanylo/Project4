package ua.epam.project4.model.dao.entities;

import ua.epam.project4.model.dao.DrinkDao;
import ua.epam.project4.model.dao.IngredientDao;
import ua.epam.project4.model.dao.OperationDao;
import ua.epam.project4.model.dao.UserDao;

/**
 * Created by danik on 04.01.2016.
 */
public abstract class DaoFactory {

    public static final String JDBC_DRIVER_MYSQL = "ua.epam.project4.model.dao.mysql.MySqlDaoFactory";

    public abstract DrinkDao createDrinkDao();

    public abstract IngredientDao createIngredientDao();

    public abstract UserDao createUserDao();

    public abstract OperationDao createOperationDao();

    public static DaoFactory getInstance() {
        Class clazz;
        try {
            clazz = Class.forName(JDBC_DRIVER_MYSQL);
            return (DaoFactory) clazz.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

}
