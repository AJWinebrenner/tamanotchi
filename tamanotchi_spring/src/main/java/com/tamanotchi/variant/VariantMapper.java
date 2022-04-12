package com.tamanotchi.variant;

import java.sql.ResultSet;
import java.sql.SQLException;


public class VariantMapper implements org.springframework.jdbc.core.RowMapper<Variant> {

    //SELECT id, name, stage, fave_food, max_exp, upgrade FROM variants

    @Override
    public Variant mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            return new Variant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("stage"),
                    rs.getInt("fave_food"),
                    rs.getInt("max_exp"),
                    rs.getInt("upgrade")
            );
        } catch (Exception e){
            return null;
        }
    }
}
