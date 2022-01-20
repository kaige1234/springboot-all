package cn.com.sk.javabasics.netty.tomcat.bio;

import cn.com.sk.javabasics.netty.tomcat.bio.http.TestRequest;
import cn.com.sk.javabasics.netty.tomcat.bio.http.TestResponst;
import cn.com.sk.javabasics.netty.tomcat.bio.http.TestServlet;
import net.sf.cglib.core.ClassNameReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author sunkai
 * @title: TestTomcat
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1715:20
 */
public class TestTomcat implements Runnable{
    private int port = 8080;
    private ServerSocket serverSocket ;
    private Map<String, TestServlet> servletMap = new HashMap<String,TestServlet>();
    private Properties properties = new Properties();
    private void init(){
        try{
            String path = this.getClass().getResource("/").getPath();
            FileInputStream fis = new FileInputStream(path+"web.properties");
            properties.load(fis);
            for(Object obj: properties.keySet()){
                String key = obj.toString();
                if(key.endsWith(".url")){
                    String url = (String)properties.get(key);
                    String className = key.replace(".url","");
                    String forName = (String) properties.get(className + ".className");
                    TestServlet servlet = (TestServlet)Class.forName(forName).newInstance();
                    servletMap.put(url,servlet);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new TestTomcat());
        thread.start();
        System.out.println("TestTomcat 线程启动完成");
    }

    @Override
    public void run() {
        init();
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("启动接口监听"+port);
            while(true){
                Socket accept = serverSocket.accept();
                this.process(accept);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void process(Socket client) {
        try{
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            TestRequest testRequest = new TestRequest(inputStream);
            TestResponst testResponst = new TestResponst(outputStream);

            String url = testRequest.getUrl();

            if(properties.contains(url)){
                servletMap.get(url).service(testRequest,testResponst);
            }else{
                testResponst.write("404 - 没有找到");
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
