package com.example.Adresar.service;

import com.example.Adresar.model.CountryDTO;
import com.example.Adresar.pojo.Country;
import com.example.Adresar.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountriesASC(){
        return countryRepository.findAll();
    }

    public List<Country> getAllCountriesDESC(){
        return countryRepository.findAll();
    }

    public Country getById(long id){
        return countryRepository.getById(id);
    }

    public Country updateCountry(long id, CountryDTO countryDTO){
        Country country = countryRepository.getById(id);
        if(country != null){
            country.setName(countryDTO.getName());
            return countryRepository.save(country);
        }
        return null;
    }

    public Country save(Country country){
        return countryRepository.save(country);
    }

    public void delete(long id) {
        countryRepository.deleteById(id);
    }
}
