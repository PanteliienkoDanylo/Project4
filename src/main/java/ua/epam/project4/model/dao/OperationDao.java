package ua.epam.project4.model.dao;

import ua.epam.project4.model.dao.entities.Drink;
import ua.epam.project4.model.dao.entities.Operation;
import ua.epam.project4.model.dao.entities.User;

import java.util.List;

/**
 * Created by danik on 04.01.2016.
 */
public interface OperationDao {

    void createOperation(User user, Drink drink);
    Operation findOperationById(Integer id);
    List<Operation> findAllOperations();
    void deleteAll();
}
