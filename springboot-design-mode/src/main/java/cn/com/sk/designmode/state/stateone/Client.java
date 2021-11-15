package cn.com.sk.designmode.state.stateone;

/**
 * @author sunkai
 * @title: Client
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/317:12
 */
public class Client {
    public static void main(String[] args){
        Context context = new Context();
        context.setState(new OpenState());
        context.open();
        context.closed();
    }
}
