package cn.com.sk.javabasics.netty.tomcat.bio.http;

import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author sunkai
 * @title: TestRequest
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1714:53
 */
public class TestRequest {

    private String method;
    private String url;


    public TestRequest(InputStream is){
        try{
            String content ="";
            byte[] byteBuffer = new byte[1025];
            int let = 0;
            if((let = is.read(byteBuffer)) >0){
                content = new String(byteBuffer,0,let);
            }
            System.out.println("TestRequest获取到的内容为："+content);

            String line = content.split("\\n")[0];
            String[] arr = line.split("\\s");
            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];
            System.out.println("arr = " + arr);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public String getMethod() {
        return method;
    }

    public String getUrl(){
        return url;
    }
}
