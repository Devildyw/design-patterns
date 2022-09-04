package top.devildyw.ObserverPattern.JDK.ConcreteObserver;

import top.devildyw.ObserverPattern.JDK.ConcreteSubject.ConcreteSubject;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式: 观察者(消息订阅者)
 * 实现Observer接口
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


    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject) o).getState();
    }
}
