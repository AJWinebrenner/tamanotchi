package com.tamanotchi.house;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private HouseDAO houseDAO;

    public HouseService(@Qualifier("houseSQL") HouseDAO houseDAO) {
        this.houseDAO = houseDAO;
    }

    public List<House> getAllHouses() {
        return houseDAO.getAll();
    }

    public House getHouseById(Integer id) {
        House selected= houseDAO.getById(id);
        if (selected == null){
            throw new HouseNotFoundException("House with id number " + id + " could not be found");
        }else{
            return selected;
        }
    }

}
