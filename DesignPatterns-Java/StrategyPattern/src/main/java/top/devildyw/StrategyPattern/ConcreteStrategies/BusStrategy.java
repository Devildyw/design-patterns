package top.devildyw.StrategyPattern.ConcreteStrategies;

import top.devildyw.StrategyPattern.Strategy.Strategy;

/**
 * 具体策略类
 * <p>
 * 乘坐公交车的策略
 *
 * @author Devil
 * @since 2022-09-06-12:46
 */
public class BusStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("选择乘坐公交车,已为您规划好路线!");
    }
}
