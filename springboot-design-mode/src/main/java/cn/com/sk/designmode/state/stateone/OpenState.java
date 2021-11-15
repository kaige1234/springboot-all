package cn.com.sk.designmode.state.stateone;

/**
 * @author sunkai
 * @title: OpenState
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/317:18
 */
public class OpenState extends AbstactState{

    @Override
    public void open() {
        System.out.println("打开");
        context.setState(Context.closedState);
    }

    @Override
    public void closed() {
        System.out.println("OpenState 里没有关闭");
    }

    @Override
    public void run() {

    }
}
