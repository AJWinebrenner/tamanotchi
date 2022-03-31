package com.tamanotchi.variant;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VariantDataAccessService implements VariantDAO{

    private JdbcTemplate jdbc;

    public VariantDataAccessService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public List<Variant> selectAllVariants() {
        var sql = """
                SELECT id, name, stage, fave_food, max_exp, upgrade FROM variants;
                """;
        return jdbc.query(sql, new VariantMapper());

    }

    @Override
    public Variant selectVariantById(Integer variantId) {
        var sql = """
                SELECT id, name, stage, fave_food, max_exp, upgrade FROM variants WHERE variants.id = ?;
                """;
        try {
            return jdbc.queryForObject(sql, new VariantMapper(), variantId);
        } catch (Exception e){
            return null;
        }
    }
}
