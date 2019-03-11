package com.mcb.creditfactory.external;

import com.mcb.creditfactory.model.Cost;

public interface CollateralObject {
    Cost getCost();
    Short getYear();
    CollateralType getType();
}
