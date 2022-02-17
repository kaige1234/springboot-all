package cn.com.sk.jdbc.mapstruct.simple.cope.bean.mapper;


import cn.com.sk.jdbc.mapstruct.simple.cope.bean.entity.Source;
import cn.com.sk.jdbc.mapstruct.simple.cope.bean.entity.Target;
import org.junit.Test;

public class SimpleSourceToTargetMapperTest {
    /***
     * 简单测试对象拷贝
     */
    @Test
    public void SimpleSourceToTargetMapper(){
      Source source = new Source();
      source.setId(1L);
      source.setName("sunki");
      source.setSourceCode("dddd");

      Target target = SimpleSourceToTargetMapper.MAPPER.sourceToTarget(source);

      System.out.println(target);
    }

}