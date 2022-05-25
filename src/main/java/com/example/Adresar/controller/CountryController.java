package com.example.Adresar.controller;

import com.example.Adresar.model.CountryDTO;
import com.example.Adresar.pojo.Country;
import com.example.Adresar.service.CountryService;
import com.example.Adresar.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@CrossOrigin
public class CountryController {

    private CountryService countryService;
    private ModelService modelService;

    @Autowired
    public CountryController(CountryService countryService, ModelService modelService) {
        this.countryService = countryService;
        this.modelService = modelService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CountryDTO>> listCountries(){
        List<Country> country = countryService.getAllCountriesASC();
        return new ResponseEntity<List<CountryDTO>>(modelService.convertToDTOList(country), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO){
        Country country = countryService.save(modelService.convertToEntity(countryDTO));
        return new ResponseEntity<CountryDTO>(modelService.convertToDTO(country), HttpStatus.CREATED) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> listCountry(@PathVariable(value = "id") long id){
        Country country = countryService.getById(id);
        return new ResponseEntity<CountryDTO>(modelService.convertToDTO(country), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable(value = "id") long id, @RequestBody CountryDTO countryDTO){
        return new ResponseEntity<Country>(countryService.updateCountry(id, countryDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCountry(@PathVariable(value = "id") long id){
         countryService.delete(id);
    }
}
