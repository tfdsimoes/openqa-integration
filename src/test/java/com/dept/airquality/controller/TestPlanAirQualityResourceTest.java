package com.dept.airquality.controller;

import com.dept.airquality.service.dto.ParameterDTO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for the endpoints in AirQualityResource
 *
 * @author tiago.simoes
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestPlanAirQualityResourceTest {

    private static Logger log = LoggerFactory.getLogger(TestPlanAirQualityResourceTest.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting( Description description ) {
            log.info("Running the integration Test --> " + description.getMethodName());
        }
    };

    @Test (expected = IllegalArgumentException.class)
    public void getLocationsWithNoCity() {

        restTemplate.exchange("http://localhost:" + port + "/air-quality/cities/{city}/locations", HttpMethod.GET, null, new ParameterizedTypeReference<Void>() {});
    }

    @Test
    public void getLocationsSuccessful() {
        String city = "Barcelona";

        ResponseEntity<List<ParameterDTO>> response = restTemplate.exchange(
                "http://localhost:" + port + "/air-quality/parameters", HttpMethod.GET,
                null ,
                new ParameterizedTypeReference<List<ParameterDTO>>() {});

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }
}
