package com.dyw.abstractFactory.factory;

import com.dyw.abstractFactory.product.phone.Phone;
import com.dyw.abstractFactory.product.router.Router;

/**
 * @author Devil
 * @since 2022-06-19-16:21
 * <br>
 * <p>该类为抽象工程设计模式中的抽象工厂角色</p>
 * <p>
 *     有时我们可能不会只需要一种产品,而是需要一类产品,这个类由生产者决定。比如我想买小米全家桶或是华为全家桶，如果还是按照一个工厂对应一个产品 这样的生产模式显然不符要求
 *     所以我们引入了抽象工厂设计模式， 他将产品进行分级 比如小米手机和华为手机可以统称为手机 被分为手机类。同时也对产品进行分族，产品族是指由同一个工厂生产的。
 *     通过这样的定义我们就可以对产品进行分级管理分族生产了，同时它也具有较高的低耦合性。
 * </p>
 * <p>
 *     当我们所需生产的具体产品并不是一个简单的对象，而是多个位于不同产品等级结构中属于不同类型的具体的产品时需要使用抽象工厂设计模式。
 * </p>
 * <p>
 *     抽象工厂模式是所有形式的工厂中最为抽象和最具一般性的形态（最接近实际情况）
 * </p>
 */
public abstract class ProductFactory {
   /**
    * 抽象方法 获取手机
    * @return Phone
    */
   public abstract Phone getPhone();

   /**
    * 抽象方法 获取路由器
    * @return Router
    */
   public abstract Router getRouter();
}
