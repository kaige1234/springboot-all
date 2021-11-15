package cn.com.sk.designmode.responsibilitychain.responsibilitychain_01;

/**
 * @author sunkai
 * @title: ChainDefault
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/119:51
 */
public class ChainDefault extends AbstractChain {

    @Override
    public void handle(int request) {
        System.out.println("默认处理"+request);
    }
}
