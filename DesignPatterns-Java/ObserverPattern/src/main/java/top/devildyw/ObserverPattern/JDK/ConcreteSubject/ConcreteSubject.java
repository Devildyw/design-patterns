package top.devildyw.ObserverPattern.JDK.ConcreteSubject;


import java.util.Observable;

/**
 * 观察者模式: 目标对象
 * 继承 Observable
 *
 * @author Devil
 * @since 2022-09-04-12:39
 */
public class ConcreteSubject extends Observable {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void set(int s){
        this.state = s; //目标对象的状态发生了改变
        setChanged(); //表示目标对象已经做了更改
        notifyObservers(state); //通知所有的观察者(订阅者)
    }
}
