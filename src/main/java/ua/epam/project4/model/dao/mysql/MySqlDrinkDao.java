package ua.epam.project4.model.dao.mysql;

import ua.epam.project4.model.dao.DrinkDao;
import ua.epam.project4.model.dao.entities.DaoFactory;
import ua.epam.project4.model.dao.entities.DrinkCapacity;
import ua.epam.project4.model.dao.entities.Drink;
import ua.epam.project4.model.dao.entities.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MySqlDrinkDao implements DrinkDao {

    public static final String SQL_FIND_ALL_DRINKS = "SELECT * FROM drink";
    public static final String SQL_GET_DRINK_CAPACITY = "SELECT ingredient_id , capacity FROM drink_ingredient WHERE drink_id = ?";
    public static final String SQL_MINUS_COUNT_DRINK = "UPDATE drink SET count = count - 1 WHERE id = ?";
    public static final String SQL_UPDATE_COUNT_DRINK = "UPDATE drink SET count = ? WHERE id = ?";

    @Override
    public List<Drink> findAllDrinks() {
        List<Drink> result = new ArrayList<Drink>();
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_DRINKS);
            while(rs.next()){
                result.add(new Drink(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), getDrinkCapacity(rs.getInt(1))));
            }
        }catch(Exception ex){
        }
        return result;
    }

    @Override
    public List<DrinkCapacity> getDrinkCapacity(Integer id){
        List<DrinkCapacity> result = new ArrayList<DrinkCapacity>();
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_GET_DRINK_CAPACITY);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                result.add(new DrinkCapacity(rs.getInt(1), rs.getInt(2)));
            }
        }catch(Exception ex){
        }
        return result;
    }

    @Override
    public Drink findDrinkById(Integer id) {
        List<Drink> drinkList = findAllDrinks();
        for(Drink d : drinkList){
            if(d.getId().equals(id)){
                return d;
            }
        }
        return null;
    }

    @Override
    public void minusCount(Integer id){
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_MINUS_COUNT_DRINK);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (Exception ex){
        }
    }

    @Override
    public void updateAllCount(){
        List<Ingredient> ingredientList = DaoFactory.getInstance().createIngredientDao().findAllIngredients();
        List<Drink> drinkList = findAllDrinks();
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try {
            for (Drink d : drinkList) {
                PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_COUNT_DRINK);
                ps.setInt(1, findMin(getCountByDrinkCapacity(ingredientList, d.getId())));
                ps.setInt(2 , d.getId());
                ps.executeUpdate();
            }
        }catch (Exception ex){
        }
    }

    private List<Integer> getCountByDrinkCapacity(List<Ingredient> ingredientList, Integer id){
        List<Integer> result = new ArrayList<Integer>();
        List<Drink> drinkList = findAllDrinks();
        for (int i = 0; i < ingredientList.size(); i++) {
            for (int j = 0; j < drinkList.get(id - 1).getDrinkCapacityList().size(); j++) {
                if (ingredientList.get(i).getId() == drinkList.get(id - 1).getDrinkCapacityList().get(j).getId()) {
                    result.add(ingredientList.get(i).getCapacity() / drinkList.get(id - 1).getDrinkCapacityList().get(j).getCapacity());
                }
            }
        }
        return result;
    }

    private Integer findMin(List<Integer> list){
        int min = Integer.MAX_VALUE;
        if(list.size() == 0){
            return 0;
        }
        if(list.size() == 1){
            return list.get(0);
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) < min){
                min = list.get(i);
            }
        }
        return min;
    }



}
