package top.devildyw.MediatorPattern.Colleague;

/**
 * 同事类的接口
 * @author Devil
 * @since 2022-09-03-11:55
 */
public interface Department {
    void selfAction(); //做本部门的事情

    void outAction(); //向总经理发出申请
}
