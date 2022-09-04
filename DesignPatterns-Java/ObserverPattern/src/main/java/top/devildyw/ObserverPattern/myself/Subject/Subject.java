package top.devildyw.ObserverPattern.myself.Subject;

import top.devildyw.ObserverPattern.myself.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式: 目标对象模板
 *
 * @author Devil
 * @since 2022-09-04-12:34
 */
public interface Subject<T> {
    //存储订阅者
    List<Observer> list = new ArrayList<Observer>();

    /**
     * 注册订阅者方法
     *
     * @param obs
     */
    void registerObserver(T obs);

    /**
     * 移除订阅者方法
     *
     * @param obs
     */
    void removeObserver(T obs);

    /**
     * 通知所有的观察者更新状态
     */
    void notifyAllObservers();
}
