package com.nimna.possystemlts.dto.request;

import com.nimna.possystemlts.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {
    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;
}
