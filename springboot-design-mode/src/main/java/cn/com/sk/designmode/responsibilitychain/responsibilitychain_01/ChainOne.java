package cn.com.sk.designmode.responsibilitychain.responsibilitychain_01;

/**
 * @author sunkai
 * @title: ChainOne
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/119:08
 */
public class ChainOne extends AbstractChain {

    @Override
    public void handle(int request) {
        if(request%2 == 0){
            System.out.println("你好，ChainOne");
        }else{
            abstractChain.handle(request);
        }
    }
}
