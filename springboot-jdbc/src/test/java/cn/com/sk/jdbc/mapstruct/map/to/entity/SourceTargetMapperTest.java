package cn.com.sk.jdbc.mapstruct.map.to.entity;

import cn.com.sk.jdbc.mapstruct.entity.to.map.entity.Source;
import cn.com.sk.jdbc.mapstruct.entity.to.map.entity.Target;
import cn.com.sk.jdbc.mapstruct.entity.to.map.mapper.SourceTargetMapper;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNull;

/**
 *
 * @author Adam Gurgul
 */
public class SourceTargetMapperTest {

    public SourceTargetMapperTest() {
    }

    @Test
    public void testMapperOnExistingIpAndServer() {

        Map<String, Object> map = new HashMap<>();
        map.put("ip", "127.0.0.1");
        map.put("server", "168.192.1.1");

        Source s = new Source(map);
        Target t = SourceTargetMapper.MAPPER.toTarget( s );
        System.out.println(t);


    }

    @Test
    public void testMapperOnNonExistingIpAndServer() {

        Map<String, Object> map = new HashMap<>();
        Source s = new Source(map);
        Target t = SourceTargetMapper.MAPPER.toTarget( s );

        System.out.println(t);

    }



}
