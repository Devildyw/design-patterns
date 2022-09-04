package top.devildyw.MediatorPattern.ConcreteMediator;

import top.devildyw.MediatorPattern.Colleague.Department;
import top.devildyw.MediatorPattern.Mediator.Mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介者的实现类
 * @author Devil
 * @since 2022-09-03-11:53
 */
public class President implements Mediator {
    private Map<String, Department> map = new HashMap<String,Department>();

    @Override
    public void register(String dname, Department d) {
        map.put(dname,d);
    }

    @Override
    public void command(String dname) {
        map.get(dname).selfAction();
    }
}
