package cn.com.sk.javabasics.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author sunkai
 * @title: ChildChinnalHandle
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/2320:06
 */
public class ChildChinnalHandle extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new TimeServerHandle());
    }
}
