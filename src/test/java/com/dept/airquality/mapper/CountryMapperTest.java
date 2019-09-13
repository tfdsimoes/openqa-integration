package com.dept.airquality.mapper;

import com.dept.airquality.client.openaq.model.countries.Country;
import com.dept.airquality.service.dto.CountryDTO;
import com.dept.airquality.service.mapper.CountryMapper;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test to check the mapper convert
 */
public class CountryMapperTest {

    @Test
    public void countryToCountryDTOTest() {
        Country country = buildCountryDefault();

        CountryDTO countryDTO = CountryMapper.INSTANCE.countryToCountryDTO(country);

        assertThat(countryDTO.getName()).isEqualTo(country.getName());
        assertThat(countryDTO.getCode()).isEqualTo(country.getCode());
        assertThat(countryDTO.getTotalCities()).isEqualTo(country.getCities());
    }

    @Test
    public void countriesToCountriesDTO() {
        List<Country> countries = Collections.singletonList(buildCountryDefault());

        List<CountryDTO> countriesDTO = CountryMapper.INSTANCE.countriesToCountriesDTO(countries);

        assertThat(countriesDTO.size()).isEqualTo(countries.size());
        for(int i = 0; i < countriesDTO.size(); i++) {
            CountryDTO countryDTO = countriesDTO.get(i);
            Country country = countries.get(i);

            assertThat(countryDTO.getName()).isEqualTo(country.getName());
            assertThat(countryDTO.getCode()).isEqualTo(country.getCode());
            assertThat(countryDTO.getTotalCities()).isEqualTo(country.getCities());
        }
    }

    private Country buildCountryDefault() {
        return Country.builder()
                .name("testCountry")
                .code("tc")
                .cities(1)
                .count(1)
                .locations(1)
                .build();
    }
}
