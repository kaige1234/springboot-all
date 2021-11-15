package cn.com.sk.designmode.responsibilitychain.responsibilitychain_01;

/**
 * @author sunkai
 * @title: AbstractChain
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/118:51
 */
public abstract class AbstractChain {

    public AbstractChain abstractChain;

    public void setChain(AbstractChain abstractChain){
        this.abstractChain = abstractChain;
    }

    public abstract void handle(int request);
}
