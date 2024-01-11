package com.anotsky.testbit.repository;

import com.anotsky.testbit.dto.CityDTO;
import com.anotsky.testbit.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT new com.anotsky.testbit.dto.CityDTO(c.id, c.name, count (h.id)) FROM City c LEFT JOIN c.streets s LEFT JOIN s.houses h GROUP BY c.id")
    List<CityDTO> getCitiesWithHouseCount();

}
