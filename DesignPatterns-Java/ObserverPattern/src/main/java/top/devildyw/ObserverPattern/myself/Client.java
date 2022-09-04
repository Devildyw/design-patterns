package top.devildyw.ObserverPattern.myself;

import top.devildyw.ObserverPattern.myself.ConcreteObserver.ObserverA;
import top.devildyw.ObserverPattern.myself.ConcreteSubject.ConcreteSubject;

/**
 * 客户端
 *
 * @author Devil
 * @since 2022-09-04-12:46
 */
public class Client {
    public static void main(String[] args) {
        //目标对象
        ConcreteSubject subject = new ConcreteSubject();

        //创建多个观察者
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        //将这三个观察者添加到subject对象的观察者队伍中
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);

        //改变subject的状态
        subject.setState(3000);
        System.out.println("-----------------------");
        //我们查看观察者的状态是不是也发生了改变
//        System.out.println(obs1.);

        //再次改变subject的状态
        subject.setState(30);

    }
}
