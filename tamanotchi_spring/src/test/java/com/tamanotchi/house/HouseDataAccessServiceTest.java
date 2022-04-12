package com.tamanotchi.house;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class HouseDataAccessServiceTest {

    @Autowired
    HouseSQL underTest;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void selectAllHouses() {
        //Given
        List <House> expected= new ArrayList<>();
        House house1 = new House(1,"mansion",30,2,3,0);
        House house2 = new House(2,"house",20,1,2,1);
        House house3 = new House(3,"bungalow",10,0,1,2);
        expected.add(house1);
        expected.add(house2);
        expected.add(house3);
        //When
        List<House> actual = underTest.getAll();
        //Then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void selectHouseById() {

        //Given
        House expected = new House(1,"mansion",30,2,3,0);

        //When
        House actual = underTest.getById(1);

        //Then
        assertThat(expected).isEqualTo(actual);
    }
}