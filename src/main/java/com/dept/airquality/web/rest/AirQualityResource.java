package com.dept.airquality.web.rest;

import com.dept.airquality.service.AirQualityService;
import com.dept.airquality.service.dto.CityDTO;
import com.dept.airquality.service.dto.CountryDTO;
import com.dept.airquality.service.dto.LocationDTO;
import com.dept.airquality.service.dto.LocationMeasurementsDTO;
import com.dept.airquality.service.dto.ParameterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Class that handles the request to air-quality
 */
@RestController
@RequestMapping(value = "/air-quality", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AirQualityResource {

    private final Logger log = LoggerFactory.getLogger(AirQualityResource.class);

    private final AirQualityService airQualityService;

    public AirQualityResource(
            AirQualityService airQualityService
    ) {
        this.airQualityService = airQualityService;
    }

    /**
     * Controller to get all countries available with pagination
     *
     * @param pageable pageable parameters
     * @return list of countries available
     */
    @GetMapping("/countries")
    public ResponseEntity<Page<CountryDTO>> getCountries(Pageable pageable) {
        log.info("Requesting countries available");

        return ResponseEntity.of(Optional.of(airQualityService.getCountries(pageable)));
    }

    /**
     * Controller to get all cities available with pagination
     *
     * @param country country to filter the cities
     * @param pageable pageable parameters
     * @return list of cities
     */
    @GetMapping("/cities")
    public ResponseEntity<Page<CityDTO>> getCities(
            @RequestParam(value = "country", required = false) String country,
            Pageable pageable
    ) {
        log.info("Requesting cities available");

        return ResponseEntity.of(Optional.of(airQualityService.getCities(country, pageable)));
    }

    /**
     * Controller to get information about parameters available
     *
     * @return list of parameters
     */
    @GetMapping("/parameters")
    public ResponseEntity<List<ParameterDTO>> getParametersInformation() {
        log.info("Requesting parameters information");

        return ResponseEntity.of(Optional.of(airQualityService.getParameters()));
    }

    /**
     * Controller to get information about locations of a city
     *
     * @param city City to get
     * @param pageable pageable parameters
     * @return list of locations
     */
    @GetMapping("/cities/{city}/locations")
    public ResponseEntity<Page<LocationDTO>> getLocations(
            @PathVariable("city") String city,
            Pageable pageable
    ) {
        log.info("Requesting locations for city {}", city);

        return ResponseEntity.of(Optional.of(airQualityService.getLocationsOfCity(city, pageable)));
    }

    /**
     * Controller to get information about air quality of location
     *
     * @param location location to get
     * @return air quality information
     */
    @GetMapping("/locations/{location}/air-quality")
    public ResponseEntity<LocationMeasurementsDTO> getLocationAirQuality(@PathVariable("location") String location) {
        log.info("Requesting air quality of location {}", location);

        return ResponseEntity.of(Optional.of(airQualityService.getAirQualityLocation(location)));
    }
}
