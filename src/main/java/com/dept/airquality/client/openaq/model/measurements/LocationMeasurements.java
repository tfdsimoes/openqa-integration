package com.dept.airquality.client.openaq.model.measurements;

import com.dept.airquality.client.openaq.model.comon.Coordinates;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationMeasurements implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final long serialVersionUID = -2214594490491017472L;

    @JsonProperty
    private String location;

    @JsonProperty
    private String city;

    @JsonProperty
    private String country;

    @JsonProperty
    private Float distance;

    @JsonProperty
    private List<Measurement> measurements = new ArrayList<>();

    @JsonProperty
    private Coordinates coordinates;
}
