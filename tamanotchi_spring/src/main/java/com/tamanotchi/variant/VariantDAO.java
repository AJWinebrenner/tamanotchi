package com.tamanotchi.variant;
import java.util.List;

public interface VariantDAO {

    List<Variant> getAll();
    Variant getById(Integer id);
}
