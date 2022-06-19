package com.dyw.abstractFactory.factory;

import com.dyw.abstractFactory.product.phone.HuaweiPhone;
import com.dyw.abstractFactory.product.phone.Phone;
import com.dyw.abstractFactory.product.router.HuaweiRouter;
import com.dyw.abstractFactory.product.router.Router;

/**
 * @author Devil
 * @since 2022-06-19-16:25
 * <br>
 * <p>该类为抽象工厂设计模式中的具体工厂角色 Huawei产品生产工厂</p>
 * <p>该类继承了抽象父类ProductFactory 并且实现了它的两个抽象方法</p>
 * <p>该类的主要功能是生产Huawei的相关产品</p>
 */
public class HuaweiFactory extends ProductFactory{
    @Override
    public Phone getPhone() {
        //生产Huawei手机
        return new HuaweiPhone();
    }

    @Override
    public Router getRouter() {
        //生产Huawei路由器
        return new HuaweiRouter();
    }
}
