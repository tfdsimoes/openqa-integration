package com.dept.airquality.client.openaq.model.measurements;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Measurement implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final long serialVersionUID = -3960422866574760389L;

    @JsonProperty
    private String parameter;

    @JsonProperty
    private Float value;

    @JsonProperty
    @DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm:ssX" )
    private ZonedDateTime lastUpdated;

    @JsonProperty
    private String unit;

    @JsonProperty
    private String sourceName;

    @JsonProperty
    private AveragingPeriod averagingPeriod;
}
