package com.example.Adresar.repository;

import com.example.Adresar.pojo.ServiceFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceFacilityRepository extends JpaRepository<ServiceFacility, Long> {
}
