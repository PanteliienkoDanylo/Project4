package ua.epam.project4.model.dao.entities;

import java.util.List;

/**
 * Entity for drink
 *
 * Created by danik on 04.01.2016.
 */
public class Drink {

    private Integer id;
    private String name;
    private Integer price;
    private Integer count;
    private Integer capacity;
    private List<DrinkCapacity> drinkCapacityList;

    public Drink(Integer id, String name, Integer price, Integer count, Integer capacity, List<DrinkCapacity> drinkCapacityList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.capacity = capacity;
        this.drinkCapacityList = drinkCapacityList;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<DrinkCapacity> getDrinkCapacityList() {
        return drinkCapacityList;
    }

    public void setDrinkCapacityList(List<DrinkCapacity> drinkCapacityList) {
        this.drinkCapacityList = drinkCapacityList;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", capacity=" + capacity +
                ", capacityList=" + drinkCapacityList +
                '}';
    }
}
