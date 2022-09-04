# 设计模式--行为型模式之观察者模式

##  意图

**观察者模式**是一种行为设计模式， 允许你定义一种订阅机制， 可在对象事件发生时通知多个 “观察” 该对象的其他对象。

![观察者设计模式](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041256185.png)

##  问题

假如你有两种类型的对象：  `顾客`和 `商店` 。 顾客对某个特定品牌的产品非常感兴趣 （例如最新型号的 `iPhone` 手机）， 而该产品很快将会在商店里出售。

顾客可以每天来商店看看产品是否到货。 但如果商品尚未到货时， 绝大多数来到商店的顾客都会空手而归。

![访问商店或发送垃圾邮件](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041256484.png)

前往商店和发送垃圾邮件

另一方面， 每次新产品到货时， 商店可以向所有顾客发送邮件 （可能会被视为垃圾邮件）。 这样， 部分顾客就无需反复前往商店了， 但也可能会惹恼对新产品没有兴趣的其他顾客。

我们似乎遇到了一个矛盾： 要么让顾客浪费时间检查产品是否到货， 要么让商店浪费资源去通知没有需求的顾客。

##  解决方案

拥有一些值得关注的状态的对象通常被称为*目标*， 由于它要将自身的状态改变通知给其他对象， 我们也将其称为*发布者* （`pub­lish­er`）。 所有希望关注发布者状态变化的其他对象被称为*订阅者* （`sub­scribers`）。

观察者模式建议你为发布者类添加订阅机制， 让每个对象都能订阅或取消订阅发布者事件流。 不要害怕！ 这并不像听上去那么复杂。 实际上， 该机制包括 1） 一个用于存储订阅者对象引用的列表成员变量； 2） 几个用于添加或删除该列表中订阅者的公有方法。

![订阅机制](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041256688.png)

订阅机制允许对象订阅事件通知。

现在， 无论何时发生了重要的发布者事件， 它都要遍历订阅者并调用其对象的特定通知方法。

**实际应用中可能会有十几个不同的订阅者类跟踪着同一个发布者类的事件， 你不会希望发布者与所有这些类相耦合的。 此外如果他人会使用发布者类， 那么你甚至可能会对其中的一些类一无所知。**

因此， **所有订阅者都必须实现同样的接口**， 发布者仅通过该接口与订阅者交互。 接口中必须声明通知方法及其参数， 这样发布者在发出通知时还能传递一些上下文数据。

![通知方法](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041256693.png)

发布者调用订阅者对象中的特定通知方法来通知订阅者。

如果你的应用中有多个不同类型的发布者， 且**希望订阅者可兼容所有发布者， 那么你甚至可以进一步让所有发布者遵循同样的接口**。 该接口仅需描述几个订阅方法即可。 这样订阅者就能在不与具体发布者类耦合的情况下通过接口观察发布者的状态。

##  真实世界类比

![杂志和报纸订阅](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041256088.png)

杂志和报纸订阅。

如果你订阅了一份杂志或报纸， 那就不需要再去报摊查询新出版的刊物了。 出版社 （即应用中的 “发布者”） 会在刊物出版后 （甚至提前） 直接将最新一期寄送至你的邮箱中。

出版社负责维护订阅者列表， 了解订阅者对哪些刊物感兴趣。 当订阅者希望出版社停止寄送新一期的杂志时， 他们可随时从该列表中退出。

##  观察者模式结构

![观察者设计模式的结构](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041256695.png)

1. **发布者** （`Pub­lish­er`） 会向其他对象发送值得关注的事件。 事件会在发布者自身状态改变或执行特定行为后发生。 发布者中包含一个允许新订阅者加入和当前订阅者离开列表的订阅构架。
2. 当新事件发生时， 发送者会遍历订阅列表并调用每个订阅者对象的通知方法。 该方法是在订阅者接口中声明的。
3. **订阅者（观察者）** （`Sub­scriber`） 接口声明了通知接口。 在绝大多数情况下， 该接口仅包含一个 `update`更新方法。 该方法可以拥有多个参数， 使发布者能在更新时传递事件的详细信息。
4. **具体订阅者** （`Con­crete Sub­scribers`） 可以执行一些操作来回应发布者的通知。 所有具体订阅者类都实现了同样的接口， 因此发布者不需要与具体类相耦合。
5. 订阅者通常需要一些上下文信息来正确地处理更新。 因此， 发布者通常会将一些上下文数据作为通知方法的参数进行传递。 发布者也可将自身作为参数进行传递， 使订阅者直接获取所需的数据。
6. **客户端** （Client） 会分别创建发布者和订阅者对象， 然后为订阅者注册发布者更新。

