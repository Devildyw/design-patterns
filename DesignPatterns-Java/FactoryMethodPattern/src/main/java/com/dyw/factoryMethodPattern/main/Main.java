package com.dyw.factoryMethodPattern.main;

import com.dyw.factoryMethodPattern.factory.BikeFactory;
import com.dyw.factoryMethodPattern.factory.VehiclesFactory;
import com.dyw.factoryMethodPattern.product.Vehicles;

/**
 * @author Devil
 * @since 2022-06-12-0:48
 * <br>
 * <strong>该类用于向读者展示工厂方法是否有效</strong>
 * <p>这里仅仅只是展示了一个产品的工厂生产 通过这一个例子 读者足以理解本片想要表达的含义</p>
 */
public class Main {
    public static void main(String[] args) {
        //这里我想要一辆自行车
        //首先创建一个工厂类 让他帮我们创建类
        VehiclesFactory bikeFactory = new BikeFactory();
        //工厂类调用特定方法生产产品
        Vehicles product = bikeFactory.createProduct();
        //执行产品特有的方法
        product.work();
        //检验结果
    }
}
