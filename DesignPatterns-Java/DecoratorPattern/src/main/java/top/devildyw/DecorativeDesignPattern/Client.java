package top.devildyw.DecorativeDesignPattern;

import top.devildyw.DecorativeDesignPattern.Component.Beverage;
import top.devildyw.DecorativeDesignPattern.ConcreteComponent.DarkRoast;
import top.devildyw.DecorativeDesignPattern.ConcreteDecorator.Mocha;
import top.devildyw.DecorativeDesignPattern.ConcreteDecorator.Whip;

/**
 * @author Devil
 * @since 2022-08-27-11:59
 *
 * 测试
 */
public class Client {
    public static void main(String[] args) {
        //声明了具体构建
        Beverage beverage = new DarkRoast();
        System.out.println(beverage.getDescription()+" $ "+beverage.cost());

        //对其进行装饰
        Mocha mocha = new Mocha(beverage);
        System.out.println(mocha.getDescription()+" $ "+mocha.cost());

        Whip whip = new Whip(beverage);
        System.out.println(whip.getDescription()+" $ "+ whip.cost());
    }
}
