package com.tamanotchi.house;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDataAccessService implements HouseDAO{

    private  JdbcTemplate jdbcTemplate;

    public HouseDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<House> selectAllHouses() {
        var sql = """
                SELECT name, price, happiness_bonus, size, upgrade FROM houses
                """;
        return jdbcTemplate.query(sql, new HouseMapper());

    }

    @Override
    public House selectHouseById(Integer houseId) {
        var sql = """
                SELECT name, price, happiness_bonus, size, upgrade FROM houses WHERE houses.id = ?;
                """;
        return jdbcTemplate.queryForObject(sql, new HouseMapper(), houseId);
    }

}
