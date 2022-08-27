package top.devildyw.DecorativeDesignPattern.Component;

/**
 * @author Devil
 * @since 2022-08-27-11:51
 * <p>
 * 抽象构建
 * <p>
 * 抽象构件定义了对象的接口，可以给这些对象动态增加职责（方法）
 * <p>
 * 饮料 装饰和被装饰者的父类
 */
public abstract class Beverage {
    /**
     * 获取饮料的描述
     * @return String
     */
    public abstract String getDescription();


    /**
     * 获取价格
     * @return double
     */
    public abstract double cost();
}
