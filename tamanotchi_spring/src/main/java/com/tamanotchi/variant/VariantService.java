package com.tamanotchi.variant;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VariantService {


    private VariantDAO variantDAO;

    public VariantService(@Qualifier("variantSQL") VariantDAO variantDAO) {
        this.variantDAO = variantDAO;
    }

    public List <Variant> getAllVariants() {
        List<Variant> variants = variantDAO.getAll();
        return variants;
    }

    public Variant getVariantById(Integer id) {
        Variant variant = variantDAO.getById(id);
        if (variant == null){
            throw new VariantNotFoundException("Variant with id " + id + " could not be found");
        } else {
            return variant;
        }
    }
}
