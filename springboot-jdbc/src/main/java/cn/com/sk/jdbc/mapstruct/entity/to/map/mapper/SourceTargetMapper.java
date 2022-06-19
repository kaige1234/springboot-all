package cn.com.sk.jdbc.mapstruct.entity.to.map.mapper;


import cn.com.sk.jdbc.mapstruct.entity.to.map.entity.Source;
import cn.com.sk.jdbc.mapstruct.entity.to.map.entity.Target;
import cn.com.sk.jdbc.mapstruct.entity.to.map.util.MappingUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Adam Gurgul
 */

@Mapper( uses = MappingUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mapping(source = "map", target = "ip", qualifiedBy = MappingUtil.Ip.class )
    @Mapping(source = "map", target = "server", qualifiedBy = MappingUtil.Server.class )
    Target toTarget(Source s);
}
