package com.tamanotchi.variant;
import java.util.List;

public interface VariantDAO {

    List<Variant> selectAllVariants();
    Variant selectVariantById(Integer variantId);
}
