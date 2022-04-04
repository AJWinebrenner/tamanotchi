package FoodService;

import com.tamanotchi.food.Food;
import com.tamanotchi.food.FoodDAO;
import com.tamanotchi.food.FoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class FoodServiceTest {

    private FoodDAO fakeFoodDAO;
    private FoodService underTest;

    @BeforeEach
    void setUp() {
        fakeFoodDAO = mock(FoodDAO.class);
        underTest = new FoodService(fakeFoodDAO);
    }

    @Test
    void selectAllFood_ReturnsAllFoods() {
        //Given
        Food testFood = new Food(1,"pizza", 3,4,4,true,true);
        List<Food> foods = Arrays.asList(testFood);
        when(fakeFoodDAO.selectAllFood()).thenReturn(foods);

        //When
        List<Food> actual = underTest.selectAllFood();

        //Then
        assertThat(actual).isEqualTo(foods);
    }


    @Test
    void selectFoodById_ReturnsFoodWithSpecificId() {
        //Given
        Food testFood1 = new Food(1,"pizza", 3,4,4,true,true);
        Food testFood2 = new Food(2,"burger", 3,4,4,true,true);
        when(fakeFoodDAO.selectFoodById(1)).thenReturn(testFood1);

        //When
        Food actual = underTest.selectFoodById(1);

        //Then
        assertThat(actual).isEqualTo(testFood1);
    }

    @Test
    void selectFoodById_CanThrowFoodNotFoundException() {
//        assertThatThrownBy(() -> {
//            underTest.selectFoodById(20);}
//        ).
//    }


    }

}