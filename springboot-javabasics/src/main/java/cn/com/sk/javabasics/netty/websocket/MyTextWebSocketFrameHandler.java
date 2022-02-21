package cn.com.sk.javabasics.netty.websocket;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.EventExecutorGroup;

import java.time.LocalDateTime;

/**
 * @author sunkai
 * @title: MyTextWebSocketFrameHandler
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/2/1815:46
 */
public class MyTextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("服务器消息"+msg.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间"+ LocalDateTime.now()+""+msg.text()));

    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx){
        System.out.println("handlerAdded 被调用"+ctx.channel().id().asLongText());
        System.out.println("handlerAdded 被调用"+ctx.channel().id().asShortText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx){
        System.out.println("handlerRemoved 被调用"+ctx.channel().id().asLongText());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable th){
        System.out.println(""+th.getMessage());
        ctx.close();
    }


}
