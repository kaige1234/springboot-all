package cn.com.sk.jdbc.mapstruct.example;

import cn.com.sk.jdbc.mapstruct.example.dto.FishTankDto;
import cn.com.sk.jdbc.mapstruct.example.dto.FishTankWithNestedDocumentDto;
import cn.com.sk.jdbc.mapstruct.example.mapper.FishTankMapper;
import cn.com.sk.jdbc.mapstruct.example.mapper.FishTankMapperConstant;
import cn.com.sk.jdbc.mapstruct.example.mapper.FishTankMapperExpression;
import cn.com.sk.jdbc.mapstruct.example.mapper.FishTankMapperWithDocument;
import cn.com.sk.jdbc.mapstruct.example.model.*;
import org.junit.Test;

/**
 *
 * @author Sjaak Derksen
 */
public class FishTanksMappersTest {

    @Test
    public void shouldAutomapAndHandleSourceAndTargetPropertyNesting() {

        // -- prepare
        FishTank source = createFishTank();

        // -- action
        FishTankDto target = FishTankMapper.INSTANCE.map( source );

        System.out.println(target);
    }

    @Test
    public void shouldAutomapAndHandleSourceAndTargetPropertyNestingReverse() {

        // -- prepare
        FishTank source = createFishTank();

        // -- action
        FishTankDto target = FishTankMapper.INSTANCE.map( source );
        FishTank source2 = FishTankMapper.INSTANCE.map( target );
    }

    @Test
    public void shouldAutomapAndHandleSourceAndTargetPropertyNestingAndConstant() {

        // -- prepare
        FishTank source = createFishTank();

        // -- action
        FishTankDto target = FishTankMapperConstant.INSTANCE.map( source );

    }

    @Test
    public void shouldAutomapAndHandleSourceAndTargetPropertyNestingAndExpresion() {

        // -- prepare
        FishTank source = createFishTank();

        // -- action
        FishTankDto target = FishTankMapperExpression.INSTANCE.map( source );
    }

   @Test
    public void shouldAutomapIntermediateLevelAndMapConstant() {

        // -- prepare
        FishTank source = createFishTank();

        // -- action
        FishTankWithNestedDocumentDto target = FishTankMapperWithDocument.INSTANCE.map( source );
    }

    private FishTank createFishTank() {
        FishTank fishTank = new FishTank();

        Fish fish = new Fish();
        fish.setType( "Carp" );

        WaterPlant waterplant = new WaterPlant();
        waterplant.setKind( "Water Hyacinth" );

        Interior interior = new Interior();
        interior.setDesigner( "MrVeryFamous" );
        Ornament ornament = new Ornament();
        ornament.setType( "castle" );
        interior.setOrnament( ornament );

        WaterQuality quality = new WaterQuality();
        WaterQualityReport report = new WaterQualityReport();
        report.setVerdict( "PASSED" );
        report.setOrganisationName( "ACME" );
        quality.setReport( report );

        MaterialType materialType = new MaterialType();
        materialType.setType( "myMaterialType" );

        fishTank.setName( "MyLittleFishTank" );
        fishTank.setFish( fish );
        fishTank.setPlant( waterplant );
        fishTank.setInterior( interior );
        fishTank.setMaterial( materialType );
        fishTank.setQuality( quality );

        return fishTank;
    }
}
