package com.dyw.abstractFactory.factory;

import com.dyw.abstractFactory.product.phone.Phone;
import com.dyw.abstractFactory.product.phone.XiaomiPhone;
import com.dyw.abstractFactory.product.router.Router;
import com.dyw.abstractFactory.product.router.XiaomiRouter;

/**
 * @author Devil
 * @since 2022-06-19-16:24
 * <br>
 * <p>该类为抽象工厂设计模式中的具体工厂角色 Xiaomi产品生产工厂</p>
 * <p>该类继承了抽象父类ProductFactory 并且实现了它的两个抽象方法</p>
 * <p>该类的主要功能是生产Xiaomi的相关产品</p>
 */
public class XiaomiFactory extends ProductFactory{
    @Override
    public Phone getPhone() {
        //生产Xiaomi手机
        return new XiaomiPhone();
    }

    @Override
    public Router getRouter() {
        //生产Xiaomi路由器
        return new XiaomiRouter();
    }
}
