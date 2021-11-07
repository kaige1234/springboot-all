package cn.com.sk.lamd.defaultinerface.lamd.functional;

public class Test {


    public static void main(String[] args){
        NoReturnMultiParam noReturnMultiParam = (a,b)->{
            System.out.println(a+","+b);
        };
        noReturnMultiParam.method(1,4);
    }
}
