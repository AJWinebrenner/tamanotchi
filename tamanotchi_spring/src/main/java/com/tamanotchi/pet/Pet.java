package com.tamanotchi.pet;

import java.util.Objects;

public class Pet {

    private String name;
    private int house;
    private int type;
    private int happiness;
    private int energy;
    private Mood mood;
    private int exp;
    private int money;

    public Pet(String name, int house, int type, int happiness, int energy, Mood mood, int exp, int money) {
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

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return house == pet.house && type == pet.type && happiness == pet.happiness && energy == pet.energy && exp == pet.exp && money == pet.money && Objects.equals(name, pet.name) && mood == pet.mood;
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
