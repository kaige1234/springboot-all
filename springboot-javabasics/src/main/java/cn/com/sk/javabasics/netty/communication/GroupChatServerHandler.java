package cn.com.sk.javabasics.netty.communication;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sunkai
 * @title: GroupChatServerHandler
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/2/1614:32
 */
public class GroupChatServerHandler
        extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * handlerAdded 表示连接建立，一旦连接，第一个被执行
     * @param ctx
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx){
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+"加入聊天"
                +sdf.format(new Date())+"\n");
        channelGroup.add(channel);
    }

    /**
     * 断开链接，将xx 客户离开信息推送给当前在线的客户
     * @param ctx
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx){
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+"离开了\n");
        System.out.println("channelGroup size"+channelGroup.size());
    }

    /**
     * 表示 channel 处于不活动状态，提示 xx 离线了
     * @param ctx
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx){
        System.out.println(ctx.channel().remoteAddress()+"离线了");
    }


    /**
     * 读取数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //获取到当前channel
        Channel channel = ctx.channel();

        //这时我们遍历channelGroup,根据不同的情况，回送不同的消息
        channelGroup.forEach(ch->{
            if(channel != ch){
                ch.writeAndFlush("[客户]"+channel.remoteAddress()+"发送了消息"+msg+"\n");
            }else{
                ch.writeAndFlush("[自己]发送了消息"+msg+"\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable caues) throws Exception{
        //关闭通道
        ctx.close();
    }
}
