package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Cost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CostRepository extends CrudRepository<Cost, Long> {
    List<Cost> findByCollateralIdAndCollateralType (Long collateralId, CollateralType collateralType);

    @Query(value = "SELECT * FROM COST " +
            "WHERE collateral_id=?1 AND collateral_type=?2 " +
            "ORDER BY date DESC LIMIT 1", nativeQuery = true)
    Cost findLastByCollateralIdAndCollateralType (Long collateralId, CollateralType collateralType);
}
