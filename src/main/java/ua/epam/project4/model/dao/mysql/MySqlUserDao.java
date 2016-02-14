package ua.epam.project4.model.dao.mysql;

import ua.epam.project4.model.dao.UserDao;
import ua.epam.project4.model.dao.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySqlUserDao implements UserDao {

    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM user";
    public static final String SQL_CREATE_USER = "INSERT INTO user (login, pass, balance, isAdmin) VALUES (?, ?, ?, ?)";
    public static final String SQL_ADD_BALANCE_USER = "UPDATE user SET balance = balance + ? WHERE id = ?";
    public static final String SQL_MINUS_BALANCE_USER = "UPDATE user SET balance = balance - ? WHERE id = ?";


    public MySqlUserDao(){
    }


    @Override
    public void createUser(User user) {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_CREATE_USER);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPass());
            ps.setInt(3, user.getBalance());
            ps.setInt(4, user.getIsAdmin());
            ps.executeUpdate();
        }catch (Exception ex){
        }
    }

    @Override
    public User findUserByLoginAndPass(String login, String pass) {
        List<User> userList = findAllUsers();
        for(User u : userList){
            if(u.getLogin().equals(login) && u.getPass().equals(pass)){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> result = new ArrayList<User>();
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery(SQL_FIND_ALL_USERS);
            while(rs.next()){
                result.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        }catch(Exception ex){
        }
        return result;
    }

    @Override
    public void addBalance(Integer balance, Integer id) {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_ADD_BALANCE_USER);
            ps.setInt(1, balance);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
        }
    }

    @Override
    public void minusBalance(Integer balance, Integer id) {
        MySqlConnection mySqlConnection = MySqlConnection.getInstance();
        Connection connection = mySqlConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SQL_MINUS_BALANCE_USER);
            ps.setInt(1, balance);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (Exception ex){
        }
    }

}
