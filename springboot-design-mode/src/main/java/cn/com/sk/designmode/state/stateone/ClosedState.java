package cn.com.sk.designmode.state.stateone;

/**
 * @author sunkai
 * @title: OpenState
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/317:18
 */
public class ClosedState extends AbstactState{


    @Override
    public void open() {

    }

    @Override
    public void closed() {
        System.out.println("ClosedState 关闭了");
    }

    @Override
    public void run() {

    }
}
