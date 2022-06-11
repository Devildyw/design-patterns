package com.dyw.factoryMethodPattern.factory;

import com.dyw.factoryMethodPattern.product.Vehicles;

/**
 * @author Devil
 * @since 2022-06-11-21:52
 *
 * <br>
 * <p><strong>工厂方法设计模式 该类为抽象工厂角色</strong></p>
 * <p>
 * 这里创建了一个抽象的工厂类 是为了让具体工厂的子类来实现这个特定的方法 以便于生产产品
 * 之所以这样便于生产产品是相较于简单工厂设计模式的，简单工厂设计模式生产产品是将生产过程耦合在了一起
 * 这样在产品不多的时候或是产品种类确定不会经常改变时较为好用，但是我们实际生产中很难确定自己的产品种类就一定不变
 * 所以我们可以使用工厂方法设计模式，他不在原来的类上进行修改，而是给出了一个抽象类 新添加的产品需要创建一个具体工厂类
 * 实现具体的抽象方法以便于创建具体的产品。符合开闭原则的同时也避免了简单工厂设计模式的高耦合性。
 * </p>
 */
public abstract class VehiclesFactory {
    /**
     * 抽象方法<br>
     * 具体工厂继承该类并且实现该抽象方法
     *
     * @return Vehicles
     * @author Devil
     */
    public abstract Vehicles createProduct();
}
