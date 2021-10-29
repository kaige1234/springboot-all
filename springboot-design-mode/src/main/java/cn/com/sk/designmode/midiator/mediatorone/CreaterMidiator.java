package cn.com.sk.designmode.midiator.mediatorone;

/**
 * @author sunkai
 * @title: CreaterMidiator
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2612:36
 */
public class CreaterMidiator extends AbstractMidiator {

    private CreateCollergueA createCollergueA;

    private CreateCollergueB createCollergueB;

    public CreateCollergueA getCreateCollergue() {
        return createCollergueA;
    }

    public void setCreateCollergue(CreateCollergueA createCollergue) {
        this.createCollergueA = createCollergue;
    }

    public CreateCollergueB getCreateCollergueB() {
        return createCollergueB;
    }

    public void setCreateCollergueB(CreateCollergueB createCollergueB) {
        this.createCollergueB = createCollergueB;
    }

    @Override
    public void send(String message, AbstractCollergue collergue) {
        if(createCollergueA.equals(collergue)){
            createCollergueB.notify(message);
        }else{
            createCollergueA.notify(message);
        }
    }
}
