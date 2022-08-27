package top.devildyw.DecorativeDesignPattern.ConcreteComponent;

import top.devildyw.DecorativeDesignPattern.Component.Beverage;

/**
 * @author Devil
 * @since 2022-08-27-11:54
 * <p>
 * 黑烤
 * <p>
 * 具体构建 实现了抽象构建种的基本方法 满足一般的基本功能
 * <p>
 * 具体构件定义了具体的构件对象，实现了 在抽象构件中声明的方法，装饰器可以给它增加额外的职责（方法）
 */
public class DarkRoast extends Beverage {
    /**
     * 实现父类抽象类定义的职责 作为一种饮料他有自己的描述和价格
     * @return
     */
    @Override
    public String getDescription() {
        return "DarkRoast";
    }

    @Override
    public double cost() {
        return 2.3;
    }
}
