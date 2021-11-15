package cn.com.sunkai.gateway.custom;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.CookieRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CustomRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomRoutePredicateFactory.Config> {

    public CustomRoutePredicateFactory() {
        super(CustomRoutePredicateFactory.Config.class);
    }


    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (exchange -> {
            HttpHeaders headers = exchange.getRequest().getHeaders();
            //判断头中是否带了某个值
            List<String> list = headers.get(config.getName());
            return list.size()>0;
        });
    }

    private static final String NAME_KEY="name";

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME_KEY);
    }


    public static class Config{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
