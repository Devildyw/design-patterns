package top.devildyw.MediatorPattern.Mediator;

import top.devildyw.MediatorPattern.Colleague.Department;

/**
 * 中介者接口
 *
 * @author Devil
 * @since 2022-09-03-11:51
 *
 */
public interface Mediator {
    /**
     * 注册 同事
     * @param dname
     * @param d
     */
    void register(String dname, Department d);

    /**
     * 执行 处理
     * @param dname
     */
    void command(String dname);
}
