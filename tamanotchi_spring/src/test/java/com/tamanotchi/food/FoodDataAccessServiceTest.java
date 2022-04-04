package com.tamanotchi.food;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodDataAccessServiceTest {

    @Autowired
    private FoodDataAccessService underTest;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void selectAllFood() {
        List<Food> expected = new ArrayList<>();
        Food food1 = new Food(1,"medicine", 8,0,0,false,true);
        Food food2 = new Food(2,"carrot", 2,3,0,false,false);
        expected.add(food1);
        expected.add(food2);
        //When
        List <Food> actual = underTest.selectAllFood();
        //Then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void selectFoodById() {
        //Given

        //When

        //Then
    }
}