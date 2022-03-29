package com.tamanotchi.house;

import java.util.Objects;

public class House {

    private Integer id;
    private String name;
    private Integer price;
    private Integer happiness_bonus;
    private Integer size;
    private Integer upgrade;



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

    public Integer getHappiness_bonus() {
        return happiness_bonus;
    }

    public void setHappiness_bonus(Integer happiness_bonus) {
        this.happiness_bonus = happiness_bonus;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Integer upgrade) {
        this.upgrade = upgrade;
    }



    public House() {
    }

    public House(Integer id,String name, Integer price, Integer happiness_bonuses, Integer size, Integer upgrade) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.happiness_bonus = happiness_bonuses;
        this.size = size;
        this.upgrade = upgrade;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", happiness_bonus=" + happiness_bonus +
                ", size=" + size +
                ", upgrade=" + upgrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(id, house.id) && Objects.equals(name, house.name) && Objects.equals(price, house.price) && Objects.equals(happiness_bonus, house.happiness_bonus) && Objects.equals(size, house.size) && Objects.equals(upgrade, house.upgrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, happiness_bonus, size, upgrade);
    }






}
