package top.devildyw.DecorativeDesignPattern.ConcreteDecorator;

import top.devildyw.DecorativeDesignPattern.Component.Beverage;
import top.devildyw.DecorativeDesignPattern.Decorator.CondimentDecorator;

/**
 * @author Devil
 * @since 2022-08-27-11:58
 */
public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription()+"Whip";
    }

    @Override
    public double cost() {
        return getBeverage().cost()+.10;
    }
}
