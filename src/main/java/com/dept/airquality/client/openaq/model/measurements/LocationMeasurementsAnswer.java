package com.dept.airquality.client.openaq.model.measurements;

import com.dept.airquality.client.openaq.model.comon.Meta;
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
public class LocationMeasurementsAnswer implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final long serialVersionUID = 6866046077091827420L;

    @JsonProperty
    private Meta meta;

    @JsonProperty
    private List<LocationMeasurements> results;
}
