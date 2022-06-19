package com.dyw.abstractFactory.product.phone;

/**
 * @author Devil
 * @since 2022-06-19-16:14
 * <br>
 * <p>该类为抽象工厂设计模式中的具体产品角色</p>
 * <p>Huawei手机 继承了Phone这个抽象父类并且实现了他的两个方法</p>
 */
public class HuaweiPhone extends Phone{
    @Override
    public void callUp() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("华为手机发送短信");
    }
}
