package com.dyw.builderPattern.staticType.client;

import com.dyw.builderPattern.staticType.product.Computer;

/**
 * @author Devil
 * @since 2022-06-20-19:16
 * <br>
 * <h1>演示类 向读者演示建造者设计模式 方便读者的理解</h1>
 */
public class Client {
    public static void main(String[] args) {
        //静态内部类好处就是可以链式调用 并且在继承了传统模式的优点下 免去了Director和Builder两个角色 使得代码更简洁更直观
        Computer computer = new Computer.Builder("I9", "三星")
                .setUsbCount(2)
                .setKeyBoard("罗技")
                .setDisPlay("三星24寸")
                .builder();
        //检验
        System.out.println(computer);
    }
}
