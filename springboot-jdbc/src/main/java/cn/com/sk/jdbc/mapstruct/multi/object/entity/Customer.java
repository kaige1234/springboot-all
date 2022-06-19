/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package cn.com.sk.jdbc.mapstruct.multi.object.entity;

import lombok.Data;

import java.util.Collection;

@Data
public class Customer {

    private Long id;
    private String name;
    private Collection<OrderItem> orderItems;


}
