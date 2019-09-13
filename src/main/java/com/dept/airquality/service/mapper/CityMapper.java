package com.dept.airquality.service.mapper;

import com.dept.airquality.client.openaq.model.cities.City;
import com.dept.airquality.service.dto.CityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(nullValueCheckStrategy = ALWAYS)
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(source = "city", target = "name")
    CityDTO cityToCityDTO(City city);

    List<CityDTO> citiesToCitiesDTO(List<City> cities);
}
