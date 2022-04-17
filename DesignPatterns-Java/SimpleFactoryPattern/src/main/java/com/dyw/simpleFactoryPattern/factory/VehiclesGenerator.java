package com.dyw.simpleFactoryPattern.factory;

import com.dyw.simpleFactoryPattern.product.*;

/**
 * @author Devil
 * @date 2022-04-16-20:41
 *
 * <br>
 * <p><strong>简单工厂设计模式 该类为工厂角色</strong></p>
 *
 * 对于不同的类继承了相同的基类.如果我们希望在使用这些类时，不需要知道这些具体类的名字,
 * 只需要知道表示这些类的参数,并且提供了一个调用方便的方法(静态方法)
 * 把该参数传入方法即可,返回一个目标类对象,此时就可以使用简单工厂设计模式
 * 详情可以查看.
 * <a href="https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html">图说设计模式--简单工厂设计模式</a>
 * <br>
 *
 * <p>注意: 如果工厂类出现了问题,那么对应的类的所有实例的创建都会受到影响</p>
 * <strong>适用环境: </strong>
 * <p>1. 工厂类负责创建的对象比较少：由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂.</p>
 * <p>2. 客户端只知道传入工厂类的参数，对于如何创建对象不关心：客户端既不需要关心创建细节，甚至连类名都不需要记住，只需要知道类型所对应的参数。</p>
 * <p>3. 需要创建实例的类不会频繁地增加</p>
 *
 * @since 1.0
 * @version 1.0
 */
public class VehiclesGenerator {

    private static final String CAR = "Car";

    private static final String BIKE = "Bike";

    private static final String TRAIN = "Train";

    private static final String AIRPLANE = "Airplane";

    /**
     * 方式一 交通工具生成器
     * 使用if 判断字段来生成实例
     * 返回值为抽象类类型 根据继承的知识我们知道 父类只能拥有子类重写的方法
     * 所以如果子类有额外的方法时需要向下转型.
     * @param vehiclesType 交通工具的类型
     * @return 对应的交通工具
     */
    public static Vehicles getInstance(String vehiclesType){
        if (vehiclesType.equals(CAR)){
            return new Car();
        }
        if (vehiclesType.equals(TRAIN)){
            return new Train();
        }
        if (vehiclesType.equals(BIKE)){
            return new Bike();
        }
        if (vehiclesType.equals(AIRPLANE)){
            return new Airplane();
        }
        return null;
    }

    protected VehiclesGenerator(){

    }

    /**
     * 方式二: 使用不同的获取实例方法代替使用if判断字段的方法
     * 该方式不存在需要向下转型情况
     * @return 对应的交通工具
     */
    public static Car getCarInstance(){
        return new Car();
    }

    public static Airplane getAirplaneInstance(){
        return new Airplane();
    }

    public static Train getTrainInstance(){
        return new Train();
    }

    public static Bike getBikeInstance(){
        return new Bike();
    }

}
