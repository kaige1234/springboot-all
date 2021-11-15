package cn.com.sk.designmode.command.commandone;

/**
 * @author sunkai
 * @title: CreateCommand
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/11/315:10
 */
public class CreateCommand extends AbstractCommand {

    public CreateCommand(Receive receive) {
        super(receive);
    }

    @Override
    public void excute() {
        receive.active();
    }
}
