package ua.epam.project4.model.dao.entities;

/**
 * Help class for entity Drink
 *
 * Created by danik on 27.01.2016.
 */
public class DrinkCapacity {
    private Integer id;
    private Integer capacity;

    public DrinkCapacity(Integer id, Integer capacity){
        this.id = id;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Capacity{" +
                "id=" + id +
                ", capacity=" + capacity +
                '}';
    }
}
