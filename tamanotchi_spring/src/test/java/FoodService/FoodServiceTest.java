package FoodService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.tamanotchi.food.Food;
import com.tamanotchi.food.FoodDAO;
import com.tamanotchi.food.FoodService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FoodServiceTest {

    private FoodDAO fakeFoodDAO;
    private FoodService underTest;

    @BeforeEach
    void setUp() {
        fakeFoodDAO = mock(FoodDAO.class);
        underTest = new FoodService(fakeFoodDAO);
    }

    @Test
    void getAllFood_ReturnsAllFoods() {
        //Given
        Food testFood = new Food(1,"pizza", 3,4,4,true,true);
        List<Food> foods = Arrays.asList(testFood);
        when(fakeFoodDAO.getAll()).thenReturn(foods);

        //When
        List<Food> actual = underTest.getAllFood();

        //Then
        assertThat(actual).isEqualTo(foods);
    }

    @Test
    void getFoodById_ReturnsFoodWithSpecificId() {
        //Given
        Food testFood1 = new Food(1,"pizza", 3,4,4,true,true);

        when(fakeFoodDAO.getById(1)).thenReturn(testFood1);

        //When
        Food actual = underTest.getFoodById(1);

        //Then
        assertThat(actual).isEqualTo(testFood1);
    }

    @Test
    void getFoodById_CanThrowFoodNotFoundException() {

        assertThatThrownBy(() -> {
            underTest.getFoodById(20);}
        ).hasMessage("Food with id number 20 could not be found");
    }


    }

