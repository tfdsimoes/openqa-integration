package com.dept.airquality.service.mapper;

import com.dept.airquality.client.openaq.model.measurements.Measurement;
import com.dept.airquality.service.dto.MeasurementDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MeasurementMapper {

    MeasurementMapper INSTANCE = Mappers.getMapper(MeasurementMapper.class);

    MeasurementDTO MeasurementToMeasurementDTO(Measurement measurement);

    List<MeasurementDTO> MeasurementsToMeasurementsDTO(List<Measurement> measurements);
}
