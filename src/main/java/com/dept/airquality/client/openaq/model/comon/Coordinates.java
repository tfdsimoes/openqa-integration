package com.dept.airquality.client.openaq.model.comon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Coordinates implements Serializable {

    private final long serialVersionUID = -9045302307347822265L;

    @JsonProperty
    private Float latitude;

    @JsonProperty
    private Float longitude;
}
