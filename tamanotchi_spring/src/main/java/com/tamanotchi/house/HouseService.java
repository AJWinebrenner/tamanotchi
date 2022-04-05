package com.tamanotchi.house;


import com.tamanotchi.pet.Pet;
import com.tamanotchi.pet.PetNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;

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
