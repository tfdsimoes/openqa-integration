package com.dept.airquality.service;

import com.dept.airquality.service.dto.CityDTO;
import com.dept.airquality.service.dto.CountryDTO;
import com.dept.airquality.service.dto.LocationDTO;
import com.dept.airquality.service.dto.LocationMeasurementsDTO;
import com.dept.airquality.service.dto.ParameterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interface for Air Quality Service
 *
 * @author tiago.simoes
 */
public interface AirQualityService {

    /**
     * Interface to get countries
     *
     * @param pageable parameters of pageable
     * @return list of countries
     */
    Page<CountryDTO> getCountries(Pageable pageable);

    /**
     * Interface to get cities
     *
     * @param country country to filter
     * @param pageable parameters of pageable
     * @return list of cities
     */
    Page<CityDTO> getCities(String country, Pageable pageable);

    /**
     * Interface to get information about the parameters
     *
     * @return list of parameters
     */
    List<ParameterDTO> getParameters();

    /**
     * Interface to get locations of a city
     *
     * @param city city to get
     * @param pageable parameters of pageable
     * @return list of locations
     */
    Page<LocationDTO> getLocationsOfCity(String city, Pageable pageable);

    /**
     * Interface to get air quality of location
     *
     * @param location location to get
     * @return air quality of location
     */
    LocationMeasurementsDTO getAirQualityLocation(String location);
}
