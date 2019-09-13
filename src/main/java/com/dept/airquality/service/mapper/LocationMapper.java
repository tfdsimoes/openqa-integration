package com.dept.airquality.service.mapper;

import com.dept.airquality.client.openaq.model.locations.Location;
import com.dept.airquality.service.dto.LocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

@Mapper(nullValueCheckStrategy = ALWAYS, uses = {CoordinatesMapper.class})
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    LocationDTO LocationToLocationDTO(Location location);

    List<LocationDTO> LocationsToLocationsDTO(List<Location> locations);
}
