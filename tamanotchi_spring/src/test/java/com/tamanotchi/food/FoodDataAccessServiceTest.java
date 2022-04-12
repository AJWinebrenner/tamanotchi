package com.tamanotchi.food;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodDataAccessServiceTest {

    @Autowired
    private FoodSQL underTest;

    @Test
    void selectAllFood() {
        List<Food> expected = new ArrayList<>();
        Food food1 = new Food(1,"medicine", 8,0,0,false,true);
        Food food2 = new Food(2,"carrot", 2,3,0,false,false);
        expected.add(food1);
        expected.add(food2);
        //When
        List <Food> actual = underTest.getAll();
        //Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void selectFoodById() {
        //Given
        Food expected = new Food(1,"medicine", 8,0,0,false,true);

        //When
        Food actual = underTest.getById(1);

        //Then
        assertThat(actual).isEqualTo(expected);
    }
}