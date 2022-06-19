/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package cn.com.sk.jdbc.mapstruct.multi.object.entity;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    public Long id;
    public String customerName;
    public List<OrderItemDto> orders;
}
