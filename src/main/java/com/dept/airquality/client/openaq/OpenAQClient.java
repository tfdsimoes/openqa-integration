package com.dept.airquality.client.openaq;

import com.dept.airquality.client.openaq.model.countries.CountriesAnswer;
import com.dept.airquality.client.openaq.model.locations.LocationsAnswer;
import com.dept.airquality.client.openaq.model.measurements.LocationMeasurementsAnswer;
import com.dept.airquality.client.openaq.model.parameters.ParametersAnswer;
import com.dept.airquality.client.openaq.model.cities.CitiesAnswer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Client to communicate with OpenAQ
 */
@Component
public class OpenAQClient {

    @Value("${openaq.url}")
    public String urlOpenAQ;

    private final Logger log = LoggerFactory.getLogger(OpenAQClient.class);

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Function that will handles the request to openaq for getting all countries
     *
     * @param pageable pageable elements
     * @return list of countries available
     */
    public CountriesAnswer getCountries(Pageable pageable) {
        log.info("Getting countries information from openaq");

        StringBuilder finalUrl = new StringBuilder(urlOpenAQ + String.format("/countries?page=%s&limit=%s", pageable.getPageNumber(), pageable.getPageSize()));

        ResponseEntity<CountriesAnswer> response = restTemplate.getForEntity(finalUrl.toString(), CountriesAnswer.class);

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("Error getting countries from openaq");
        }

        return response.getBody();
    }

    /**
     * Function that will handles the request to openaq for getting all cities
     *
     * @param country country to filter
     * @param pageable pageable elements
     * @return list of cities available
     */
    public CitiesAnswer getCities(String country, Pageable pageable) {
        log.info("Getting cities information from openaq");

        StringBuilder finalUrl = new StringBuilder(urlOpenAQ + String.format("/cities?page=%s&limit=%s", pageable.getPageNumber(), pageable.getPageSize()));

        if(Optional.ofNullable(country).isPresent()){
            finalUrl.append(finalUrl.toString().concat(String.format("&country=%s", country)));
        }

        ResponseEntity<CitiesAnswer> response = restTemplate.getForEntity(finalUrl.toString(), CitiesAnswer.class);

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("Error getting cities from openaq");
        }

        return response.getBody();
    }

    /**
     * Getting parameters information
     *
     * @return list of parameters
     */
    public ParametersAnswer getParameter() {
        log.info("Getting parameters information from openaq");

        ResponseEntity<ParametersAnswer> response = restTemplate.getForEntity(urlOpenAQ + "/parameters", ParametersAnswer.class);

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("Error getting parameters from openaq");
        }

        return response.getBody();
    }

    /**
     * Get locations of a given city
     *
     * @param city city to get
     * @param pageable pageable elements
     * @return list of locations of a city
     */
    public LocationsAnswer getLocations(String city, Pageable pageable) {
        log.info("Getting locations of city");

        ResponseEntity<LocationsAnswer> response = restTemplate.getForEntity(urlOpenAQ + String.format("/locations?page=%s&limit=%s&city[]=%s", pageable.getPageNumber(), pageable.getPageSize(), city), LocationsAnswer.class);

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("Error getting parameters from openaq");
        }

        return response.getBody();
    }

    /**
     * Get air quality of a given location
     *
     * @param location location to get
     * @return air quality of location
     */
    public LocationMeasurementsAnswer getLocationAirQuality(String location) {
        log.info("Getting air quality of location");

        ResponseEntity<LocationMeasurementsAnswer> response = restTemplate.getForEntity(urlOpenAQ + String.format("/latest?location=%s", location).toString(), LocationMeasurementsAnswer.class);

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("Error getting parameters from openaq");
        }

        return response.getBody();
    }
}
