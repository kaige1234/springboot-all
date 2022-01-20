package cn.com.sk.javabasics.netty.rpc.provider;

import cn.com.sk.javabasics.netty.rpc.api.IRpcHelloService;

/**
 * @author sunkai
 * @title: RpcHelloService
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1714:13
 */
public class RpcHelloService implements IRpcHelloService {
    @Override
    public String hello() {
        return "hello";
    }
}
