package top.devildyw.CommandPattern.ConcreteCommand;

import top.devildyw.CommandPattern.Command.Command;
import top.devildyw.CommandPattern.Receiver.Receiver;

/**
 * @author Devil
 * @since 2022-09-01-22:57
 * <p>
 * 具体命令对象
 */
public class LightOnCommand implements Command {

    private Receiver receiver;

    public LightOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnON();
    }
}
