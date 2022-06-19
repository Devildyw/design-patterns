package com.dyw.abstractFactory.product.phone;

/**
 * @author Devil
 * @since 2022-06-19-16:10
 * <br>
 * <strong>该类为抽象工厂模式中的抽象产品角色 手机产品</strong>
 * <p>基类</p>
 */
public abstract class Phone {
    /**
     * 抽象方法 打电话
     */
    public abstract void callUp();

    /**
     * 抽象方法 发送短信
     */
    public abstract void sendSMS();
}
