package com.tamanotchi.house;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HouseController {

    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping(path="houses")
    public List<House> getAllHouses (){
        return houseService.selectAllHouses();
    }

    @GetMapping(path ="houses/{id}")
    public House getHouseById(@PathVariable("id") Integer houseId){
        return houseService.selectHouseById(houseId);
    }
}
