package cn.com.sk.designmode.responsibilitychain.responsibilitychain_01;

/**
 * @author sunkai
 * @title: ChainThree
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/119:11
 */
public class ChainThree extends AbstractChain {

    @Override
    public void handle(int request) {
        if(request%2 == 0){
            System.out.println("你好，ChainThree");
        }else{
            abstractChain.handle(request);
        }
    }
}
