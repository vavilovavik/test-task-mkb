package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.service.GetInfoCollateralVisitor;
import com.mcb.creditfactory.service.SaveCollateralVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("car")
public class CarDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private Double power;
    private Short year;

    @Override
    public Long acceptSave(SaveCollateralVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Collateral acceptGetInfo(GetInfoCollateralVisitor visitor) {
        return visitor.visit(this);
    }
}
