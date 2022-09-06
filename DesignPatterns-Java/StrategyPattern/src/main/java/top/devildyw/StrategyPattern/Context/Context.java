package top.devildyw.StrategyPattern.Context;

import top.devildyw.StrategyPattern.Strategy.Strategy;

/**
 * 上下文环境
 * @author Devil
 * @since 2022-09-06-12:42
 */
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething(){
        strategy.execute();
    }
}
