package com.example.Adresar.model;

public class CityDTO {

    private String name;
    private Long id;

    private CountryDTO country;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryDTO getCountry() {
        return this.country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
}
