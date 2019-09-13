package com.dept.airquality.client.openaq.model.locations;

import com.dept.airquality.client.openaq.model.comon.Coordinates;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final long serialVersionUID = -8286513693236150769L;

    @JsonProperty
    private String location;

    @JsonProperty
    private String city;

    @JsonProperty
    private String country;

    @JsonProperty
    private Integer count;

    @JsonProperty
    private List<String> sourceNames = new ArrayList<>();

    @JsonProperty
    @DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm:ssX" )
    private ZonedDateTime lastUpdated;

    @JsonProperty
    @DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm:ssX" )
    private ZonedDateTime firstUpdated;

    @JsonProperty
    private List<String> parameters = new ArrayList<>();

    @JsonProperty
    private Integer distance;

    @JsonProperty
    private String sourceName;

    @JsonProperty
    private Coordinates coordinates;

}
