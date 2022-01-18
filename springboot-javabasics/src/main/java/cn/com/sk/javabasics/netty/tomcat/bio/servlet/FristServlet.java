package cn.com.sk.javabasics.netty.tomcat.bio.servlet;

import cn.com.sk.javabasics.netty.tomcat.bio.http.TestRequest;
import cn.com.sk.javabasics.netty.tomcat.bio.http.TestResponst;
import cn.com.sk.javabasics.netty.tomcat.bio.http.TestServlet;

/**
 * @author sunkai
 * @title: FristServlet
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1714:57
 */
public class FristServlet extends TestServlet {
    @Override
    protected void doPost(TestRequest testRequest, TestResponst testResponst) {
        testResponst.write("this is frist servlet from BIO");
    }

    @Override
    protected void doGet(TestRequest testRequest, TestResponst testResponst) {
        this.doPost(testRequest,testResponst);
    }
}
