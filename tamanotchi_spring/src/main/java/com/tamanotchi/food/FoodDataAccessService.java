package com.tamanotchi.food;

import com.tamanotchi.house.Food;
import com.tamanotchi.house.FoodDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodDataAccessService implements FoodDAO {

    private JdbcTemplate jdbcTemplate;

    public FoodDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Food> selectAllFood() {
        var sql =

    }

    @Override
    public Food selectFoodById(Integer foodId) {
        var sql =

    }

}
