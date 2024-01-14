package com.anotsky.testbit.repository;

import com.anotsky.testbit.dto.HouseDTO;
import com.anotsky.testbit.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("SELECT new com.anotsky.testbit.dto.HouseDTO(h.id, h.number, CONCAT(s.name, ', ', h.number, ', ', c.name), COUNT(a.id)) FROM House h LEFT JOIN h.apartments a LEFT JOIN h.street s LEFT JOIN s.city c GROUP BY h.id")
    List<HouseDTO> getHousesWithApartmentCount();

    @Query("SELECT new com.anotsky.testbit.dto.HouseDTO(h.id, h.number, CONCAT(s.name, ', ', h.number, ', ', c.name), COUNT(a.id)) FROM House h LEFT JOIN h.apartments a LEFT JOIN h.street s LEFT JOIN s.city c WHERE s.city.id = :cityId GROUP BY h.id")
    List<HouseDTO> getHousesWithApartmentCountByCity(@Param("cityId") Long cityId);

    @Query("SELECT new com.anotsky.testbit.dto.HouseDTO(h.id, h.number, CONCAT(s.name, ', ', h.number, ', ', c.name), COUNT(a.id)) FROM House h LEFT JOIN h.apartments a LEFT JOIN h.street s LEFT JOIN s.city c WHERE s.id = :streetId GROUP BY h.id")
    List<HouseDTO> getHousesWithApartmentCountByStreet(@Param("streetId") Long streetId);

    @Query("SELECT new com.anotsky.testbit.dto.HouseDTO(h.id, h.number, CONCAT(s.name, ', ', h.number, ', ', c.name), COUNT(a.id)) FROM House h LEFT JOIN h.apartments a LEFT JOIN h.street s LEFT JOIN s.city c WHERE s.city.id = :cityId AND s.id = :streetId GROUP BY h.id")
    List<HouseDTO> getHousesWithApartmentCountByCityAndStreet(@Param("cityId") Long cityId,
                                                              @Param("streetId") Long streetId);

    @Query("SELECT h.id FROM House h JOIN h.street s JOIN s.city c WHERE c.name = :cityName AND s.name = :streetName AND h.number = :houseNumber")
    Long findByCityAndStreetAndHouseNumber(@Param("cityName") String cityName,
                                           @Param("streetName") String streetName,
                                           @Param("houseNumber") String houseNumber);
}
