package top.devildyw.MediatorPattern.ConcreteColleague;

import top.devildyw.MediatorPattern.Colleague.Department;
import top.devildyw.MediatorPattern.Mediator.Mediator;

/**
 * 财务部
 * @author Devil
 * @since 2022-09-03-12:00
 */
public class Financial implements Department {

    private Mediator mediator;

    public Financial(Mediator mediator) {
        super();
        this.mediator = mediator;
        mediator.register("financial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("提供资金支持！");
    }

    @Override
    public void outAction() {
        System.out.println("数钱");
    }
}
