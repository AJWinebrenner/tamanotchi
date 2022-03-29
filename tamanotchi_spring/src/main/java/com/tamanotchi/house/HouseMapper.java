package com.tamanotchi.house;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class HouseMapper implements org.springframework.jdbc.core.RowMapper<House> {

    //SELECT name, price, happiness_bonus, size, upgrade FROM houses
    @Override
    public House mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new House(
                rs.getString("name"),
                rs.getInt("price"),
                rs.getInt("happiness_bonus"),
                rs.getInt("size"),
                rs.getInt("upgrade")
                );
    }
}
