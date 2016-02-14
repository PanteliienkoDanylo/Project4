package ua.epam.project4.model.dao.mysql;

import ua.epam.project4.model.dao.OperationDao;
import ua.epam.project4.model.dao.entities.Drink;
import ua.epam.project4.model.dao.entities.Operation;
import ua.epam.project4.model.dao.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danik on 31.01.2016.
 */
public class MySqlOperationDao implements OperationDao {

    public static final String SQL_CREATE_OPERATION = "INSERT INTO operation (user_id, drink_id) VALUES(?, ?)";
    public static final String SQL_FIND_ALL_OPERATIONS = "SELECT operation.id, user.login, drink.name  FROM operation LEFT JOIN user ON operation.user_id = user.id LEFT JOIN drink ON operation.drink_id = drink.id;";
    public static final String SQL_DELETE_ALL_OPERATIONS = "DELETE FROM operation";


    @Override
    public void createOperation(User user, Drink drink) {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE_OPERATION);
            ps.setInt(1, user.getId());
            ps.setInt(2, drink.getId());
            ps.executeUpdate();
        }catch (Exception ex){
        }
    }

    @Override
    public Operation findOperationById(Integer id) {
        List<Operation> operationList = findAllOperations();
        for(Operation o : operationList){
            if(o.getId() == id){
                return o;
            }
        }
        return null;
    }

    @Override
    public List<Operation> findAllOperations() {
        List<Operation> result = new ArrayList<Operation>();
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_OPERATIONS);
            while(rs.next()){
                result.add(new Operation(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch(Exception ex){
        }
        return result;
    }

    @Override
    public void deleteAll() {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            Statement statement = connection.createStatement();
            statement.executeQuery(SQL_DELETE_ALL_OPERATIONS);
        }catch (Exception ex){
        }

    }
}
