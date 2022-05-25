package com.example.Adresar.service;

import com.example.Adresar.model.ServiceFacilityDTO;
import com.example.Adresar.pojo.ServiceFacility;
import com.example.Adresar.repository.ServiceFacilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFacilityService {

    private ServiceFacilityRepository serviceFacilityRepository;

    public ServiceFacilityService(ServiceFacilityRepository serviceFacilityRepository) {
        this.serviceFacilityRepository = serviceFacilityRepository;
    }

    public List<ServiceFacility> getAllServiceFacilitesOrderByASC(){
        return serviceFacilityRepository.findAll();
    }

    public ServiceFacility getById(long id){
        return serviceFacilityRepository.getById(id);
    }

    public ServiceFacility save(ServiceFacility serviceFacility){
        return serviceFacilityRepository.save(serviceFacility);
    }

    public ServiceFacility update(long id, ServiceFacilityDTO serviceFacilityDTO){
        ServiceFacility serviceFacility = serviceFacilityRepository.getById(id);
        if(serviceFacility != null){
            serviceFacility.setName(serviceFacilityDTO.getName());
            return serviceFacilityRepository.save(serviceFacility);
        }
        return null;
    }

    public void delete(long id) {
        serviceFacilityRepository.deleteById(id);
    }
}
