package com.tamanotchi.variant;

import com.tamanotchi.house.House;
import com.tamanotchi.house.HouseDAO;
import com.tamanotchi.pet.Pet;
import com.tamanotchi.pet.PetNotFoundException;
import com.tamanotchi.variant.Exceptions.VariantNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantService {


    private VariantDAO variantDAO;

    public VariantService(VariantDAO variantDAO) {
        this.variantDAO = variantDAO;
    }

    public List <Variant> selectAllVariants() {
        List<Variant> variants = variantDAO.selectAllVariants();
        return variants;
    }

    public Variant selectVariantById(Integer variantId) {
        Variant variant = variantDAO.selectVariantById(variantId);
            if (variant == null){
                throw new VariantNotFoundException("Variant with id " + variantId + " could not be found.");
            } else {
                return variant;
            }
    }
}
