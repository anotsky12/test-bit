package com.anotsky.testbit.repository;

import com.anotsky.testbit.dto.StreetDTO;
import com.anotsky.testbit.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Long> {

    @Query("SELECT new com.anotsky.testbit.dto.StreetDTO(s.id, s.name, COUNT(h.id)) FROM Street s LEFT JOIN s.houses h GROUP BY s.id, s.name")
    List<StreetDTO> getStreetsWithHouseCount();

    @Query("SELECT new com.anotsky.testbit.dto.StreetDTO(s.id, s.name, COUNT(h.id)) FROM Street s LEFT JOIN s.houses h WHERE s.city.id = :cityId GROUP BY s.id")
    List<StreetDTO> getStreetsWithHouseCountByCity(@Param("cityId") Long cityId);
}
