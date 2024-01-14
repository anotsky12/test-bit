package com.anotsky.testbit.repository;

import com.anotsky.testbit.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
