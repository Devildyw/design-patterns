package com.dyw.abstractFactory.product.router;

/**
 * @author Devil
 * @since 2022-06-19-16:12
 * <br>
 * <strong>该类为抽象工厂模式中的抽象产品角色 路由器产品</strong>
 * <p>基类</p>
 */
public abstract class Router {
    /**
     * 抽象方法 打开wifi
     */
    public abstract void openWifi();

    /**
     * 抽象方法 设置
     */
    public abstract void setting();
}
