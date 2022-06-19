package cn.com.sk.jdbc.mapstruct.map.to.entity;

import cn.com.sk.jdbc.mapstruct.entity.to.map.entity.Department;
import cn.com.sk.jdbc.mapstruct.entity.to.map.entity.Employee;
import cn.com.sk.jdbc.mapstruct.entity.to.map.mapper.MapToBeanMapper;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;


public class MapToBeanMapperTest {

    @Test
    public void shouldMapMapToBean() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "1234");
        map.put("name", "Tester");
        map.put("did", "4321"); //Department Id
        map.put("dname", "Test");// Depart name

        Employee employee = MapToBeanMapper.INSTANCE.fromMap(map);
        System.out.println(employee);


        Department department = employee.getDepartment();
        System.out.println(department);
    }
}
