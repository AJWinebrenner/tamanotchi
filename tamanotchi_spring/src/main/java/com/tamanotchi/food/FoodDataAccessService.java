package com.tamanotchi.food;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("name")
public class FoodDataAccessService implements FoodDAO {

    private JdbcTemplate jdbc;

    public FoodDataAccessService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Food> selectAllFood() {
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
    public Food selectFoodById(Integer foodId) {

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
                    foodId
            );

        } catch (Exception e) {
            return null;
        }
    }

//    @Override
//    public int addFood(Food food) {
//        return 0;
//    }
//
//    @Override
//    public int updateFoodById(Integer id, Food update) {
//        return 0;
//    }
//
//    @Override
//    public int deleteFoodById(Integer id) {
//        return 0;
//    }
}
