package com.dept.airquality;

import com.dept.airquality.service.AirQualityService;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

public class ApplicationConfig {

    @Bean
    private AirQualityService airQualityService() {
        return mock(AirQualityService.class);
    }
}
