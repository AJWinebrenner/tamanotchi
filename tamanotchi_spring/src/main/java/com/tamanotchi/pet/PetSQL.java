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
        return 0;
    }

    @Override
    public int updateById(Integer id, Pet update) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}
