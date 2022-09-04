package top.devildyw.ObserverPattern.myself.ConcreteObserver;

import top.devildyw.ObserverPattern.myself.ConcreteSubject.ConcreteSubject;
import top.devildyw.ObserverPattern.myself.Observer.Observer;
import top.devildyw.ObserverPattern.myself.Subject.Subject;

/**
 * 观察者模式: 观察者 实现
 *
 * @author Devil
 * @since 2022-09-04-12:43
 */
public class ObserverA implements Observer {

    //myState需要跟目标对象的state值保持一致
    private int myState;

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }

    /**
     * 更新为和目标对象的值一致
     * @param subject
     */
    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
        //一但发送了改变 就会将改变后值打印到控制台
        System.out.println(myState);
    }
}
