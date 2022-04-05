package VariantService;

import com.tamanotchi.house.House;
import com.tamanotchi.variant.Variant;
import com.tamanotchi.variant.VariantDAO;
import com.tamanotchi.variant.VariantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class VariantServiceTest {
    private VariantDAO fakeVariantDAO;
    private VariantService underTest;

    @BeforeEach
    void setUp() {
        fakeVariantDAO = mock(VariantDAO.class);
        underTest = new VariantService(fakeVariantDAO);
    }

    @Test
    void selectAllVariants_ReturnsAllVariants() {
        //Given
        Variant variant_1 = new Variant(1,"variant_1", 1,3,10,2);
        Variant variant_2 = new Variant(2,"variant_2", 2,3,10,2);
        List<Variant> variants = new ArrayList<>();
        variants.add(variant_1);
        variants.add(variant_2);

        when(fakeVariantDAO.selectAllVariants()).thenReturn(variants);

        //When
        List<Variant> actual = underTest.selectAllVariants();

        //Then
        assertThat(actual).isEqualTo(variants);
    }

    @Test
    void selectVariantById_ReturnsVariantWithSpecificId() {
        //Given
        Variant variant_1 = new Variant(1, "variant_1", 1, 3, 10, 2);
        Variant variant_2 = new Variant(2, "variant_2", 2, 3, 10, 2);
        when(fakeVariantDAO.selectVariantById(1)).thenReturn(variant_1);

        //When
        Variant actual = underTest.selectVariantById(1);

        //Then
        assertThat(actual).isEqualTo(variant_1);
    }

    @Test
    void selectVariantById_CanThrowVariantNotFoundException() {

        assertThatThrownBy(() -> {
            underTest.selectVariantById(20);}
        ).hasMessage("Variant with id 20 could not be found.");
    }

}
