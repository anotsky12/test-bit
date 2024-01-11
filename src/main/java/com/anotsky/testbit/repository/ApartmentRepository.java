package com.anotsky.testbit.repository;

import com.anotsky.testbit.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
