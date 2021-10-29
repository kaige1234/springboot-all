package cn.com.sk.designmode.midiator.mediatorone;

/**
 * @author sunkai
 * @title: AbstractCollergue
 * @projectName springboot-all
 * @description: TODO
 * @date 2021/10/2612:35
 */
public abstract class AbstractCollergue {

    public AbstractMidiator abstractMidiator;

    public AbstractCollergue(AbstractMidiator abstractMidiator) {
        this.abstractMidiator = abstractMidiator;
    }
}
