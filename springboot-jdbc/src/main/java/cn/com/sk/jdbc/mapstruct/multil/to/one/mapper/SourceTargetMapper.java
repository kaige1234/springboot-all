package cn.com.sk.jdbc.mapstruct.multil.to.one.mapper;


import cn.com.sk.jdbc.mapstruct.multil.to.one.entity.Source;
import cn.com.sk.jdbc.mapstruct.multil.to.one.entity.Target;
import cn.com.sk.jdbc.mapstruct.multil.to.one.util.FirstElement;
import cn.com.sk.jdbc.mapstruct.multil.to.one.util.IterableNonInterableUtil;
import cn.com.sk.jdbc.mapstruct.multil.to.one.util.LastElement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( uses = IterableNonInterableUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    //@Mapping( source = "myIntegers", target = "myInteger", qualifiedBy = FirstElement.class )
    //@Mapping( source = "myStrings", target = "myString", qualifiedBy = LastElement.class )
    Target toTarget(Source s );
}
