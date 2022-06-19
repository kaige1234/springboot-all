/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package cn.com.sk.jdbc.mapstruct.multi.object.mapper;

import cn.com.sk.jdbc.mapstruct.multi.object.entity.Customer;
import cn.com.sk.jdbc.mapstruct.multi.object.entity.CustomerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/***
 * @Mapper 表示该接口作为映射接口，编译时MapStruct处理器的入口。
 * @Mappings 一组映射关系
 * @Mapping 一对映射关系，target：目标类字段，source ：源字段，expression ：target字段使用改表达式获取值
 * @InheritConfiguration，指定映射方法
 *
 * @Mapper(uses = { OrderItemMapper.class })
 * 此映射器使用的其他映射器类型。可以是手工编写的类，也可以是MapStruct生成的其他映射器。生成的映射器类之间不需要创建循环。
 *
 */
@Mapper(uses = { OrderItemMapper.class })
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper( CustomerMapper.class );

    @Mapping(source = "orders", target = "orderItems")
    @Mapping(source = "customerName", target = "name")
    Customer toCustomer(CustomerDto customerDto);

    /**
     * @InheritInverseConfiguration，表示方法继承相应的反向方法的反向配置。
     * 意思就是 customer->customerDto 与 customerDto -> customer是相反的
     */
    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);
}
