package cn.com.sk.javabasics.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.RandomAccess;

/**
 * @author sunkai
 * @title: BufferTest
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/2211:47
 */
public class ReadFileTest {


    public static void main(String[] args) throws IOException {
       /* RandomAccessFile randomAccessFile = new RandomAccessFile("G:\\bufferTest.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = channel.read(byteBuffer);
        while (read != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
        }*/

        /*BufferTest fcChannelTest = new BufferTest();
        fcChannelTest.readFile();*/
        /*Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        ByteBuffer bBuf =  ByteBuffer.wrap("你好孙凯".getBytes("utf-8"));

        CharBuffer cbuf = decoder.decode(bBuf);
        char[] tmp = new char[cbuf.length()];
        while (cbuf.hasRemaining()) {
            cbuf.get(tmp);
            System.out.print(new String(tmp));
        }*/

        final String str="IOStudy/src/NIOTest/FileCHannelTest.java";
        File file=new File("G:\\bufferTest.txt");
        try {
            FileChannel channel=new FileInputStream(file).getChannel();
            FileChannel out=new FileOutputStream("G:\\test.txt").getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            out.write(buffer);
            buffer.flip();
            Charset charset= Charset.forName("GBK");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.print(charBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void readFile() throws IOException {
        // 文件编码是utf8,需要用utf8解码
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();

        RandomAccessFile raFile = new RandomAccessFile("G:\\bufferTest.txt", "rw");
        FileChannel fChannel = raFile.getChannel();

        ByteBuffer bBuf = ByteBuffer.allocate(1024); // 缓存大小设置为32个字节。仅仅是测试用。
        //CharBuffer cBuf = CharBuffer.allocate(32);

        int bytesRead = fChannel.read(bBuf); // 从文件通道读取字节到buffer.
        char[] tmp = null; // 临时存放转码后的字符
        byte[] remainByte = null;// 存放decode操作后未处理完的字节。decode仅仅转码尽可能多的字节，此次转码不了的字节需要缓存，下次再转
        int leftNum = 0; // 未转码的字节数
        while (bytesRead != -1) {

            bBuf.flip(); // 切换buffer从写模式到读模式
            //decoder.decode(bBuf, cBuf, true); // 以utf8编码转换ByteBuffer到CharBuffer
           // bBuf =  ByteBuffer.wrap("你好孙凯".getBytes("utf-8"));
            CharBuffer cBuf = decoder.decode(bBuf);
            cBuf.flip(); // 切换buffer从写模式到读模式
            remainByte = null;
            leftNum = bBuf.limit() - bBuf.position();
            if (leftNum > 0) { // 记录未转换完的字节
                remainByte = new byte[leftNum];
                bBuf.get(remainByte, 0, leftNum);
            }

            // 输出已转换的字符
            tmp = new char[cBuf.length()];
            while (cBuf.hasRemaining()) {
                cBuf.get(tmp);
                System.out.print(new String(tmp));
            }

            bBuf.clear(); // 切换buffer从读模式到写模式
            cBuf.clear(); // 切换buffer从读模式到写模式
            if (remainByte != null) {
                bBuf.put(remainByte); // 将未转换完的字节写入bBuf，与下次读取的byte一起转换
            }
            bytesRead = fChannel.read(bBuf);
        }
        raFile.close();
    }
}
