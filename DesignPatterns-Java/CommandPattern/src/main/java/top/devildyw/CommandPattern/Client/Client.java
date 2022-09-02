package top.devildyw.CommandPattern.Client;

import top.devildyw.CommandPattern.ConcreteCommand.LightOffCommand;
import top.devildyw.CommandPattern.ConcreteCommand.LightOnCommand;
import top.devildyw.CommandPattern.Invoker.Invoker;
import top.devildyw.CommandPattern.Receiver.Receiver;

/**
 * @author Devil
 * @since 2022-09-01-23:04
 * <p>
 * 客户端
 * <p>
 * 用户发送请求的客户端
 */
public class Client {
    public static void main(String[] args) {
        //配置客户端
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker();
        //创建请求
        LightOnCommand lightOnCommand = new LightOnCommand(receiver);
        LightOffCommand lightOffCommand = new LightOffCommand(receiver);
        //发送请求 并执行
        invoker.execute(lightOnCommand);
        invoker.execute(lightOffCommand);
    }
}
