package ua.epam.project4.model.dao.mysql;

import ua.epam.project4.model.dao.IngredientDao;
import ua.epam.project4.model.dao.entities.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MySqlIngredientDao implements IngredientDao {

    public static final String SQL_FIND_ALL_INGREDIENTS = "SELECT * FROM ingredient";
    public static final String SQL_ADD_INGREDIENT_CAPACITY = "UPDATE ingredient SET capacity = capacity + ? WHERE id = ?";
    public static final String SQL_MINUS_INGREDIENT_CAPACITY = "UPDATE ingredient SET capacity = capacity - ? WHERE id = ?";

    @Override
    public Ingredient findIngredientById(Integer id) {
        List<Ingredient> ingredientList = findAllIngredients();
        for(Ingredient i : ingredientList){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Ingredient> findAllIngredients() {
        List<Ingredient> result = new ArrayList<Ingredient>();
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_INGREDIENTS);
            while(rs.next()){
                result.add(new Ingredient(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        }catch(Exception ex){
        }
        return result;
    }

    @Override
    public void addCapacity(Integer capacity, Integer id) {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
           PreparedStatement ps = connection.prepareStatement(SQL_ADD_INGREDIENT_CAPACITY);
            ps.setDouble(1, capacity);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
        }
    }

    @Override
    public void minusCapacity(Integer capacity, Integer id) {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_MINUS_INGREDIENT_CAPACITY);
            ps.setDouble(1, capacity);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
        }
    }

}
