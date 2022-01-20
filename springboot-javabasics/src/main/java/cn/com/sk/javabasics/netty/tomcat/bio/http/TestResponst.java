package cn.com.sk.javabasics.netty.tomcat.bio.http;

import java.io.OutputStream;

/**
 * @author sunkai
 * @title: TestResponst
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1714:53
 */
public class TestResponst {

    private OutputStream outputStream;

    public TestResponst(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void write(String s) {
        try{
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("HTTP/1.1 200 ok\n")
                    .append("Content-Type: text/html;\n")
                    .append("\r\n")
                    .append(s);
            outputStream.write(stringBuffer.toString().getBytes());

        }catch (Exception  e){
            e.printStackTrace();
        }
    }
}
