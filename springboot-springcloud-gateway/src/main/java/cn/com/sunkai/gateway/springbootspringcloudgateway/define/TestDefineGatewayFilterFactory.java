package cn.com.sunkai.gateway.springbootspringcloudgateway.define;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
@Component
@Slf4j
public class TestDefineGatewayFilterFactory
        extends AbstractGatewayFilterFactory<TestDefineGatewayFilterFactory.TestConfig> {
    private static String name="Test_Define";

    public TestDefineGatewayFilterFactory() {
        super(TestConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(name);
    }

    @Override
    public GatewayFilter apply(TestConfig config) {
        return ((exchange,chain)->{
            log.info("调用了该链路");
            //TODO 处理业务逻辑
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                //TODO 调用返回的信息 需要业务逻辑处理就写在该处
                log.info("调用的返回");
            }));
        });
    }

    public static class TestConfig{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
