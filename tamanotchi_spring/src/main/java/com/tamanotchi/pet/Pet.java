package com.tamanotchi.pet;

import java.util.Objects;

public class Pet {

    private String name;
    private Integer house;
    private Integer type;
    private Integer happiness;
    private Integer energy;
    private Mood mood;
    private Integer exp;
    private Integer money;

    public Pet(String name, Integer house, Integer type, Integer happiness, Integer energy, Mood mood, Integer exp, Integer money) {
        this.name = name;
        this.house = house;
        this.type = type;
        this.happiness = happiness;
        this.energy = energy;
        this.mood = mood;
        this.exp = exp;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) && Objects.equals(house, pet.house) && Objects.equals(type, pet.type) && Objects.equals(happiness, pet.happiness) && Objects.equals(energy, pet.energy) && mood == pet.mood && Objects.equals(exp, pet.exp) && Objects.equals(money, pet.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, house, type, happiness, energy, mood, exp, money);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", house=" + house +
                ", type=" + type +
                ", happiness=" + happiness +
                ", energy=" + energy +
                ", mood=" + mood +
                ", exp=" + exp +
                ", money=" + money +
                '}';
    }
}
