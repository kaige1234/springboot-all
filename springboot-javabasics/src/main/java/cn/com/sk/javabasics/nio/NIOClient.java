package cn.com.sk.javabasics.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author sunkai
 * @title: NIOClient
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/1911:13
 */
public class NIOClient {
    private Selector selector;

    public void init() throws IOException {
        this.selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8090);
        socketChannel.connect(socketAddress);
    }
    @SuppressWarnings("unchecked")
    public void listen() throws IOException {
       /* while(true){
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            if(iterator.hasNext()){
                SelectionKey selectionKey = (SelectionKey)iterator.next();
                iterator.remove();
                if(selectionKey.isConnectable()){
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    if(socketChannel.isConnectionPending()){
                        socketChannel.finishConnect();
                    }
                    socketChannel.configureBlocking(false);
                    ByteBuffer byteBuffer = ByteBuffer.wrap(new String("客户端发送的信息").getBytes());
                    socketChannel.write(byteBuffer);
                    socketChannel.register(this.selector,SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    this.read();
                }


            }
        }*/

        // 轮询访问selector
        while (true) {
            selector.select();
            // 获得selector中选中的项的迭代器
            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                // 删除已选的key,以防重复处理
                ite.remove();
                // 连接事件发生
                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key
                            .channel();
                    // 如果正在连接，则完成连接
                    if(channel.isConnectionPending()){
                        channel.finishConnect();

                    }
                    // 设置成非阻塞
                    channel.configureBlocking(false);

                    //在这里可以给服务端发送信息哦
                    channel.write(ByteBuffer.wrap(new String("向服务端发送了一条信息").getBytes()));
                    //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                    channel.register(this.selector, SelectionKey.OP_READ);

                    // 获得了可读的事件
                } else if (key.isReadable()) {
                    read(key);
                }

            }

        }
    }

    public void read(SelectionKey key) throws IOException {
        SocketChannel  channel = (SocketChannel)key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        int read = channel.read(byteBuffer);
        byte[] array = byteBuffer.array();
        String message = new String(array);
        System.out.println("客户端接收到的数据"+message);
    }

    public static void main(String[] args) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.init();
        nioClient.listen();
    }

}
