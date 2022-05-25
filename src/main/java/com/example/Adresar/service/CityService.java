package com.example.Adresar.service;

import com.example.Adresar.model.CityDTO;
import com.example.Adresar.pojo.City;
import com.example.Adresar.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCitiesOrderByASC(){
        return cityRepository.findAll();
    }

    public City save(City city){
        return cityRepository.save(city);
    }

    public City getById(long id){
        return cityRepository.getById(id);
    }

    public City updateCity(long id, CityDTO cityDTO){
        City city = cityRepository.getById(id);
        if(city != null){
            city.setName(cityDTO.getName());
            return cityRepository.save(city);
        }
        return null;
    }

    public void delete(long id) {
        cityRepository.deleteById(id);
    }
}
