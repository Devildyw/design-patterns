package top.devildyw.StrategyPattern;

import top.devildyw.StrategyPattern.ConcreteStrategies.AirPlaneStrategy;
import top.devildyw.StrategyPattern.ConcreteStrategies.BikeStrategy;
import top.devildyw.StrategyPattern.ConcreteStrategies.BusStrategy;
import top.devildyw.StrategyPattern.ConcreteStrategies.CarStrategy;
import top.devildyw.StrategyPattern.Context.Context;

/**
 * 客户端
 *
 * @author Devil
 * @since 2022-09-06-12:37
 */
public class Client {
    public static void main(String[] args) {
        //创建上下文
        Context context = new Context();

        //创建策略
        BusStrategy busStrategy = new BusStrategy();
        BikeStrategy bikeStrategy = new BikeStrategy();
        AirPlaneStrategy airPlaneStrategy = new AirPlaneStrategy();
        CarStrategy carStrategy = new CarStrategy();

        //开车
        System.out.println("-----------------------------");
        context.setStrategy(busStrategy);
        context.doSomething();

        //骑车
        System.out.println("-----------------------------");
        context.setStrategy(bikeStrategy);
        context.doSomething();

        //飞机
        System.out.println("-----------------------------");
        context.setStrategy(airPlaneStrategy);
        context.doSomething();

        //公交
        System.out.println("-----------------------------");
        context.setStrategy(busStrategy);
        context.doSomething();
    }
}
