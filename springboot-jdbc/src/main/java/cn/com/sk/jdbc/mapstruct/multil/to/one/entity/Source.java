/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package cn.com.sk.jdbc.mapstruct.multil.to.one.entity;

import lombok.Data;

import java.util.List;

@Data
public class Source {


    private List<Integer> myIntegers;
    private List<String> myStrings;


}
