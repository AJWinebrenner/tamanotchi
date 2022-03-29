package com.tamanotchi.house;

import com.tamanotchi.house.House;
import com.tamanotchi.house.HouseDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private HouseDAO houseDAO;

    public HouseService(HouseDAO houseDAO) {
        this.houseDAO = houseDAO;
    }

    public List<House> selectAllHouses() {
        List<House> houses = houseDAO.selectAllHouses();
        return houses;
    }

    public House selectHouseById(Integer houseId) {
        return houseDAO.selectHouseById(houseId);
    }
}
