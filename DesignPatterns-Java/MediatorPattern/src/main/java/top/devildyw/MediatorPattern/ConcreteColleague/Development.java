package top.devildyw.MediatorPattern.ConcreteColleague;

import top.devildyw.MediatorPattern.Colleague.Department;
import top.devildyw.MediatorPattern.Mediator.Mediator;

/**
 * 开发部
 * @author Devil
 * @since 2022-09-03-12:01
 */
public class Development implements Department {

    private Mediator mediator;

    public Development(Mediator mediator) {
        super();
        this.mediator = mediator;
        mediator.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("汇报工作！没钱了，需要资金支持！");
        mediator.command("financial");
    }

    @Override
    public void outAction() {
        System.out.println("专心科研，开发项目！");
    }
}
