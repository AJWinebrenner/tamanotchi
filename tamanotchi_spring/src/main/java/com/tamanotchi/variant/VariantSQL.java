package com.tamanotchi.variant;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("variantSQL")
public class VariantSQL implements VariantDAO{

    private JdbcTemplate jdbc;

    public VariantSQL(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Variant> getAll() {

        String sql = "SELECT id, name, stage, fave_food, max_exp, upgrade FROM variants";
        return jdbc.query(sql, new VariantMapper());
    }

    @Override
    public Variant getById(Integer id) {
        String sql = "SELECT id, name, stage, fave_food, max_exp, upgrade FROM variants WHERE variants.id = ?";
        
        try {
            return jdbc.queryForObject(sql, new VariantMapper(), id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
