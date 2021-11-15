package cn.com.sk.designmode.command.commandone;

/**
 * @author sunkai
 * @title: Invoker
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/315:11
 */
public class Invoker {
    private AbstractCommand abstractCommand;

    public void setCommand(AbstractCommand abstractCommand){
        this.abstractCommand = abstractCommand;
    }

    public void excuteCommand(){
        abstractCommand.excute();
    }
}
