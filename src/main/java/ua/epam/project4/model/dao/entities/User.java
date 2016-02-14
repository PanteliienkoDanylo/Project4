package ua.epam.project4.model.dao.entities;

/**
 * Entity for User
 *
 * Created by danik on 04.01.2016.
 */
public class User {

    private Integer id;
    private String login;
    private String pass;
    private Integer balance;
    private Integer isAdmin;

    public User(Integer id, String login, String pass, Integer balance, Integer isAdmin) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }

    public User(String login, String pass){
        this.login = login;
        this.pass = pass;
        balance = 0;
        isAdmin = 0;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", balance=" + balance +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
