package top.devildyw.StrategyPattern.ConcreteStrategies;

import top.devildyw.StrategyPattern.Strategy.Strategy;

/**
 * 具体策略类
 * <p>
 * 骑自行车的策略
 *
 * @author Devil
 * @since 2022-09-06-12:45
 */
public class BikeStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("选择骑自行车,已为您规划好路线!");
    }
}
