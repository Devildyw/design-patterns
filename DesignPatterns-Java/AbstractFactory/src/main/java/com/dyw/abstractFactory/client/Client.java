package com.dyw.abstractFactory.client;

import com.dyw.abstractFactory.factory.HuaweiFactory;
import com.dyw.abstractFactory.factory.ProductFactory;
import com.dyw.abstractFactory.factory.XiaomiFactory;
import com.dyw.abstractFactory.product.phone.Phone;
import com.dyw.abstractFactory.product.router.Router;

/**
 * @author Devil
 * @since 2022-06-19-16:31
 * <br>
 * <Strong>测试类</Strong>
 * <p>为读者演示抽象工厂设计模式是否有效且方便读者观看做一个演示</p>
 *
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=============小米系列=============");
        ProductFactory productFactory = new XiaomiFactory();
        Phone phone = productFactory.getPhone();
        phone.callUp();
        phone.sendSMS();
        Router router = productFactory.getRouter();
        router.openWifi();
        router.openWifi();
        System.out.println("=============华为系列=============");
        productFactory = new HuaweiFactory();
        phone = productFactory.getPhone();
        phone.callUp();
        phone.sendSMS();
        router = productFactory.getRouter();
        router.openWifi();
        router.setting();
    }
}
