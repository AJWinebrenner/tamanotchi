package com.tamanotchi.house;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private HouseDAO houseDAO;

    public HouseService(HouseDAO houseDAO) {
        this.houseDAO = houseDAO;
    }

    public List<House> selectAllHouses() {
        List<House> selected = houseDAO.selectAllHouses();
        if (selected == null){
            throw new HouseNotFoundException("Houses not found");
        }else{
            return selected;
        }
    }

    public House selectHouseById(Integer houseId) {
        House selected= houseDAO.selectHouseById(houseId);
        if (selected == null){
            throw new HouseNotFoundException("House with id number "+ houseId + " does not exist");
        }else{
            return selected;
        }

    }



}
