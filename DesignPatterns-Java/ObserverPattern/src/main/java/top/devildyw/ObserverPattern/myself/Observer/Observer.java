package top.devildyw.ObserverPattern.myself.Observer;

import top.devildyw.ObserverPattern.myself.Subject.Subject;

/**
 * 观察者模式: 定义观察者
 *
 * @author Devil
 * @since 2022-09-04-12:36
 */
public interface Observer {
    void update(Subject subject);
}
