package ua.epam.project4.model.dao.entities;

/**
 * Entity for Operation
 *
 * Created by danik on 04.01.2016.
 */
public class Operation {

    private Integer id;
    private String login;
    private String drink;

    public Operation(Integer id, String login, String drink) {
        this.id = id;
        this.login = login;
        this.drink = drink;
    }

    public Operation(String login, String drink) {
        this.login = login;
        this.drink = drink;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}
