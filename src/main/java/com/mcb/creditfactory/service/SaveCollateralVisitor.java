package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveCollateralVisitor implements Visitor {
    private CollateralService collateralService;

    public Long visit(CarDto carDto) {
        return collateralService.saveCollateral(carDto);
    }

    public Long visit(AirplaneDto airplaneDto) {
        return collateralService.saveCollateral(airplaneDto);
    }
}
