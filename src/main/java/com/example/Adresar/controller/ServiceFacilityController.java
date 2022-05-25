package com.example.Adresar.controller;

import com.example.Adresar.model.ServiceFacilityDTO;
import com.example.Adresar.pojo.ServiceFacility;
import com.example.Adresar.service.ModelService;
import com.example.Adresar.service.ServiceFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicefacilities")
public class ServiceFacilityController {

    private ServiceFacilityService serviceFacilityService;
    private ModelService modelService;

    @Autowired
    public ServiceFacilityController(ServiceFacilityService serviceFacilityService, ModelService modelService) {
        this.serviceFacilityService = serviceFacilityService;
        this.modelService = modelService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ServiceFacilityDTO>> listCities(){
        List<ServiceFacility> serviceFacilityList = serviceFacilityService.getAllServiceFacilitesOrderByASC();
        return new ResponseEntity<List<ServiceFacilityDTO>>(modelService.convertToServiceFacilityDTOList(serviceFacilityList), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceFacilityDTO> listServiceFacility(@PathVariable(value = "id") long id){
        ServiceFacility serviceFacility = serviceFacilityService.getById(id);
        return new ResponseEntity<ServiceFacilityDTO>(modelService.convertToDTO(serviceFacility), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ServiceFacilityDTO> create(@RequestBody ServiceFacilityDTO serviceFacilityDTO){
        ServiceFacility serviceFacility = serviceFacilityService.save(modelService.convertToEntity(serviceFacilityDTO));
        return new ResponseEntity<ServiceFacilityDTO>(modelService.convertToDTO(serviceFacility), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ServiceFacility> updateServiceFacility(@PathVariable(value = "id") long id, @RequestBody ServiceFacilityDTO serviceFacilityDTO){
        return new ResponseEntity<ServiceFacility>(serviceFacilityService.update(id, serviceFacilityDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteServiceFacility(@PathVariable(value = "id") long id){
        serviceFacilityService.delete(id);
    }
}
