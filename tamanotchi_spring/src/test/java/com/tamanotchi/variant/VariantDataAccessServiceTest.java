package com.tamanotchi.variant;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class VariantDataAccessServiceTest {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private VariantDataAccessService underTest;

    @Test
    void selectAllVariants() {
        //Given
        Variant variant1 = new Variant(1,"impeckable",3,5,40,0);
        Variant variant2= new Variant(2, "nugget",2, 4, 25, 1);
        List<Variant> variants= new ArrayList<>();
        variants.add(variant1);
        variants.add(variant2);

        //When
        List <Variant>actual = underTest.selectAllVariants();

        //Then
        assertThat(actual).isEqualTo(variants);
    }

    @Test
    void selectVariantById() {
        //Given
        Variant expected = new Variant(1,"impeckable",3,5,40,0);

        //When
        Variant actual= underTest.selectVariantById(1);


        //Then
        assertThat(actual).isEqualTo(expected);
    }
}