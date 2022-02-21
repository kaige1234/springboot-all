package cn.com.sk.javabasics.netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author sunkai
 * @title: TestNettyHandler
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/2717:52
 */
public class TestNettyHandler extends ChannelHandlerAdapter {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        super.handlerAdded(ctx);
    }
}
