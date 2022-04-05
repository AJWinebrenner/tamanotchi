package PetService;

import com.tamanotchi.food.Food;
import com.tamanotchi.house.House;
import com.tamanotchi.pet.*;
import com.tamanotchi.variant.Variant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void getPetById_ReturnsPetWhenIdExists() {
        // GIVEN
        Pet pet= new Pet(1, "Bob", 1, 1, 5, 5, 5, 1, 1);;
        List<Pet> pets = Arrays.asList(pet);
        when(fakePetDao.getAllPets()).thenReturn(pets);
        when(fakePetDao.getById(1)).thenReturn(pet);

        // WHEN
        Pet actual = underTest.getPetById(1);
        Pet expected = pet;

        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(fakePetDao, times(1)).getById(captor.capture());
        Integer capturedParameter = captor.getValue();

        // THEN
        verify(fakePetDao).getById(1);
        assertEquals(1, capturedParameter);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getPetById_ThrowsErrorWhenPetIdDoesNotExists() {
        // GIVEN
        when(fakePetDao.getById(0)).thenReturn(null);
        // WHEN
        assertThatThrownBy(() -> {
            underTest.getPetById(0);
            // THEN
        }).isInstanceOf(PetNotFoundException.class)
                .hasMessage("Pet with id 0 could not be found");
        verify(fakePetDao).getById(0);
    }

    @Test
    void addNewPet_AddsNewPetWhenFieldsAreCorrect() {
        // GIVEN
        Pet pet1 = new Pet(1, "Bob", 1, 1, 5, 5, 5, 1, 1);
        Pet pet2 = new Pet(12, "Melissa", 1, 1, 5, 5, 5, 1, 1);
        List<Pet> pets = Arrays.asList(pet1);
        when(fakePetDao.getAllPets()).thenReturn(pets);
        when(fakePetDao.add(pet2)).thenReturn(1);

        // WHEN
        underTest.addNewPet(pet2);

        // THEN
        verify(fakePetDao).add(pet2);
    }

    @Test
    void updatePetById_UpdatesPetWhenIdExists() {
        // GIVEN
        Pet pet = new Pet(1, "Bob", 1, 1, 5, 5, 5, 1, 1);
        Pet pet_update = new Pet(null, "Jane", null, null, null, null, null, null, null);
        when(fakePetDao.getById(1)).thenReturn(pet);
        when(fakePetDao.updateById(1, pet_update)).thenReturn(1);

        // WHEN
        underTest.updatePetById(1, pet_update);

        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(fakePetDao, times(1)).getById(captor.capture());
        Integer capturedParameter = captor.getValue();

        // THEN
        assertEquals(1, capturedParameter);
        verify(fakePetDao).updateById(1, pet_update);
    }

    @Test
    void deletePetById_CanDeletePetWhenIdIsCorrect() {
        // GIVEN
        Pet pet = new Pet(1, "Bob", 1, 1, 5, 5, 5, 1, 1);
        when(fakePetDao.getById(1)).thenReturn(pet);
        when(fakePetDao.deleteById(1)).thenReturn(1);

        // WHEN
        underTest.deletePetById(1);

        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

        verify(fakePetDao, times(1)).deleteById(captor.capture());
        Integer capturedDeleteParameter = captor.getValue();

        verify(fakePetDao, times(1)).getById(captor.capture());
        Integer capturedGetParameter = captor.getValue();

        // THEN
        assertEquals(1, capturedGetParameter);
        assertEquals(1, capturedDeleteParameter);
        verify(fakePetDao).deleteById(1);
    }

    @Test
    void upgradeHouse_CanUpgradeHouseWhenPetIdIsCorrect() {
        // GIVEN
        Pet pet= new Pet(1, "Bob", 1, 1, 5, 5, 5, 1, 100);;
        Pet petAfterPurchase = new Pet(1, "Bob", 2, 1, 5, 5, 5, 4, 90);
        List<Pet> pets = Arrays.asList(pet);
        // finding the correct pet
        when(fakePetDao.getAllPets()).thenReturn(pets);
        when(fakePetDao.getById(1)).thenReturn(pet);
        // finding the correct house to upgrade to
        when(fakePetDao.selectHouseById(1)).thenReturn(new House(1, "Bigger", 10, 1, 1, 2));
        when(fakePetDao.selectHouseById(2)).thenReturn(new House(2, "Biggest", 10, 1, 1, 3));
        // returning the correct variant
        when(fakePetDao.selectVariantById(1)).thenReturn(new Variant("variant", 1, 2, 500, 3));
        // return 1 when DAO is called to update
        when(fakePetDao.updateById(1, petAfterPurchase)).thenReturn(1);

        // WHEN
        underTest.upgradeHouse(1);

        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(fakePetDao, times(1)).getById(captor.capture());
        Integer capturedPetIdParameter = captor.getValue();

        // capturing multiple calls to same DAO method
        verify(fakePetDao, times(2)).selectHouseById(captor.capture());
        List<Integer> capturedHouseIdParameter = captor.getAllValues();
        //System.out.println(capturedHouseIdParameter);

        // THEN
        verify(fakePetDao).getById(1);
        verify(fakePetDao).selectHouseById(1);
        verify(fakePetDao).selectHouseById(2);
        verify(fakePetDao).updateById(1, petAfterPurchase);
        assertEquals(1, capturedPetIdParameter);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,1,2));
        assertEquals(expected, capturedHouseIdParameter);
    }

    @Test
    void feedPet_CanUpdatePetWhenIdsOfFoodAndPetAreCorrect() {
        // GIVEN
        Pet pet= new Pet(1, "Bob", 1, 1, 5, 5, 3, 1, 100);
        Pet petAfterEating = new Pet(1, "Bob", 1, 1, 10, 10, 2, 2, 99);
        Food food = new Food(1, "PIZZA", 1, 20, 20, false, false);
        Variant variant = new Variant("variant", 1, 2, 500, 2);

        when(fakePetDao.getById(1)).thenReturn(pet);
        when(fakePetDao.selectFoodById(1)).thenReturn(food);
        when(fakePetDao.selectVariantById(1)).thenReturn(variant);
        when(fakePetDao.updateById(1, petAfterEating)).thenReturn(1);

        // WHEN
        underTest.feedPet(1, 1);

        // THEN
        verify(fakePetDao).updateById(1, petAfterEating);
    }

    @Test
    void isDead_ReturnsTrueWhenPetIdIsCorrectAndDead() {
        // GIVEN
        Pet pet= new Pet(1, "Bob", 1, 1, 5, 5, 5, 1, 100);
        when(fakePetDao.getById(1)).thenReturn(pet);

        // WHEN
        Boolean actual = underTest.isDead(1);
        Boolean expected = true;

        // THEN
        assertEquals(actual, expected);
    }

    @Test
    void isDead_ReturnsFalseWhenPetIdIsCorrectAndAlive() {
        // GIVEN
        Pet pet= new Pet(1, "Bob", 1, 1, 5, 5, 3, 1, 100);
        when(fakePetDao.getById(1)).thenReturn(pet);

        // WHEN
        Boolean actual = underTest.isDead(1);
        Boolean expected = false;

        // THEN
        assertEquals(actual, expected);
    }

    @Test
    void gameWon_UpdatesPetMoneyAndExpWhenPetExistsAndExpIsNumber() {
        // GIVEN
        Pet pet= new Pet(1, "Bob", 1, 1, 5, 5, 3, 1, 100);
        Pet updated= new Pet(1, "Bob", 1, 1, 5, 5, 3, 3, 110);
        Variant variant = new Variant(1, "variant", 1, 2, 500, 2);
        when(fakePetDao.getById(1)).thenReturn(pet);
        when(fakePetDao.selectVariantById(1)).thenReturn(variant);
        when(fakePetDao.updateById(1, updated)).thenReturn(1);

        // WHEN
        underTest.gameWon(1);

        // THEN
        verify(fakePetDao).updateById(1, updated);
    }

    @Test
    void updateMood_UpdatesMoodWhenPetExists() {
        // GIVEN
        Pet pet = new Pet(1, "Bob", 1, 1, 10, 10, 3, 1, 100);
        Variant variant = new Variant("variant", 1, 2, 500, 2);
        House house = new House(1, "Bigger", 10, 1, 1, 2);

        when(fakePetDao.selectVariantById(1)).thenReturn(variant);
        when(fakePetDao.selectHouseById(1)).thenReturn(house);


        // WHEN
        underTest.updateMood(pet);
        Integer actual = pet.getMood();
        Integer expected = 2;

        // THEN
        assertEquals(actual, expected);
    }

    @Test
    void giveExp_UpdatesExpWhenPetExists() {
        // GIVEN
        Pet pet = new Pet(1, "Bob", 1, 1, 10, 10, 3, 1, 100);
        Variant variant = new Variant(1, "variant", 1, 2, 500, 2);
        when(fakePetDao.selectVariantById(1)).thenReturn(variant);


        // WHEN
        underTest.giveExp(pet, 1);

        Pet expected = new Pet(1, "Bob", 1, 1, 10, 10, 3, 2, 100);
        Pet actual = pet;

        // THEN
        assertEquals(actual, expected);
    }

    @Test
    void timeStep_UpdatesPetWhenIdIsCorrect() {
        // GIVEN
        Pet pet = new Pet(1, "Bob", 1, 1, 10, 10, 3, 1, 100);
        Pet expected = new Pet(1, "Bob", 1, 1, 9, 9, 2, 2, 100);
        Variant variant = new Variant("variant", 1, 2, 500, 2);
        House house = new House(1, "Bigger", 10, 1, 1, 2);
        when(fakePetDao.getById(1)).thenReturn(pet);
        when(fakePetDao.selectVariantById(1)).thenReturn(variant);
        when(fakePetDao.selectHouseById(1)).thenReturn(house);
        when(fakePetDao.updateById(1, expected)).thenReturn(1);

        // WHEN
        underTest.timeStep(1);
        Pet actual = pet;

        System.out.println(actual);
        System.out.println(expected);

        // THEN
        assertEquals(actual, expected);
    }
}