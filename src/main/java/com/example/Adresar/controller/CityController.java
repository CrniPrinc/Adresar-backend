package com.example.Adresar.controller;

import com.example.Adresar.model.CityDTO;
import com.example.Adresar.pojo.City;
import com.example.Adresar.service.CityService;
import com.example.Adresar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;
    private ModelService modelService;

    @Autowired
    public CityController(CityService cityService, ModelService modelService) {
        this.cityService = cityService;
        this.modelService = modelService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CityDTO>> listCities(){
        List<City> city = cityService.getAllCitiesOrderByASC();
        return new ResponseEntity<List<CityDTO>>(modelService.convertToCityDTOList(city), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO){
        System.out.println(modelService.convertToEntity(cityDTO).getCountry().getName());
        City city = cityService.save(modelService.convertToEntity(cityDTO));
        return new ResponseEntity<CityDTO>(modelService.convertToDTO(city), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDTO> listCity(@PathVariable(value = "id") long id){
        City city = cityService.getById(id);
        return new ResponseEntity<CityDTO>(modelService.convertToDTO(city), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<City> updateCity(@PathVariable(value = "id") long id, @RequestBody CityDTO cityDTO){
        return new ResponseEntity<City>(cityService.updateCity(id, cityDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCity(@PathVariable(value = "id") long id){
        cityService.delete(id);
    }
}
