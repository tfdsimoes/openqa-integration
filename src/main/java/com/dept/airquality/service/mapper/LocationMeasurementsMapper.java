package com.dept.airquality.service.mapper;

import com.dept.airquality.client.openaq.model.measurements.LocationMeasurements;
import com.dept.airquality.service.dto.LocationMeasurementsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(nullValueCheckStrategy = ALWAYS, uses = { CoordinatesMapper.class, MeasurementMapper.class})
public interface LocationMeasurementsMapper {

    LocationMeasurementsMapper INSTANCE = Mappers.getMapper(LocationMeasurementsMapper.class);

    LocationMeasurementsDTO LocationMeasurementsToLocationMeasurementsDTO(LocationMeasurements locationMeasurements);
}
