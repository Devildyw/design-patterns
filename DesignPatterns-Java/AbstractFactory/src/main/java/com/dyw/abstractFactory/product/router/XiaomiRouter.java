package com.dyw.abstractFactory.product.router;

/**
 * @author Devil
 * @since 2022-06-19-16:14
 * <br>
 * <p>该类为抽象工厂设计模式中的具体产品角色</p>
 * <p>Xiaomi路由器 继承了Router这个抽象父类并且实现了他的两个抽象方法</p>
 */
public class XiaomiRouter extends Router{
    @Override
    public void openWifi() {
        System.out.println("小米路由器打开wifi");
    }

    @Override
    public void setting() {
        System.out.println("小米路由器设置");
    }
}
