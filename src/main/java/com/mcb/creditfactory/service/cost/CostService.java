package com.mcb.creditfactory.service.cost;

import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Cost;
import com.mcb.creditfactory.repository.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostService {
    @Autowired
    private CostRepository costRepository;

    public Long save(Cost cost) {
        return Optional.of(costRepository.save(cost))
                .map(Cost::getId)
                .orElse(null);
    }

    public Optional<Cost> load(Long id) {
        return costRepository.findById(id);
    }

    public Long getId(Cost cost) {
        return cost.getId();
    }

    public List<Cost> getList(Long collateralId, CollateralType collateralType) {
        return costRepository.findByCollateralIdAndCollateralType(collateralId, collateralType);
    }

    public Cost getLast(Long collateralId, CollateralType collateralType) {
        return costRepository.findLastByCollateralIdAndCollateralType(collateralId, collateralType);
    }
}
