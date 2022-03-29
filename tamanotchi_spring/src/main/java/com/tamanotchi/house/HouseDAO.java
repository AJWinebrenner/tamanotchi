package com.tamanotchi.house;

import java.util.List;


public interface HouseDAO {

    List<House> selectAllHouses();
    House selectHouseById(Integer houseId);
}
