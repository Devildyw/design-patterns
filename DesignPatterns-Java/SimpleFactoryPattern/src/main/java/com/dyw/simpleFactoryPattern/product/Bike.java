package com.dyw.simpleFactoryPattern.product;

/**
 * @author Devil
 * @date 2022-04-16-20:05
 * <br>
 * <strong>该类角色为简单工厂模式中的具体产品角色</strong>
 * <p>自行车继承自交通工具抽象类实现了抽象方法</p>
 */
public class Bike extends Vehicles {
    @Override
    public void work() {
        System.out.println("Bike is running");
    }

}
