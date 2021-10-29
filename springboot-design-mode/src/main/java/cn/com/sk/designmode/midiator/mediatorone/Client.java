package cn.com.sk.designmode.midiator.mediatorone;

/**
 * @author sunkai
 * @title: Client
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2614:03
 */
public class Client {

    public static void main(String[] args){
        AbstractMidiator abstractMidiator = new CreaterMidiator();

        CreateCollergueA createCollergueA =  new CreateCollergueA(abstractMidiator);
        CreateCollergueB createCollergueB = new CreateCollergueB(abstractMidiator);
        ((CreaterMidiator) abstractMidiator).setCreateCollergue(createCollergueA);
        ((CreaterMidiator) abstractMidiator).setCreateCollergueB(createCollergueB);
        createCollergueA.send("createCollergueA");
        createCollergueB.send("createCollergueB");

    }
}
