package com.dept.airquality.client.openaq.model.comon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Class that represents the meta part of openaq answer
 *
 * @author tiago.simoes
 */
@Data
@NoArgsConstructor
public class Meta implements Serializable {

    private final long serialVersionUID = -4002381374848822855L;

    @JsonProperty
    private String name;

    @JsonProperty
    private String license;

    @JsonProperty
    private String website;

    @JsonProperty
    private Integer page;

    @JsonProperty
    private Integer limit;

    @JsonProperty
    private Integer found;
}
