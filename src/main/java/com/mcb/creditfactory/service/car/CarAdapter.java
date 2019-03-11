package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Cost;
import com.mcb.creditfactory.service.cost.CostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CarAdapter implements CollateralObject {
    private CarDto car;

    public CarAdapter(CarDto car) {
        this.car = car;
    }

    @Autowired
    private CostService costService;

    @Override
    public Cost getCost() {
        return Optional.of(costService.getLast(car.getId(), CollateralType.CAR))
                .orElse(null);
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }


}
