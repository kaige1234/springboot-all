package cn.com.sk.javabasics.netty.communication;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author sunkai
 * @title: GroupChatClientHandler
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/2/1616:30
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<String> {




    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());
    }
}
