package cn.com.sk.javabasics.nio.demo;

import org.springframework.expression.spel.ast.Selection;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sunkai
 * @title: NIODemoServer
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1810:22
 */
public class NIODemoServer extends  Thread{
    private Selector selector;

    public static void main(String[] args) {
        NIODemoServer nioDemoServer = new NIODemoServer();
        nioDemoServer.start();
        System.out.println("主线程运行结束");
    }

    @Override
    public void run() {
        try {
            System.out.println("线程运行结束");
            selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                if(iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if(selectionKey.isAcceptable()){
                        ServerSocketChannel ssChannel = (ServerSocketChannel)selectionKey.channel();
                        SocketChannel socketChannel = ssChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else if(selectionKey.isReadable()){
                        SocketChannel channel = (SocketChannel)selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int read = channel.read(byteBuffer);
                        if(read >0 ){
                            byteBuffer.flip();
                            String content = new String(byteBuffer.array(),0,read);
                            channel.register(selector,SelectionKey.OP_WRITE);
                            System.out.println("content = " + content);
                        }
                    }else if(selectionKey.isWritable()){
                        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        StringBuffer message = new StringBuffer();
                        message.append("HTTP/1.1 200 ok\n")
                                .append("Content-Type: text/html;\n")
                                .append("\r\n")

                                .append("<input value='hello ,My name is lilei'/>");
                        byte[] bytes = message.toString().getBytes();
                        socketChannel.write(ByteBuffer.wrap(bytes));
                        socketChannel.register(selector,SelectionKey.OP_READ);
                        socketChannel.close();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }










}
