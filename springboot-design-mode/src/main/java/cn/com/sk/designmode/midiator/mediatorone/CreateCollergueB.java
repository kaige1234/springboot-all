package cn.com.sk.designmode.midiator.mediatorone;

/**
 * @author sunkai
 * @title: CreateCollergue
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2612:38
 */
public class CreateCollergueB extends AbstractCollergue{
    public CreateCollergueB(AbstractMidiator abstractMidiator) {
        super(abstractMidiator);
    }

    public void send(String message){
        abstractMidiator.send(message,this);
    }

    public void notify(String message){
        System.out.println(message);
    }
}
