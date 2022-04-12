package com.tamanotchi.variant;

import java.util.List;

import org.springframework.stereotype.Service;

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
