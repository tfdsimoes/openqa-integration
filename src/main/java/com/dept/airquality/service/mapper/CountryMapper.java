package com.dept.airquality.service.mapper;

import com.dept.airquality.client.openaq.model.countries.Country;
import com.dept.airquality.service.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(source = "cities", target = "totalCities")
    CountryDTO countryToCountryDTO(Country country);

    List<CountryDTO> countriesToCountriesDTO(List<Country> countries);
}
