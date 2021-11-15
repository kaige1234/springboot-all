package cn.com.sk.designmode.state.stateone;

/**
 * @author sunkai
 * @title: Context
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/317:14
 */
public class Context {
    public static OpenState openState = new OpenState();
    public static ClosedState closedState = new ClosedState();
    private AbstactState abstactState;

    public AbstactState getState(){
        return abstactState;
    }

    public void setState(AbstactState abstactState){
        this.abstactState = abstactState;
        abstactState.setContext(this);
    }

    public void open(){
        abstactState.open();
    }

    public void closed(){
        abstactState.closed();
    }

}
