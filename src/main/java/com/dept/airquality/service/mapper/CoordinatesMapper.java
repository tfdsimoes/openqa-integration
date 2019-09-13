package com.dept.airquality.service.mapper;

import com.dept.airquality.client.openaq.model.comon.Coordinates;
import com.dept.airquality.service.dto.common.CoordinatesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(nullValueCheckStrategy = ALWAYS)
public interface CoordinatesMapper {

    CoordinatesMapper INSTANCE = Mappers.getMapper(CoordinatesMapper.class);

    CoordinatesDTO CoordinatesToCoordinatesDTO(Coordinates coordinates);
}
