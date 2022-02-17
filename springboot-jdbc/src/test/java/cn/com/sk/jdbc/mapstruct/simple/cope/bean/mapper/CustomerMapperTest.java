package cn.com.sk.jdbc.mapstruct.simple.cope.bean.mapper;

import cn.com.sk.jdbc.mapstruct.multi.object.entity.Customer;
import cn.com.sk.jdbc.mapstruct.multi.object.entity.CustomerDto;
import cn.com.sk.jdbc.mapstruct.multi.object.entity.OrderItem;
import cn.com.sk.jdbc.mapstruct.multi.object.entity.OrderItemDto;
import cn.com.sk.jdbc.mapstruct.multi.object.mapper.CustomerMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 多个对象之间的拷贝
 */
public class CustomerMapperTest {

    @Test
    public void testMapDtoToEntity() {

        CustomerDto customerDto = new CustomerDto();
        customerDto.id = 10L;
        customerDto.customerName = "Filip";
        OrderItemDto order1 = new OrderItemDto();
        order1.name = "Table";
        order1.quantity = 2L;
        customerDto.orders = new ArrayList<>( Collections.singleton( order1 ) );

        Customer customer = CustomerMapper.MAPPER.toCustomer( customerDto );
        System.out.println(customer);

    }

    @Test
    public void testEntityDtoToDto() {

        Customer customer = new Customer();
        customer.setId( 10L );
        customer.setName( "Filip" );
        OrderItem order1 = new OrderItem();
        order1.setName( "Table" );
        order1.setQuantity( 2L );
        customer.setOrderItems( Collections.singleton( order1 ) );

        CustomerDto customerDto = CustomerMapper.MAPPER.fromCustomer( customer );

       System.out.println(customerDto);
    }
}
