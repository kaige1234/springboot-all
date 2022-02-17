package cn.com.sk.jdbc.mapstruct.example.dto;

import lombok.Data;

@Data
public class FishTankDto {

    private FishDto fish;
    private WaterPlantDto plant;
    private String name;
    private MaterialDto material;
    private OrnamentDto ornament;
    private WaterQualityDto quality;


}
