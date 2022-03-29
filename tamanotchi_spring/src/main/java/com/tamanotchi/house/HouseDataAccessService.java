package com.tamanotchi.house;

import com.tamanotchi.pet.Mood;
import com.tamanotchi.pet.Pet;
import org.springframework.dao.EmptyResultDataAccessException;
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
                SELECT id, name, price, happiness_bonus, size, upgrade FROM houses
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new House(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("happiness_bonus"),
                        rs.getInt("size"),
                        rs.getInt("upgrade")
                ));

    }
    @Override
    public House selectHouseById(Integer houseId) {
        var sql = """
                SELECT id, name, price, happiness_bonus, size, upgrade FROM houses WHERE houses.id = ?;
                """;
        try{
            return jdbcTemplate.queryForObject(sql,(rs, rowNum) ->
                    new House(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getInt("happiness_bonus"),
                            rs.getInt("size"),
                            rs.getInt("upgrade")
                    ), houseId);

        }catch(EmptyResultDataAccessException e){
            return null;
        }

    }

}
