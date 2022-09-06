package top.devildyw.StrategyPattern.ConcreteStrategies;

import top.devildyw.StrategyPattern.Strategy.Strategy;

/**
 * 具体策略类
 * <p>
 * 乘坐飞机的策略
 *
 * @author Devil
 * @since 2022-09-06-12:44
 */
public class AirPlaneStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("选择乘坐飞机,已为您规划好路线!");
    }
}
