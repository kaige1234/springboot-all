package cn.com.sk.jdbc.mapstruct.simple.cope.bean.mapper;



/**
 * 简单的对象拷贝的mapper,只是练习使用
 */

import cn.com.sk.jdbc.mapstruct.simple.cope.bean.entity.Source;
import cn.com.sk.jdbc.mapstruct.simple.cope.bean.entity.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

/***
 * @Mapper  componentModel有三种模式
 * 1.default:这种模式是默认的，mapstruct不使用任何组件类型，可以通过Mappers.getMapper(Class)
 * 方式获取自动生成的实例对象；
 * 2.cdi 生成的映射器是一个应用程序范围的CDI bean，可以通过@Inject检索
 * 3.spring 生成的映射器是一个Spring bean，可以通过@Autowired注入
 * 4.jsr330 生成的映射器是用@javax.inject注释的。命名和@Singleton，可以通过@Inject检索
 */
@Mapper(mappingControl = DeepClone.class)
public interface SimpleSourceToTargetMapper {

    SimpleSourceToTargetMapper MAPPER = Mappers.getMapper(SimpleSourceToTargetMapper.class);


    @Mapping(source = "sourceCode",target ="targetCode")
    Target sourceToTarget(Source source);

}
