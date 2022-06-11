package com.dyw.factoryMethodPattern.factory;

import com.dyw.factoryMethodPattern.product.Bike;
import com.dyw.factoryMethodPattern.product.Vehicles;

/**
 * @author Devil
 * @since 2022-06-12-0:44
 *
 * <br>
 * <p><strong>工厂方法设计模式 该类为具体工厂角色</strong></p>
 */
public class BikeFactory extends VehiclesFactory {
    @Override
    public Vehicles createProduct() {
        System.out.println("正在生成bike...");
        return new Bike();
    }
}
