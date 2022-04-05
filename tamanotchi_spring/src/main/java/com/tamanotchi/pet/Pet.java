package com.tamanotchi.pet;

import java.util.Objects;

public class Pet {

    private Integer id;
    private String name;
    private Integer house;
    private Integer variant;
    private Integer happiness;
    private Integer energy;
    private Integer max_happiness;
    private Integer max_energy;
    private Integer mood;
    private Integer exp;
    private Integer money;
    static boolean hasEatenUnhealthy;

    public Pet() {
    }

    public Pet(Integer id, String name, Integer house, Integer variant, Integer happiness, Integer energy, Integer mood, Integer exp, Integer money) {
        this.id = id;
        this.name = name;
        this.house = house;
        this.variant = variant;
        this.happiness = happiness;
        this.energy = energy;
        this.max_happiness = 10;
        this.max_energy = 10;
        this.mood = mood;
        this.exp = exp;
        this.money = money;
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

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getVariant() {
        return variant;
    }

    public void setVariant(Integer variant) {
        this.variant = variant;
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

    public Integer getMax_happiness() {
        return max_happiness;
    }

    public void setMax_happiness(Integer max_happiness) {
        this.max_happiness = max_happiness;
    }

    public Integer getMax_energy() {
        return max_energy;
    }

    public void setMax_energy(Integer max_energy) {
        this.max_energy = max_energy;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
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
        return Objects.equals(id, pet.id) && Objects.equals(name, pet.name) && Objects.equals(house, pet.house) && Objects.equals(variant, pet.variant) && Objects.equals(happiness, pet.happiness) && Objects.equals(energy, pet.energy) && mood == pet.mood && Objects.equals(exp, pet.exp) && Objects.equals(money, pet.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, house, variant, happiness, energy, mood, exp, money);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", house=" + house +
                ", variant=" + variant +
                ", happiness=" + happiness +
                ", energy=" + energy +
                ", max_happiness=" + max_happiness +
                ", max_energy=" + max_energy +
                ", mood=" + mood +
                ", exp=" + exp +
                ", money=" + money +
                '}';
    }
}
