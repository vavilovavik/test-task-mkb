package com.mcb.creditfactory.controller;

import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Cost;
import com.mcb.creditfactory.service.cost.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollateralCostController {
    @Autowired
    private CostService costService;

    @PostMapping("/collateral/cost/save")
    public HttpEntity<Long> save(@RequestBody Cost cost) {
        Long id = costService.save(cost);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/collateral/cost/get/")
    public HttpEntity<List<Cost>> get(@RequestBody Long collateralId, CollateralType collateralType) {
        List<Cost> costList = costService.getList(collateralId, collateralType);
        return costList != null ? ResponseEntity.ok(costList) : ResponseEntity.notFound().build();
    }
}
