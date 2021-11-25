package cn.com.sk.javabasics.netty.delimiterAndLength;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author sunkai
 * @title: EchoServer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/2420:27
 */
public class EchoServer {
    public void bind(int port){
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        EventLoopGroup eventExecutors1 = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(eventExecutors,eventExecutors1);
        serverBootstrap.channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ByteBuf delimiter = Unpooled.copiedBuffer("$_")
                                .getBytes());
                    }
                });

    }




}
