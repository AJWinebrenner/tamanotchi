package com.tamanotchi.food;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("foodSQL")
public class FoodSQL implements FoodDAO {

    private JdbcTemplate jdbc;

    public FoodSQL(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Food> getAll() {

        String sql = "SELECT id, name, price, energy, happiness, isUnhealthy, heals FROM foods";

        return jdbc.query(sql, (rs, rowNum) ->
            new Food(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getInt("energy"),
                rs.getInt("happiness"),
                rs.getBoolean("isUnhealthy"),
                rs.getBoolean("heals")
            )
        );
    }

    @Override
    public Food getById(Integer id) {

        String sql = "SELECT id, name, price, energy, happiness, isUnhealthy, heals FROM foods WHERE id = ?";

        try {
            return jdbc.queryForObject(sql, (rs, rowNum) ->
                new Food(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("price"),
                    rs.getInt("energy"),
                    rs.getInt("happiness"),
                    rs.getBoolean("isUnhealthy"),
                    rs.getBoolean("heals")
                ),
                id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}