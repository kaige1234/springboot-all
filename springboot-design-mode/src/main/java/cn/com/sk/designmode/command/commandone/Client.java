package cn.com.sk.designmode.command.commandone;

/**
 * @author sunkai
 * @title: Client
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/315:15
 */
public class Client {
    public static void main(String[] args){
        Receive receive = new Receive();
        AbstractCommand abstractCommand = new CreateCommand(receive);
        Invoker invoker = new Invoker();
        invoker.setCommand(abstractCommand);
        invoker.excuteCommand();
    }

}
