package top.devildyw.MediatorPattern;

import top.devildyw.MediatorPattern.ConcreteColleague.Development;
import top.devildyw.MediatorPattern.ConcreteColleague.Financial;
import top.devildyw.MediatorPattern.ConcreteColleague.Market;
import top.devildyw.MediatorPattern.ConcreteMediator.President;
import top.devildyw.MediatorPattern.Mediator.Mediator;

/**
 * 客户端
 * @author Devil
 * @since 2022-09-03-12:02
 */
public class Client {
    public static void main(String[] args) {
        //获取中介者对象
        Mediator m = new President();
        //获取同事对象，实例化的时候会在中介者对象中注册
        Market market = new Market(m);
        Development development = new Development(m);
        Financial financial = new Financial(m);

        market.selfAction();
        market.outAction();

    }
}
