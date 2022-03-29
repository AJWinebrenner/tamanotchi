package com.tamanotchi.variant;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VariantDataAccessService implements VariantDAO{

    private JdbcTemplate jdbcTemplate;

    public VariantDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Variant> selectAllVariants() {
        var sql = """
                SELECT id, name, stage, fave_food, max_exp, upgrade FROM variants;
                """;
        return jdbcTemplate.query(sql, new VariantMapper());

    }

    @Override
    public Variant selectVariantById(Integer variantId) {
        var sql = """
                SELECT id, name, stage, fave_food, max_exp, upgrade FROM variants WHERE variants.id = ?;
                """;
        try {
            return jdbcTemplate.queryForObject(sql, new VariantMapper(), variantId);
        } catch (Exception e){
            return null;
        }
    }
}
