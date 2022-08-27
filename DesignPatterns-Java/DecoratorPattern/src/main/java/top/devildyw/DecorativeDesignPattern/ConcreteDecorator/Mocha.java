package top.devildyw.DecorativeDesignPattern.ConcreteDecorator;

import top.devildyw.DecorativeDesignPattern.Component.Beverage;
import top.devildyw.DecorativeDesignPattern.Decorator.CondimentDecorator;

/**
 * @author Devil
 * @since 2022-08-27-11:56
 * <p>
 * 具体装饰类
 * <p>
 * 对具体构建进行装饰 实现抽象装饰类种对具体构建新增的职责
 * <p>
 * 具体装饰类是抽象装饰类的子类，负责向构 件添加新的职责。
 *
 * 摩卡 这里用来修饰饮料DarkRoast 摩卡口味的
 */
public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + "Mocha";
    }

    @Override
    public double cost() {
        return getBeverage().cost() + .20;
    }
}
