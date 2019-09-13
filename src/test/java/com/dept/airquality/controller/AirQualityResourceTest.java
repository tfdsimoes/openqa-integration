package com.dept.airquality.controller;

import com.dept.airquality.ApplicationConfig;
import com.dept.airquality.service.AirQualityService;
import com.dept.airquality.service.dto.CountryDTO;
import com.dept.airquality.web.rest.AirQualityResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class with unit tests to the controller of AirQualityResource
 */
@Import({ApplicationConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(AirQualityResource.class)
@ContextConfiguration
public class AirQualityResourceTest {

    @Autowired
    private AirQualityService airQualityService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {

    }

    @Test
    public void getCountriesSuccessfulWithoutPagination() throws Exception {
        // Given
        CountryDTO countryDTO = CountryDTO.builder()
                .name("testCountry")
                .code("tc")
                .totalCities(1)
                .build();

        List<CountryDTO> countriesDTO = Collections.singletonList(countryDTO);

        // When
        when(airQualityService.getCountries(any())).thenReturn(new PageImpl<>(countriesDTO));

        // Then
        mockMvc.perform(get("/air-quality/countries"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isNotEmpty());
    }

    @Test
    public void getCountriesSuccessfulWithPagination() throws Exception {
        // Given
        int page = 1;
        int size = 20;

        CountryDTO countryDTO = CountryDTO.builder()
                .name("testCountry")
                .code("tc")
                .totalCities(1)
                .build();

        List<CountryDTO> countriesDTO = Collections.singletonList(countryDTO);

        // When
        when(airQualityService.getCountries(any())).thenReturn(new PageImpl<>(countriesDTO, PageRequest.of(page, size), 1L));

        // Then
        mockMvc.perform(get("/air-quality/countries?page%s&size=%s", page, size))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isNotEmpty());
    }
}
