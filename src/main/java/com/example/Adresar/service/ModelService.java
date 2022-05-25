package com.example.Adresar.service;

import com.example.Adresar.model.CityDTO;
import com.example.Adresar.model.CountryDTO;
import com.example.Adresar.model.ServiceFacilityDTO;
import com.example.Adresar.pojo.City;
import com.example.Adresar.pojo.Country;
import com.example.Adresar.pojo.ServiceFacility;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService {
    ModelMapper modelMapper = new ModelMapper();

    private CityService cityService;

   public CountryDTO convertToDTO(Country country){
      CountryDTO countryDTO = modelMapper.map(country, CountryDTO.class);
      return  countryDTO;
   }

   public Country convertToEntity(CountryDTO countryDTO){
       Country country = modelMapper.map(countryDTO, Country.class);
       return country;
   }

   public CityDTO convertToDTO(City city){
       CityDTO cityDTO = modelMapper.map(city, CityDTO.class);
       return cityDTO;
   }

    public City convertToEntity(CityDTO cityDTO){
        City city = modelMapper.map(cityDTO, City.class);
        return city;
    }

    public ServiceFacilityDTO convertToDTO(ServiceFacility serviceFacility){
        ServiceFacilityDTO serviceFacilityDTO = modelMapper.map(serviceFacility, ServiceFacilityDTO.class);
        return serviceFacilityDTO;
    }

    public ServiceFacility convertToEntity(ServiceFacilityDTO serviceFacilityDTO){
        ServiceFacility serviceFacility = modelMapper.map(serviceFacilityDTO, ServiceFacility.class);
        return serviceFacility;
    }

    public List<CountryDTO> convertToDTOList(List<Country> countryList){
       List<CountryDTO> list = new ArrayList<>();
        for (Country country : countryList) {
            list.add(convertToDTO(country));
        }
       return list;
    }

    public List<CityDTO> convertToCityDTOList(List<City> cityList){
       List<CityDTO> list = new ArrayList<>();
        for (City city : cityList) {
            list.add(convertToDTO(city));
        }
        return list;
    }

    public List<ServiceFacilityDTO> convertToServiceFacilityDTOList(List<ServiceFacility> serviceFacilityList){
       List<ServiceFacilityDTO> list = new ArrayList<>();
        for (ServiceFacility serviceFacility : serviceFacilityList) {
            list.add(convertToDTO(serviceFacility));
        }
        return list;
    }
}
