package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mcb.creditfactory.service.CollateralGetInfoVisitor;
import com.mcb.creditfactory.service.SaveCollateralVisitor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarDto.class),
        @JsonSubTypes.Type(value = AirplaneDto.class)
})
public interface Collateral {
    Long acceptSave(SaveCollateralVisitor visitor);

    Collateral acceptGetInfo(CollateralGetInfoVisitor visitor);
}
