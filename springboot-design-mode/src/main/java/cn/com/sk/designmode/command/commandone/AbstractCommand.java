package cn.com.sk.designmode.command.commandone;

/**
 * @author sunkai
 * @title: AbstractCommand
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/315:06
 */
public abstract class AbstractCommand {
    public Receive receive;

    public AbstractCommand(Receive receive) {
        this.receive = receive;
    }

    public abstract  void excute();
}
