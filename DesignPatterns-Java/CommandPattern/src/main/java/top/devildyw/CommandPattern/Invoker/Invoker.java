package top.devildyw.CommandPattern.Invoker;

import top.devildyw.CommandPattern.Command.Command;

/**
 * @author Devil
 * @since 2022-09-01-22:59
 * <p>
 * 命令调用者 负责调用
 * <p>
 * 客户端通过将具体的命令对象创建后  传入该对象即可调用对应的方法
 */
public class Invoker {
    public void execute(Command command) {
        command.execute();
    }
}
