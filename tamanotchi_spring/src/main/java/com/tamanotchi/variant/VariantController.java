package com.tamanotchi.variant;


import com.tamanotchi.house.House;
import com.tamanotchi.house.HouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VariantController {

    private VariantService variantService;

    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @GetMapping(path="variants")
    public List<Variant> getAllVariants(){
        return variantService.selectAllVariants();
    }

    @GetMapping(path ="variants/{id}")
    public Variant getVariantById(@PathVariable("id") Integer variantId){
        return variantService.selectVariantById(variantId);
    }
}
