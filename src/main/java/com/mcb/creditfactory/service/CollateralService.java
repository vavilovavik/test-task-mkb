package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollateralService {
    @Autowired
    public CarService carService;

    @Autowired
    public AirplaneService airplaneService;

    private SaveCollateralVisitor saveVisitor = new SaveCollateralVisitor(this);

    private CollateralGetInfoVisitor getInfoVisitor = new CollateralGetInfoVisitor(this);

    public Long saveCollateral(Collateral collateral) {
        return collateral.acceptSave(saveVisitor);
    }

    public Collateral getInfo(Collateral collateral) {
        return collateral.acceptGetInfo(getInfoVisitor);
    }

    public Long saveCollateral(CarDto car) {
        boolean approved = carService.approve(car);
        if (!approved) {
            return null;
        }

        return Optional.of(car)
                .map(carService::fromDto)
                .map(carService::save)
                .map(carService::getId)
                .orElse(null);
    }

    public Collateral getInfo(CarDto car) {
        return Optional.of(car)
                .map(carService::fromDto)
                .map(carService::getId)
                .flatMap(carService::load)
                .map(carService::toDTO)
                .orElse(null);
    }

    public Long saveCollateral(AirplaneDto airplaneDto) {
        boolean approved = airplaneService.approve(airplaneDto);
        if (!approved) {
            return null;
        }

        return Optional.of(airplaneDto)
                .map(airplaneService::fromDto)
                .map(airplaneService::save)
                .map(airplaneService::getId)
                .orElse(null);
    }

    public Collateral getInfo(AirplaneDto airplaneDto) {
        return Optional.of(airplaneDto)
                .map(airplaneService::fromDto)
                .map(airplaneService::getId)
                .flatMap(airplaneService::load)
                .map(airplaneService::toDTO)
                .orElse(null);
    }
}
