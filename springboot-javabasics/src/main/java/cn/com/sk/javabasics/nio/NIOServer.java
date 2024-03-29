package cn.com.sk.javabasics.nio;

import org.springframework.expression.spel.ast.Selection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author sunkai
 * @title: NIOServer
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/1910:33
 */
public class NIOServer {

    private  Selector selector;

    public void initServer() throws IOException {
        // 获得一个通道管理器
        this.selector = Selector.open();
        // 获得一个ServerSocket通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 将该通道对应的ServerSocket绑定到port端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8090);
        //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
        //当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
        ServerSocketChannel bind = serverSocketChannel.bind(inetSocketAddress);
        SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

    }
    @SuppressWarnings("unchecked")
    public void listen() throws IOException {
        /*while(true){
            selector.select();
            Iterator iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = (SelectionKey)iterator.next();
                iterator.remove();
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel accept = serverSocketChannel.accept();
                    serverSocketChannel.configureBlocking(false);
                    accept.write(ByteBuffer.wrap(new String("我要发送的信息").getBytes()));
                    serverSocketChannel.register(this.selector,SelectionKey.OP_READ);

                }else if(selectionKey.isReadable()){
                    this.read(selectionKey);
                }
            }
        }*/
        System.out.println("服务端启动成功！");
        // 轮询访问selector
        while (true) {
            //当注册的事件到达时，方法返回；否则,该方法会一直阻塞
            selector.select();
            // 获得selector中选中的项的迭代器，选中的项为注册的事件
            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                // 删除已选的key,以防重复处理
                ite.remove();
                // 客户端请求连接事件
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key
                            .channel();
                    // 获得和客户端连接的通道
                    SocketChannel channel = server.accept();
                    // 设置成非阻塞
                    channel.configureBlocking(false);

                    //在这里可以给客户端发送信息哦
                    channel.write(ByteBuffer.wrap(new String("向客户端发送了一条信息").getBytes()));
                    //在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
                    channel.register(this.selector, SelectionKey.OP_READ);

                    // 获得了可读的事件
                } else if (key.isReadable()) {
                    read(key);
                }

            }

        }
    }

    private void read(SelectionKey selectionKey) throws IOException {
        SocketChannel  channel = (SocketChannel)selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        int read = channel.read(byteBuffer);
        byte[] array = byteBuffer.array();
        String message = new String(array);
        System.out.println("服务端接收到的数据"+message);
        ByteBuffer buffer = ByteBuffer.wrap(new String("服务端返回数据").getBytes());
        channel.write(buffer);


    }


    public static void main(String[] args) throws IOException {

        NIOServer server = new NIOServer();
        server.initServer();
        server.listen();
    }



}
