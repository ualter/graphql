package com.graphqljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqljava.model.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}