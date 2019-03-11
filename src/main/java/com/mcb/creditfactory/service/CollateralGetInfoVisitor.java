package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CollateralGetInfoVisitor implements Visitor {
    private CollateralService collateralService;

    public Collateral visit(CarDto carDto) {
        return collateralService.getInfo(carDto);
    }

    public Collateral visit(AirplaneDto airplaneDto) {
        return collateralService.getInfo(airplaneDto);
    }
}
