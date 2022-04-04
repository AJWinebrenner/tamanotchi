package HouseService;

import com.tamanotchi.house.House;
import com.tamanotchi.house.HouseDAO;
import com.tamanotchi.house.HouseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class HouseServiceTest {
    private HouseDAO fakeHouseDAO;
    private HouseService underTest;

    @BeforeEach
    void setUp() {
        fakeHouseDAO = mock(HouseDAO.class);
        underTest = new HouseService(fakeHouseDAO);
    }

    @Test
    void selectAllHouses_ReturnsAllHouses() {
        //Given
        House house_1 = new House(1, "house1" , 20 , 3 , 1 , 1);
        House house_2 = new House(2, "house2" , 20 , 3 , 2 , 1);
        List<House> houses = new ArrayList<>();
        houses.add(house_1);
        houses.add(house_2);

        when(fakeHouseDAO.selectAllHouses()).thenReturn(houses);

        //When
        List<House> actual = underTest.selectAllHouses();

        //Then
        assertThat(actual).isEqualTo(houses);
    }

    @Test
    void selectAllHouses_CanThrowHouseNotFoundException() {
        //Given
//        House house_1 = new House(1, "house1" , 20 , 3 , 1 , 1);
//        House house_2 = new House(2, "house2" , 20 , 3 , 2 , 1);
//        List<House> houses = new ArrayList<>();


        when(fakeHouseDAO.selectAllHouses()).thenReturn(null);

//        When
        assertThatThrownBy(() -> {
            underTest.selectAllHouses();}
        ).hasMessage("House not found");
    }

    @Test
    void selectHouseById_ReturnsHouseWithSpecificId() {
        //Given
        House house_1 = new House(1, "house1" , 20 , 3 , 1 , 1);
        House house_2 = new House(2, "house2" , 20 , 3 , 2 , 1);

        when(fakeHouseDAO.selectHouseById(1)).thenReturn(house_1);

        //When
        House actual = underTest.selectHouseById(1);

        //Then
        assertThat(actual).isEqualTo(house_1);
    }

    @Test
    void selectHouseById_CanThrowHouseNotFoundException() {

        assertThatThrownBy(() -> {
            underTest.selectHouseById(20);}
        ).hasMessage("House with id number 20 does not exist");
    }

    }






