package com.dept.airquality.service.mapper;

import com.dept.airquality.client.openaq.model.parameters.Parameter;
import com.dept.airquality.service.dto.ParameterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ParameterMapper {

    ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);

    @Mapping(source = "preferredUnit", target = "unit")
    ParameterDTO ParameterToParameterDTO(Parameter parameter);

    List<ParameterDTO> ParametersToParametersDTO(List<Parameter> parameters);
}