##  代码分析

### 手动实现

再此示例中，目标对象就是所谓的发布者，而观察者就是一个一个的观察目标对象内值是否发生改变的订阅者。

**`Subject`** 抽象发布者/目标对象  一旦发生了改变就会通知订阅者们。

```java
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
```



**`Observer`** 观察者/订阅者  一旦目标对象发生改变，订阅者会被通知

```java
/**
 * 观察者模式: 定义观察者
 *
 * @author Devil
 * @since 2022-09-04-12:36
 */
public interface Observer {
    void update(Subject subject);
}

```



**`ConcreteSubject`** 具体目标/具体发布者

```java
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

```



**`ConcreteObserver`** 具体观察者/订阅者

```java
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

```



**`Client`** 客户端 调用代码 测试

```java
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
```



执行结果:

![image-20220904130656485](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041306526.png)

可以发现目标对象的值发生修改后，所有订阅者都被通知了并且做出了响应的打印操作。

---



### Java内置观察者模式实现

在 `java.util` 包中包含由基本的 `Observer` 接口和 `Observable` 抽象类，功能上和 `Observer` 接口和 `Subject` 接口类似。不过在使用上，内置的就方便许多了，因为i许多功能比如说**注册**、**删除**、**通知**观察者的哪些功能已经内置好了。

`ConcreteSubject` 具体观察者

```java
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

```



观察者只需要继承Observable父类。发送消息的方式执行如下代码即可

```java
setChanged(); //表示目标对象已经做了更改
notifyObservers(state); //通知所有的观察者(订阅者) 值发生了改变
```



`void setChange()`

```java
    protected synchronized void setChanged() {
        changed = true;
    }
```

`void notifyObservers(Object arg)`

```java
    public void notifyObservers(Object arg) {
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        Object[] arrLocal;

        synchronized (this) { //获取锁 进入同步锁代码块 从主存中获取最新值
           
            if (!changed) // 获取到最新得changed 如果不为true就直接返回 否则执行如下代码
                return;
            arrLocal = obs.toArray(); //获取所有得订阅者
            clearChanged(); //清除修改标志
        } //退出同步代码块 将值写入主存

        //再调用订阅者得update方法
        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }
```



`ObserverA` 具体观察者

```java
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
```



`Client` 客户端

```java
/**
 * 客户端测试
 *
 * @author Devil
 * @since 2022-09-04-13:23
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
        subject.addObserver(obs1);
        subject.addObserver(obs2);
        subject.addObserver(obs3);

        //改变subject的状态
        subject.set(3000);
        System.out.println("-----------------------");
        //我们查看观察者的状态是不是也发生了改变
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

        //再次改变subject的状态
        subject.set(30);
        System.out.println("-----------------------");
        //我们查看观察者的状态是不是也发生了改变
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

        //移除一个订阅者
        subject.deleteObserver(obs2);
        subject.set(100);
        System.out.println("-----------------------");
        //我们查看观察者的状态是不是也发生了改变
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
    }
}

```

观察者也就是订阅者只需要实现Observer接口并重写相关update方法即可，在目标实现中我们发现触发的时候执行的就是观察者的update方法。

执行结果：

![image-20220904133910295](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209041339351.png)

这样就实现了官方提供观察者模式，其实这里的Observable和Observer和我们前面自定义的Subject和Observer差不多，只是考虑更全面罢了。



##  观察者模式适合应用场景

当一个对象状态的改变需要改变其他对象， 或实际对象是事先未知的或动态变化的时， 可使用观察者模式。

当你使用图形用户界面类时通常会遇到一个问题。 比如， 你创建了自定义按钮类并允许客户端在按钮中注入自定义代码， 这样当用户按下按钮时就会触发这些代码。

观察者模式允许任何实现了订阅者接口的对象订阅发布者对象的事件通知。 你可在按钮中添加订阅机制， 允许客户端通过自定义订阅类注入自定义代码。

