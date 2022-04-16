package com.dyw.simpleFactoryPattern.product;

/**
 * @author Devil
 * @date 2022-04-16-20:13
 * <br>
 * <strong>该类为简单工厂模式中的抽象产品角色</strong>
 * <p>基类</p>
 */
public abstract class Vehicles {
    /**
     * 交通工具的核心方法 "运行"
     */
    abstract public void work();
}
