package com.dept.airquality.client.openaq.model.cities;

import com.dept.airquality.client.openaq.model.comon.Meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents the answer of getting cities
 */
@Data
@NoArgsConstructor
public class CitiesAnswer implements Serializable{

    private final long serialVersionUID = 6036660536549746379L;

    @JsonProperty
    private Meta meta;

    @JsonProperty
    private List<City> results = new ArrayList<>();
}
