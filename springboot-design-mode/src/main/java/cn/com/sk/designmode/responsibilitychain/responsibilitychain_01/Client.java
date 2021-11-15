package cn.com.sk.designmode.responsibilitychain.responsibilitychain_01;

/**
 * @author sunkai
 * @title: Client
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/119:12
 */
public class Client {
    public static void main(String[] args){
        ChainOne chainOne = new ChainOne();
        ChainTwo chainTwo = new ChainTwo();
        ChainThree chainThree = new ChainThree();
        ChainDefault chainDefault = new ChainDefault();
        chainOne.setChain(chainTwo);
        chainTwo.setChain(chainThree);
        chainThree.setChain(chainDefault);
        for(int i=0;i<10;i++){
            chainOne.handle(i);
        }

    }
}
