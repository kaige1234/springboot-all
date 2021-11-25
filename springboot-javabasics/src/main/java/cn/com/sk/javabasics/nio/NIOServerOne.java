package cn.com.sk.javabasics.nio;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author sunkai
 * @title: NIOServerOne
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/2314:59
 */
public class NIOServerOne extends Thread{

    private Selector selector;

    private boolean status = true;

    public  NIOServerOne (){
        try{
            selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    @SneakyThrows
    @Override
    public void run() {
       while (status){
           selector.selectedKeys();
           Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
           if(iterator.hasNext()){
               SelectionKey next = iterator.next();
               iterator.remove();
               this.handleMes(next);
           }

       }
    }

    private void handleMes(SelectionKey selectionKey) throws IOException {
        if(selectionKey.isValid()){
            if(selectionKey.isAcceptable()){
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel)selectionKey.channel();
                SocketChannel accept = serverSocketChannel.accept();
                accept.configureBlocking(false);
                accept.register(selector,SelectionKey.OP_READ);
            }
            if(selectionKey.isReadable()){
                SocketChannel  socketChannel = (SocketChannel)selectionKey.channel();
                ByteBuffer byteBuffer =ByteBuffer.allocate(1024);
                int read = socketChannel.read(byteBuffer);
                if(read >0){
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    String string =  new String(bytes,"UTF-8");
                    System.out.println("获取到的数据为："+string);
                    this.doWrite( selectionKey);
                }
            }
        }
    }

    private void doWrite(SelectionKey selectionKey) {

    }

}
