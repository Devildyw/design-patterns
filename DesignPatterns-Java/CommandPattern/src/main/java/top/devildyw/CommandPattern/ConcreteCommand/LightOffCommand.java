package top.devildyw.CommandPattern.ConcreteCommand;

import top.devildyw.CommandPattern.Command.Command;
import top.devildyw.CommandPattern.Receiver.Receiver;

/**
 * @author Devil
 * @since 2022-09-01-22:56
 * <p>
 * 具体命令对象
 * <p>
 * 将会调用命令接收的方法 只是将一条一条的命令封装成了对象(请求) 命令始终是命令 真正执行的是接收命令的并执行的角色
 */
public class LightOffCommand implements Command {
    private Receiver receiver;

    public LightOffCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOFF();
    }
}
