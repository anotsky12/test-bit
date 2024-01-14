package com.anotsky.testbit.service;

import com.anotsky.testbit.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public Long getHouseId(String request) {

        String[] parts = request.split(",");
        String cityName = parts[0].trim();
        String streetName = parts[1].trim();
        String houseNumber = parts[2].replace("д. ", "").trim();

        return houseRepository.findByCityAndStreetAndHouseNumber(cityName, streetName, houseNumber);
    }
}
