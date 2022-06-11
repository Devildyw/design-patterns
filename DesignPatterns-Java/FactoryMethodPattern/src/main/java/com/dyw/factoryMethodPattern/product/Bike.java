package com.dyw.factoryMethodPattern.product;

/**
 * @author Devil
 * @since 2022-06-11-20:13
 * <br>
 * <strong>该类角色为工厂方法设计模式中的具体产品角色</strong>
 * <p>自行车继承自交通工具抽象类实现了抽象方法</p>
 */
public class Bike extends Vehicles {
    @Override
    public void work() {
        System.out.println("Bike is running");
    }

}
