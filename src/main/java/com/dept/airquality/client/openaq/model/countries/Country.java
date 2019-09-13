package com.dept.airquality.client.openaq.model.countries;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country implements Serializable {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private final long serialVersionUID = -6256338312159113689L;

    @JsonProperty
    private String name;

    @JsonProperty
    private String code;

    @JsonProperty
    private Integer cities;

    @JsonProperty
    private Integer locations;

    @JsonProperty
    private Integer count;
}
