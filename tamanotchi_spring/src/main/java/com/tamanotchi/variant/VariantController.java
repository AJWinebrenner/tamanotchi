package com.tamanotchi.variant;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
