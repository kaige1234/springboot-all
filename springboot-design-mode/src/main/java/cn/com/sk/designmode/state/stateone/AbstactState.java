package cn.com.sk.designmode.state.stateone;

/**
 * @author sunkai
 * @title: AbstactState
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/317:13
 */
public abstract class AbstactState {
    public Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract  void closed();

    public abstract void run();
}
