package com.dyw.factoryMethodPattern.product;

/**
 * @author Devil
 * @since 2022-06-11-20:13
 * <br>
 * <strong>该类角色为工厂方法设计模式中的具体产品角色</strong>
 * <p>火车继承自交通工具抽象类实现了抽象方法 并增加了自己专属的方法</p>
 */
public class Train extends Vehicles {
    @Override
    public void work() {
        System.out.println("Train is running");
    }

    /**
     * 切换轨道
     */
    public void switchTrack() {
        System.out.println("Train is switch Track");
    }
}
