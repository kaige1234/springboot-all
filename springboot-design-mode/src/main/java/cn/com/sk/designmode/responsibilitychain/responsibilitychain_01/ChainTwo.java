package cn.com.sk.designmode.responsibilitychain.responsibilitychain_01;

/**
 * @author sunkai
 * @title: ChainTwo
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/119:09
 */
public class ChainTwo extends AbstractChain {

    @Override
    public void handle(int request) {
       if(request%2 == 0){
           System.out.println("你好，ChainTwo");
       }else{
           abstractChain.handle(request);
       }
    }
}
