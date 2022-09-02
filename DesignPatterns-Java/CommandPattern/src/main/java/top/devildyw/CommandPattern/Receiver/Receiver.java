package top.devildyw.CommandPattern.Receiver;

/**
 * @author Devil
 * @since 2022-09-01-22:57
 * <p>
 * 命令接收者
 * <p>
 * 正则执行命令的角色 命令对象内部会调用该对象的方法完成真正的命令
 */
public class Receiver {
    public void turnON() {
        System.out.println("执行开灯操作...");
    }

    public void turnOFF() {
        System.out.println("执行关灯操作...");
    }

}
