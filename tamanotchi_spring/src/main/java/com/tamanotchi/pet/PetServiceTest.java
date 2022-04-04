package com.tamanotchi.pet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class PetServiceTest {

    private PetDAO fakePetDao;
    private PetService underTest;

    @BeforeEach
    void setUp() {
        fakePetDao = mock(PetDAO.class);
        underTest = new PetService(fakePetDao);
    }

    @Test
    void getAllPets_ReturnsAllPets() {
        // Given
        Pet pet = new Pet(4, "Bob", 1, 1, 5, 5, 5, 1, 1);
        List<Pet> pets = Arrays.asList(pet);
        when(fakePetDao.getAllPets()).thenReturn(pets);

        // When
        List<Pet> actual = underTest.getAllPets();

        // Then
        assertThat(actual).isEqualTo(pets);
    }








    @org.junit.jupiter.api.Test
    void getPetById() {
    }

    @org.junit.jupiter.api.Test
    void addNewPet() {
    }

    @org.junit.jupiter.api.Test
    void updatePetById() {
    }

    @org.junit.jupiter.api.Test
    void deletePetById() {
    }

    @org.junit.jupiter.api.Test
    void upgradeHouse() {
    }

    @org.junit.jupiter.api.Test
    void feedPet() {
    }

    @org.junit.jupiter.api.Test
    void isDead() {
    }

    @org.junit.jupiter.api.Test
    void gameWon() {
    }

    @org.junit.jupiter.api.Test
    void updateMood() {
    }

    @org.junit.jupiter.api.Test
    void giveExp() {
    }

    @org.junit.jupiter.api.Test
    void timeStep() {
    }
}