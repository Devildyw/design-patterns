package top.devildyw.FacadePattern;

import top.devildyw.FacadePattern.Facade.Computer;

/**
 * @author Devil
 * @since 2022-08-28-13:02
 *
 * 客户端角色 来使用外观角色
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        System.out.println("-----------------------------");
        computer.shutdown();
    }
}
