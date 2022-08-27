package top.devildyw.DecorativeDesignPattern.Decorator;

import top.devildyw.DecorativeDesignPattern.Component.Beverage;

/**
 * @author Devil
 * @since 2022-08-27-11:55
 * <p>
 * 抽象装饰类
 * <p>
 * 抽象装饰类是抽象构件类的子类，用于给具体构件增加职责，但是具体职责在其子类中实现
 */
public abstract class CondimentDecorator extends Beverage {
    //待装饰的对象
    private Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public Beverage getBeverage() {
        return beverage;
    }
}
