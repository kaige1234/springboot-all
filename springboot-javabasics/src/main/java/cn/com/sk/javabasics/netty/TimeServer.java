package cn.com.sk.javabasics.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author sunkai
 * @title: TimeServer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/2319:58
 */
public class TimeServer {

    public void bind(int port) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChinnalHandle());
            //绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            //等待服务端监听端口关闭
            f.channel().closeFuture().sync();


        }catch (Exception e){
            //优雅的退出
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();



        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if(args != null && args.length  >0 ){
            try{

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        new TimeServer().bind(port);
    }


}
