package com.tamanotchi.food;

import java.util.Objects;

public class Food {

    private Integer foodId;
    private String name;
    private Integer price;
    private Integer energy;
    private Integer happiness;
    private boolean isUnhealthy;
    private boolean heals;

    public Food() {
    }

    public Food(Integer foodId, String name, Integer price, Integer energy, Integer happiness, boolean isUnhealthy, boolean heals) {
        this.foodId = foodId;
        this.name = name;
        this.price = price;
        this.energy = energy;
        this.happiness = happiness;
        this.isUnhealthy = isUnhealthy;
        this.heals = heals;
    }



    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
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

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    public boolean isUnhealthy() {
        return isUnhealthy;
    }

    public void setUnhealthy(boolean unhealthy) {
        isUnhealthy = unhealthy;
    }

    public boolean isHeals() {
        return heals;
    }

    public void setHeals(boolean heals) {
        this.heals = heals;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return isUnhealthy == food.isUnhealthy && heals == food.heals && Objects.equals(foodId, food.foodId) && Objects.equals(name, food.name) && Objects.equals(price, food.price) && Objects.equals(energy, food.energy) && Objects.equals(happiness, food.happiness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodId, name, price, energy, happiness, isUnhealthy, heals);
    }


    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", energy=" + energy +
                ", happiness=" + happiness +
                ", isUnhealthy=" + isUnhealthy +
                ", heals=" + heals +
                '}';
    }

}
