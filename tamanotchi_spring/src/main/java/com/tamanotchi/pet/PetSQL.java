package com.tamanotchi.pet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public class PetSQL implements PetDAO{

    private JdbcTemplate jdbc;

    public PetSQL(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Pet> getAll() {

        String sql = "SELECT id, name, house, variant, happiness, energy, mood, exp, money FROM pets";

        return jdbc.query(sql, (rs, rowNum) ->
            new Pet(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("house"),
                rs.getInt("variant"),
                rs.getInt("happiness"),
                rs.getInt("energy"),
                Mood.moodOf(rs.getInt("mood")),
                rs.getInt("exp"),
                rs.getInt("money")
            )
        );
    }

    @Override
    public Pet getById(Integer id) {

        String sql = "SELECT id, name, house, variant, happiness, energy, mood, exp, money FROM pets WHERE id = ?";

        try {
            return jdbc.queryForObject(sql, (rs, rowNum) ->
                new Pet(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("house"),
                    rs.getInt("variant"),
                    rs.getInt("happiness"),
                    rs.getInt("energy"),
                    Mood.moodOf(rs.getInt("mood")),
                    rs.getInt("exp"),
                    rs.getInt("money")
                ),
                id
            );
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int add(Pet pet) {
        String sql = "INSERT INTO pets (name, house, variant, happiness, energy, mood, exp, money) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbc.update(sql,
                pet.getName(),
                pet.getHouse(),
                pet.getVariant(),
                pet.getHappiness(),
                pet.getEnergy(),
                pet.getMood().value(),
                pet.getExp(),
                pet.getMoney()
        );
    }

    @Override
    public int updateById(Integer id, Pet update) {

        String sql = "UPDATE pets SET (name, house, variant, happiness, energy, mood, exp, money)=(?, ?, ?, ?, ?, ?, ?, ?) WHERE id = ?";

        Pet original = getById(id);

        String newName = update.getName();
        if (newName == null) newName = original.getName();
        Integer newHouse = update.getHouse();
        if (newHouse == null) newHouse = original.getHouse();
        Integer newVariant = update.getVariant();
        if (newVariant == null) newVariant = original.getVariant();
        Integer newHappiness = update.getHappiness();
        if (newHappiness == null) newHappiness = original.getHappiness();
        Integer newEnergy = update.getEnergy();
        if (newEnergy == null) newEnergy = original.getEnergy();
        Mood newMood = update.getMood();
        if (newMood == null) newMood = original.getMood();
        Integer newExp = update.getExp();
        if (newExp == null) newExp = original.getExp();
        Integer newMoney = update.getMoney();
        if (newMoney == null) newMoney = original.getMoney();

        return jdbc.update(sql,
                newName,
                newHouse,
                newVariant,
                newHappiness,
                newEnergy,
                newMood.value(),
                newExp,
                newMoney,
                id
        );
    }

    @Override
    public int deleteById(Integer id) {

        String sql = "DELETE FROM pets WHERE id = ?";

        return jdbc.update(sql, id);
    }
}
