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
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDTO implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final long serialVersionUID = -3411640265686822179L;

    @JsonProperty
    private String location;

    @JsonProperty
    private List<String> parameters;

    @JsonProperty
    private String sourceName;

    @JsonProperty
    private CoordinatesDTO coordinates;
}
