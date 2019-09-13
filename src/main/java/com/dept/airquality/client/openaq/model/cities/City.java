package com.dept.airquality.client.openaq.model.cities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Class that represents the object city in answer of get cities
 */
@Data
@NoArgsConstructor
public class City implements Serializable {

    private final long serialVersionUID = 3577453366084317333L;

    @JsonProperty
    private String city;

    @JsonProperty
    private String country;

    @JsonProperty
    private Integer locations;

    @JsonProperty
    private Integer count;
}
