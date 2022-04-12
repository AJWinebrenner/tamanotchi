package com.tamanotchi.house;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("houseSQL")
public class HouseSQL implements HouseDAO{

    private JdbcTemplate jdbc;

    public HouseSQL(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<House> getAll() {

        String sql = "SELECT id, name, price, happiness_bonus, size, upgrade FROM houses";
       
        return jdbc.query(sql, (rs, rowNum) ->
            new House(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getInt("happiness_bonus"),
                rs.getInt("size"),
                rs.getInt("upgrade")
            )
        );
    }

    @Override
    public House getById(Integer id) {
        
        String sql = "SELECT id, name, price, happiness_bonus, size, upgrade FROM houses WHERE houses.id = ?";
        
        try{
            return jdbc.queryForObject(sql, (rs, rowNum) ->
                new House(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("price"),
                    rs.getInt("happiness_bonus"),
                    rs.getInt("size"),
                    rs.getInt("upgrade")
                ), 
                id
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
}
