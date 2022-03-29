package com.tamanotchi.house;

import java.util.Objects;

public class House {

    private String name;
    private Integer price;
    private Integer happiness_bonuses;
    private Integer size;
    private Integer upgrade;

    public House(String name, Integer price, Integer happiness_bonuses, Integer size, Integer upgrade) {
        this.name = name;
        this.price = price;
        this.happiness_bonuses = happiness_bonuses;
        this.size = size;
        this.upgrade = upgrade;
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

    public Integer getHappiness_bonuses() {
        return happiness_bonuses;
    }

    public void setHappiness_bonuses(Integer happiness_bonuses) {
        this.happiness_bonuses = happiness_bonuses;
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




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(name, house.name) && Objects.equals(price, house.price) && Objects.equals(happiness_bonuses, house.happiness_bonuses) && Objects.equals(size, house.size) && Objects.equals(upgrade, house.upgrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, happiness_bonuses, size, upgrade);
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", happiness_bonuses=" + happiness_bonuses +
                ", size=" + size +
                ", upgrade=" + upgrade +
                '}';
    }





}
