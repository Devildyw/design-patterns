package top.devildyw.MediatorPattern.ConcreteColleague;

import top.devildyw.MediatorPattern.Colleague.Department;
import top.devildyw.MediatorPattern.Mediator.Mediator;

/**
 * 市场部 同事类的具体实现
 * @author Devil
 * @since 2022-09-03-11:57
 */
public class Market implements Department {

    private Mediator mediator;

    public Market(Mediator mediator) {
        super();
        this.mediator = mediator;
        mediator.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("汇报工作！项目承接的进度，需要资金支持！");

        mediator.command("financial");
    }

    @Override
    public void outAction() {
        System.out.println("跑去接项目！");
    }
}
