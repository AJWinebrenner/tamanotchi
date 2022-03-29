package com.tamanotchi.house;

import java.util.Objects;

public class House {

    private String name;
    private int price;
    private int happiness_bonuses;
    private int size;
    private int upgrade;

    //Constructor

    public House(String name, int price, int happiness_bonuses, int size, int upgrade) {
        this.name = name;
        this.price = price;
        this.happiness_bonuses = happiness_bonuses;
        this.size = size;
        this.upgrade = upgrade;
    }

    //Setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHappiness_bonuses() {
        return happiness_bonuses;
    }

    public void setHappiness_bonuses(int happiness_bonuses) {
        this.happiness_bonuses = happiness_bonuses;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(int upgrade) {
        this.upgrade = upgrade;
    }

    //Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return price == house.price && happiness_bonuses == house.happiness_bonuses && size == house.size && upgrade == house.upgrade && Objects.equals(name, house.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, happiness_bonuses, size, upgrade);
    }

  //ToString
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
