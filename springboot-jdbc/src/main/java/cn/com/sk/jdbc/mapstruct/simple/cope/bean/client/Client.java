package cn.com.sk.jdbc.mapstruct.simple.cope.bean.client;

import cn.com.sk.jdbc.mapstruct.simple.cope.bean.entity.Source;
import cn.com.sk.jdbc.mapstruct.simple.cope.bean.entity.Target;
import cn.com.sk.jdbc.mapstruct.simple.cope.bean.mapper.SimpleSourceToTargetMapper;

public class Client {
    public static void main(String[] args) {
        Source source = new Source();
        source.setId(1L);
        source.setName("sunki");
        source.setSourceCode("dddd");

        Target target = SimpleSourceToTargetMapper.MAPPER.sourceToTarget(source);

        System.out.println(target);
    }
}
