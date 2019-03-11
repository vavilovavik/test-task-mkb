package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Cost;
import com.mcb.creditfactory.service.cost.CostService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AirplaneAdapter implements CollateralObject {
    private AirplaneDto airplane;

    public AirplaneAdapter(AirplaneDto airplane) {
        this.airplane = airplane;
    }

    @Autowired
    private CostService costService;

    @Override
    public Short getYear() {
        return airplane.getYear();
    }

    @Override
    public Cost getCost() {
        return Optional.of(costService.getLast(airplane.getId(), CollateralType.AIRPLANE))
                .orElse(null);
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