当应用中的一些对象必须观察其他对象时， 可使用该模式。 但仅能在有限时间内或特定情况下使用。

订阅列表是动态的， 因此订阅者可随时加入或离开该列表。

##  实现方式

1. 仔细检查你的业务逻辑， 试着将其拆分为两个部分： 独立于其他代码的核心功能将作为发布者； 其他代码则将转化为一组订阅类。

2. 声明订阅者接口。 该接口至少应声明一个 `update`方法。

3. 声明发布者接口并定义一些接口来在列表中添加和删除订阅对象。 记住发布者必须仅通过订阅者接口与它们进行交互。

4. 确定存放实际订阅列表的位置并实现订阅方法。 通常所有类型的发布者代码看上去都一样， 因此将列表放置在直接扩展自发布者接口的抽象类中是显而易见的。 具体发布者会扩展该类从而继承所有的订阅行为。

   但是， 如果你需要在现有的类层次结构中应用该模式， 则可以考虑使用组合的方式： 将订阅逻辑放入一个独立的对象， 然后让所有实际订阅者使用该对象。

5. 创建具体发布者类。 每次发布者发生了重要事件时都必须通知所有的订阅者。

6. 在具体订阅者类中实现通知更新的方法。 绝大部分订阅者需要一些与事件相关的上下文数据。 这些数据可作为通知方法的参数来传递。

   但还有另一种选择。 订阅者接收到通知后直接从通知中获取所有数据。 在这种情况下， 发布者必须通过更新方法将自身传递出去。 另一种不太灵活的方式是通过构造函数将发布者与订阅者永久性地连接起来。

7. 客户端必须生成所需的全部订阅者， 并在相应的发布者处完成注册工作。

##  观察者模式优缺点

### 优点

- ***开闭原则*。 你无需修改发布者代码就能引入新的订阅者类 （如果是发布者接口则可轻松引入发布者类）。**
- 观察者模式在观察目标和观察者之间建立一个抽象的耦合。
- 观察者模式支持广播通信。
- 你可以在运行时建立对象之间的联系。

### 缺点

- 订阅者的通知顺序是随机的这一点是不支持的。
- 如果一个观察目标对象有很多直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。
- 如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
- 观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化（可以自己定义，该缺点可以被解决）。

##  与其他模式的关系

- [责任链模式](https://refactoringguru.cn/design-patterns/chain-of-responsibility)、 [命令模式](https://refactoringguru.cn/design-patterns/command)、 [中介者模式](https://refactoringguru.cn/design-patterns/mediator)和[观察者模式](https://refactoringguru.cn/design-patterns/observer)用于处理请求发送者和接收者之间的不同连接方式：

    - *责任链*按照顺序将请求动态传递给一系列的潜在接收者， 直至其中一名接收者对请求进行处理。
    - *命令*在发送者和请求者之间建立单向连接。
    - *中介者*清除了发送者和请求者之间的直接连接， 强制它们通过一个中介对象进行间接沟通。
    - *观察者*允许接收者动态地订阅或取消接收请求。

- [中介者](https://refactoringguru.cn/design-patterns/mediator)和[观察者](https://refactoringguru.cn/design-patterns/observer)之间的区别往往很难记住。 在大部分情况下， 你可以使用其中一种模式， 而有时可以同时使用。 让我们来看看如何做到这一点。

  *中介者*的主要目标是消除一系列系统组件之间的相互依赖。 这些组件将依赖于同一个中介者对象。 *观察者*的目标是在对象之间建立动态的单向连接， 使得部分对象可作为其他对象的附属发挥作用。

  有一种流行的中介者模式实现方式依赖于*观察者*。 中介者对象担当发布者的角色， 其他组件则作为订阅者， 可以订阅中介者的事件或取消订阅。 当*中介者*以这种方式实现时， 它可能看上去与*观察者*非常相似。

  当你感到疑惑时， 记住可以采用其他方式来实现中介者。 例如， 你可永久性地将所有组件链接到同一个中介者对象。 这种实现方式和*观察者*并不相同， 但这仍是一种中介者模式。

  假设有一个程序， 其所有的组件都变成了发布者， 它们之间可以相互建立动态连接。 这样程序中就没有中心化的中介者对象， 而只有一些分布式的观察者。