package cn.com.sk.javabasics.netty.tomcat.bio.servlet;

import cn.com.sk.javabasics.netty.tomcat.bio.http.TestRequest;
import cn.com.sk.javabasics.netty.tomcat.bio.http.TestResponst;
import cn.com.sk.javabasics.netty.tomcat.bio.http.TestServlet;

/**
 * @author sunkai
 * @title: SecondServlet
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1715:00
 */
public class SecondServlet extends TestServlet {

    @Override
    protected void doPost(TestRequest testRequest, TestResponst testResponst) {
        this.doGet(testRequest,testResponst);
    }

    @Override
    protected void doGet(TestRequest testRequest, TestResponst testResponst) {
        testResponst.write("second servlet");
    }
}
