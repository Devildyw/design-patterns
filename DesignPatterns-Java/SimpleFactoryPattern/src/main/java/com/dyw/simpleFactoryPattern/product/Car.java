package com.dyw.simpleFactoryPattern.product;


import java.text.DateFormat;

/**
 * @author Devil
 * @date 2022-04-16-20:05
 * <br>
 * <strong>该类角色为简单工厂模式中的具体产品角色</strong>
 * <p>汽车继承自交通工具抽象类实现了抽象方法 并增加了自己专属的方法</p>
 */
public class Car extends Vehicles {

    @Override
    public void work() {
        System.out.println("Car is running");
    }

    /**
     * 汽车加油
     */
    public void refueling(){
        System.out.println("Car is refueling");
    }
}
