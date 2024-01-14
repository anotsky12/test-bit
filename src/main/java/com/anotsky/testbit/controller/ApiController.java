package com.anotsky.testbit.controller;

import com.anotsky.testbit.dto.CityDTO;
import com.anotsky.testbit.dto.HouseDTO;
import com.anotsky.testbit.dto.StreetDTO;
import com.anotsky.testbit.repository.ApartmentRepository;
import com.anotsky.testbit.repository.CityRepository;
import com.anotsky.testbit.repository.HouseRepository;
import com.anotsky.testbit.repository.StreetRepository;
import com.anotsky.testbit.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {


    private final HouseService houseService;

    private final CityRepository cityRepository;

    private final StreetRepository streetRepository;

    private final HouseRepository houseRepository;

    private final ApartmentRepository apartmentRepository;

    public ApiController(HouseService houseService, CityRepository cityRepository, StreetRepository streetRepository, HouseRepository houseRepository, ApartmentRepository apartmentRepository) {
        this.houseService = houseService;
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
        this.houseRepository = houseRepository;
        this.apartmentRepository = apartmentRepository;
    }

    // 1. Перечень городов с указанием количества домов
    @GetMapping("/cities")
    public List<CityDTO> getCitiesWithHouseCount() {
        return cityRepository.getCitiesWithHouseCount();
    }

    // 2. Перечень улиц с указанием количества домов с запросом по городу
    @GetMapping("/streets")
    public List<StreetDTO> getStreetsWithHouseCount(@RequestParam(required = false) Long city_id) {
        if (city_id != null) {
            return streetRepository.getStreetsWithHouseCountByCity(city_id);
        } else {
            return streetRepository.getStreetsWithHouseCount();
        }
    }

    // 3. Перечень домов с указанием полного адреса и количества квартир
    //    с запросом по конкретной улице / городу
    @GetMapping("/houses")
    public List<HouseDTO> getHousesWithApartmentCount(
            @RequestParam(required = false) Long city_id,
            @RequestParam(required = false) Long street_id) {

        if (city_id != null && street_id != null) {
            return houseRepository.getHousesWithApartmentCountByCityAndStreet(city_id, street_id);
        } else if (city_id != null) {
            return houseRepository.getHousesWithApartmentCountByCity(city_id);
        } else if (street_id != null) {
            return houseRepository.getHousesWithApartmentCountByStreet(street_id);
        } else {
            return houseRepository.getHousesWithApartmentCount();
        }
    }

    //4. Индентификатор дома по полному адрессу
    @GetMapping("/house/search")
    public ResponseEntity<?> getHouse(@RequestParam("query") String request) {
        Long houseId = houseService.getHouseId(request);
        if (houseId != null) {
            return new ResponseEntity<>(houseId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}