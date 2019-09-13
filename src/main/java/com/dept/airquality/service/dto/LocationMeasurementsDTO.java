package com.dept.airquality.service.dto;

import com.dept.airquality.service.dto.common.CoordinatesDTO;
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
public class LocationMeasurementsDTO implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final long serialVersionUID = -434423676544227673L;

    @JsonProperty
    private String location;

    @JsonProperty
    private String city;

    @JsonProperty
    private List<MeasurementDTO> measurements = new ArrayList<>();

    @JsonProperty
    private CoordinatesDTO coordinates;

}
