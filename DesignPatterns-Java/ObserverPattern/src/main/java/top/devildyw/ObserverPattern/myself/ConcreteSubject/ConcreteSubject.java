package top.devildyw.ObserverPattern.myself.ConcreteSubject;

import top.devildyw.ObserverPattern.myself.Observer.Observer;
import top.devildyw.ObserverPattern.myself.Subject.Subject;

/**
 * 观察者模式: 目标对象（主体对象 topic）
 *
 * @author Devil
 * @since 2022-09-04-12:39
 */
public class ConcreteSubject implements Subject<Observer> {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //主题对象（目标对象）值发生了变化，请通知所有的观察者
        this.notifyAllObservers();
    }

    @Override
    public void registerObserver(Observer obs) {
        list.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        list.remove(obs);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : list) {
            //更新每一个观察者中的信息
            observer.update(this);
        }
    }
}
