package cn.com.sk.jdbc.mapstruct.simple.cope.bean.mapper;

import cn.com.sk.jdbc.mapstruct.multil.to.one.entity.Source;
import cn.com.sk.jdbc.mapstruct.multil.to.one.entity.Target;
import cn.com.sk.jdbc.mapstruct.multil.to.one.mapper.SourceTargetMapper;
import org.junit.Test;

import java.util.Arrays;

/**
 * 将一个集合中的对象拷贝到一个对象中
 */
public class SourceTargetMapperTest {

    public SourceTargetMapperTest() {
    }

    @Test
    public void testToTarget() {

        Source s = new Source();
        s.setMyIntegers( Arrays.asList( 5, 3, 7 ) );
        s.setMyStrings( Arrays.asList( "five", "three", "seven" ) );

        Target t = SourceTargetMapper.MAPPER.toTarget( s );
        System.out.println(t);
    }



}
