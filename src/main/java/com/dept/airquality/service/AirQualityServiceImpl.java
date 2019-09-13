package com.dept.airquality.service;

import com.dept.airquality.client.openaq.OpenAQClient;
import com.dept.airquality.client.openaq.model.cities.CitiesAnswer;
import com.dept.airquality.client.openaq.model.countries.CountriesAnswer;
import com.dept.airquality.client.openaq.model.measurements.LocationMeasurementsAnswer;
import com.dept.airquality.client.openaq.model.locations.LocationsAnswer;
import com.dept.airquality.client.openaq.model.parameters.ParametersAnswer;
import com.dept.airquality.service.dto.CityDTO;
import com.dept.airquality.service.dto.CountryDTO;
import com.dept.airquality.service.dto.LocationDTO;
import com.dept.airquality.service.dto.LocationMeasurementsDTO;
import com.dept.airquality.service.dto.ParameterDTO;
import com.dept.airquality.service.mapper.CityMapper;
import com.dept.airquality.service.mapper.CountryMapper;
import com.dept.airquality.service.mapper.LocationMapper;
import com.dept.airquality.service.mapper.LocationMeasurementsMapper;
import com.dept.airquality.service.mapper.ParameterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class that implements the interface of AirQuality
 */
@Service
public class AirQualityServiceImpl implements AirQualityService {

    private final Logger log = LoggerFactory.getLogger(AirQualityService.class);

    private final OpenAQClient openAQClient;

    public AirQualityServiceImpl(
            OpenAQClient openAQClient
    ) {
        this.openAQClient = openAQClient;
    }

    /**
     * Function to get countries
     *
     * @param pageable parameters of pageable
     * @return list of countries
     */
    @Override
    public Page<CountryDTO> getCountries(Pageable pageable) {
        log.info("Getting countries information");

        // First page is 1 and not 0
        if(pageable.getPageNumber() == 0) {
            pageable = new PageRequest(1, pageable.getPageSize());
        }

        CountriesAnswer countriesAnswer = openAQClient.getCountries(pageable);

        List<CountryDTO> countriesDTO = CountryMapper.INSTANCE.countriesToCountriesDTO(countriesAnswer.getResults());

        return new PageImpl<>(countriesDTO, pageable, countriesAnswer.getMeta().getFound().longValue());
    }

    /**
     * Function to get cities
     *
     * @param country country to filter
     * @param pageable  parameters of pageable
     * @return list of cities
     */
    @Override
    public Page<CityDTO> getCities(String country, Pageable pageable) {
        log.info("Getting cities information");

        // First page is 1 and not 0
        if(pageable.getPageNumber() == 0) {
            pageable = new PageRequest(1, pageable.getPageSize());
        }

        CitiesAnswer citiesAnswer = openAQClient.getCities(country, pageable);

        List<CityDTO> citiesDTO = CityMapper.INSTANCE.citiesToCitiesDTO(citiesAnswer.getResults());

        return new PageImpl<>(citiesDTO, pageable, citiesAnswer.getMeta().getFound().longValue());
    }

    /**
     * Function to get information about the parameters
     *
     * @return list of parameters
     */
    @Override
    public List<ParameterDTO> getParameters() {
        log.info("Getting parameters information");

        ParametersAnswer parametersAnswer = openAQClient.getParameter();

        return ParameterMapper.INSTANCE.ParametersToParametersDTO(parametersAnswer.getResults());
    }

    /**
     * Function to get locations of a city
     *
     * @param city     city to get
     * @param pageable parameters of pageable
     * @return list of locations
     */
    @Override
    public Page<LocationDTO> getLocationsOfCity(String city, Pageable pageable) {
        log.info("Getting locations of a city");

        // First page is 1 and not 0
        if(pageable.getPageNumber() == 0) {
            pageable = new PageRequest(1, pageable.getPageSize());
        }

        LocationsAnswer locationsAnswer = openAQClient.getLocations(city, pageable);

        List<LocationDTO> locationsDTO = LocationMapper.INSTANCE.LocationsToLocationsDTO(locationsAnswer.getResults());

        return new PageImpl<>(locationsDTO, pageable, locationsAnswer.getMeta().getFound().longValue());
    }

    /**
     * Function to get air quality of location
     *
     * @param location location to get
     * @return air quality of location
     */
    @Override
    public LocationMeasurementsDTO getAirQualityLocation(String location) {

        LocationMeasurementsAnswer locationMeasurementsAnswer = openAQClient.getLocationAirQuality(location);

        if(Optional.ofNullable(locationMeasurementsAnswer.getResults()).isPresent()) {
            return LocationMeasurementsMapper.INSTANCE.LocationMeasurementsToLocationMeasurementsDTO(locationMeasurementsAnswer.getResults().get(0));
        }

        return new LocationMeasurementsDTO();
    }
}
