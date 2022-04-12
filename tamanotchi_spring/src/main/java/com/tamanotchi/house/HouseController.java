package com.tamanotchi.house;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {

    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping(path = "houses")
    public List<House> getAllHouses (){
        return houseService.getAllHouses();
    }

    @GetMapping(path = "houses/{id}")
    public House getHouseById(@PathVariable("id") Integer id){
        return houseService.getHouseById(id);
    }
}
