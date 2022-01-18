package cn.com.sk.javabasics.netty.tomcat.bio.http;

/**
 * @author sunkai
 * @title: TestServlet
 * @projectName springboot-all
 * @description: TODO
 * @date 2022/1/1714:51
 */
public abstract class TestServlet {

    public void service(TestRequest testRequest,TestResponst testResponst){
        if("GET".equalsIgnoreCase(testRequest.getMethod())){
            doGet(testRequest,testResponst);
        }else{
            doPost(testRequest,testResponst);
        }

    }

    protected abstract void doPost(TestRequest testRequest, TestResponst testResponst);

    protected abstract void doGet(TestRequest testRequest, TestResponst testResponst);

}
