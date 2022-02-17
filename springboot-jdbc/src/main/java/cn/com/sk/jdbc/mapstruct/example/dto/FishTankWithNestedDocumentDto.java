/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package cn.com.sk.jdbc.mapstruct.example.dto;

import lombok.Data;

@Data
public class FishTankWithNestedDocumentDto {

    private FishDto fish;
    private WaterPlantDto plant;
    private String name;
    private MaterialDto material;
    private OrnamentDto ornament;
    private WaterQualityWithDocumentDto quality;

}
