package com.tamanotchi.house;

import java.util.List;


public interface HouseDAO {

    List<House> getAll();
    House getById(Integer id);
}
