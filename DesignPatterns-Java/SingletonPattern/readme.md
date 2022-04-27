# 设计模式----创建型模式之单例设计模式

## [5.1. 模式动机](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id17)

对于系统中的某些类来说，只有一个实例很重要，例如，一个系统中可以存在多个打印任务，但是只能有一个正在工作的任务；一个系统只能有一个窗口管理器或文件系统；一个系统只能有一个计时工具或ID（序号）生成器。

如何保证一个类只有一个实例并且这个实例易于被访问呢？定义一个全局变量可以确保对象随时都可以被访问，但不能防止我们实例化多个对象。

一个更好的解决办法是让类自身负责保存它的唯一实例。这个类可以保证没有其他实例被创建，并且它可以提供一个访问该实例的方法。这就是单例模式的模式动机。

## [5.2. 模式定义](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id18)

单例模式(Singleton Pattern)：单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。

单例模式的要点有三个：一是某个类只能有一个实例；二是它必须自行创建这个实例；三是它必须自行向整个系统提供这个实例。单例模式是一种对象创建型模式。单例模式又名单件模式或单态模式。

## [5.3. 模式结构](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id19)

单例模式包含如下角色：

- Singleton：单例

![../_images/Singleton.jpg](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/Singleton.jpg)

## [5.4. 时序图](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id20)

![../_images/seq_Singleton.jpg](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/seq_Singleton.jpg)

## [5.5. 代码分析](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id21)

懒汉式:

```java
public class HungrySingleton {
    /**
     * 在程序加载时 就将类初始化 生成实例
     */
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    //方式二: 静态代码块
//    private static HungrySingleton HUNGRY_SINGLETON = null;
//    static {
//        HUNGRY_SINGLETON = new HungrySingleton();
//    }
    /**
     * 构造器私有化 防止重复创建类
     */
    private HungrySingleton(){

    }

    /**
     * 当被调用时 直接将该方法返回即可
     * @return HUNGRY_SINGLETON
     */
    public static HungrySingleton getInstance(){
        return HUNGRY_SINGLETON;
    }

    /**
     * 创建一个可以打印数组的方法 用于测试
     * @param array 数组
     */
    public void print(int[] array){
        for (int t : array) {
            System.out.println(t);
        }
    }

}
```

---

懒汉式:

```java
public class LazySingleton {

    /**
     * 定义一个类实例的变量 用于等待调用 调用后 作为初始化对象的容器
     */
    private static LazySingleton LAZY_SINGLETON = null;
    /**
     * 构造器私有化 防止被调用重复生成实例
     */
    private LazySingleton(){

    }

    /**
     * 当被调用时 如果没有被实例化 则实例化
     * 已经实例化了 直接返回
     * <br>
     * <h2>注意:</h2>
     * 这种写法的缺点就是线程安全无法保证
     * @return LAZY_SINGLETON
     */
    public static LazySingleton getInstance(){
        //如果LAZY_SINGLETON为空
        if (LAZY_SINGLETON==null){
            LAZY_SINGLETON = new LazySingleton();
        }
        return LAZY_SINGLETON;
    }

    /**
     * 创建一个可以打印数组的方法 用于测试
     * @param array 数组
     */
    public void print(int[] array){
        for (int t : array) {
            System.out.println(t);
        }
    }
}

```

---

懒汉式改良版:

```java
public class LazySingletonPlus {
    /**
     * 定义一个类实例的变量 用于等待调用 调用后 作为初始化对象的容器
     */
    private static LazySingletonPlus LAZY_SINGLETON_PLUS = null;
    /**
     * 构造器私有化 防止被调用重复生成实例
     */
    private LazySingletonPlus(){

    }

    /**
     * 当被调用时 如果没有被实例化 则实例化
     * 已经实例化了 直接返回
     * <br>
     * <h2>注意:</h2>
     * 这种写法的缺点就是线程安全无法保证
     * @return LAZY_SINGLETON
     */
    public static LazySingletonPlus getInstance(){
        //第一层检查  如果LAZY_SINGLETON为空
        if (LAZY_SINGLETON_PLUS==null){
            //加锁 第一个线程调用该方法的会获得一个锁 这个锁为悲观锁 保证只有一个线程进入
            //假设有线程A和线程B两个线程同时通过第一层判断，那么它们需要排队进入同步代码块，
            //假设线程A先进入同步代码块，那么实例由线程A创建，那么当线程B进入同代码块时便不能通过第二层检查，
            //即直接返回实例。这样便实现了线程安全的懒加载。
            synchronized (LazySingletonPlus.class){
                //第二层检查 此时如果实例还未被创建 则交由此处创造
                //如果这里是被别人抢先一步获得锁 这里是阻塞完毕 实例已经被先行进入锁的线程创建了
                //则这里的判断是跳出条件判断的作用 防止锁死无法跳出 导致线程阻塞.
                if (LAZY_SINGLETON_PLUS==null){
                    //最后创造实例
                    LAZY_SINGLETON_PLUS = new LazySingletonPlus();
                }
            }

        }
        //返回实例
        return LAZY_SINGLETON_PLUS;
    }

    /**
     * 创建一个可以打印数组的方法 用于测试
     * @param array 数组
     */
    public void print(int[] array){
        for (int t : array) {
            System.out.println(t);
        }
    }
}

```

---

测试代码:

```java
public class SingletonTest {
    @Test
    public void doTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //饿汉式
        HungrySingleton instance = HungrySingleton.getInstance();
        instance.print(array);
        HungrySingleton instance3 = HungrySingleton.getInstance();
        System.out.println(instance == instance3);
        System.out.println("=======================================");
        //普通懒汉式
        LazySingleton instance1 = LazySingleton.getInstance();
        instance1.print(array);
        LazySingleton instance4 = LazySingleton.getInstance();
        System.out.println(instance1 == instance4);
        System.out.println("=======================================");
    }
}
```



运行结果：

![image-20220428005355210](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220428005355210.png)

## [5.6. 模式分析](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id22)

单例模式的目的是保证一个类仅有一个实例，并提供一个访问它的全局访问点。单例模式包含的角色只有一个，就是单例类——Singleton。单例类拥有一个私有构造函数，确保用户无法通过new关键字直接实例化它。除此之外，该模式中包含一个静态私有成员变量与静态公有的工厂方法，该工厂方法负责检验实例的存在性并实例化自己，然后存储在静态成员变量中，以确保只有一个实例被创建。

在单例模式的实现过程中，需要注意如下三点：

- 单例类的构造函数为私有；
- 提供一个自身的静态私有成员变量；
- 提供一个公有的静态工厂方法。

## [5.7. 实例](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id23)

在操作系统中，打印池(Print Spooler)是一个用于管理打印任务的应用程序，通过打印池用户可以删除、中止或者改变打印任务的优先级，在一个系统中只允许运行一个打印池对象，如果重复创建打印池则抛出异常。现使用单例模式来模拟实现打印池的设计。

## [5.8. 优点](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id24)

- 提供了对唯一实例的受控访问。因为单例类封装了它的唯一实例，所以它可以严格控制客户怎样以及何时访问它，并为设计及开发团队提供了共享的概念。
- 由于在系统内存中只存在一个对象，因此可以节约系统资源，对于一些需要频繁创建和销毁的对象，单例模式无疑可以提高系统的性能。
- 允许可变数目的实例。我们可以基于单例模式进行扩展，使用与单例控制相似的方法来获得指定个数的对象实例。

## [5.9. 缺点](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id25)

- 由于单例模式中没有抽象层，因此单例类的扩展有很大的困难。
- 单例类的职责过重，在一定程度上违背了“单一职责原则”。因为单例类既充当了工厂角色，提供了工厂方法，同时又充当了产品角色，包含一些业务方法，将产品的创建和产品的本身的功能融合到一起。
- 滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；现在很多面向对象语言(如Java、C#)的运行环境都提供了自动垃圾回收的技术，因此，如果实例化的对象长时间不被利用，系统会认为它是垃圾，会自动销毁并回收资源，下次利用时又将重新实例化，这将导致对象状态的丢失。

## [5.10. 适用环境](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id26)

在以下情况下可以使用单例模式：

- 系统只需要一个实例对象，如系统要求提供一个唯一的序列号生成器，或者需要考虑资源消耗太大而只允许创建一个对象。
- 客户调用类的单个实例只允许使用一个公共访问点，除了该公共访问点，不能通过其他途径访问该实例。
- 在一个系统中要求一个类只有一个实例时才应当使用单例模式。反过来，如果一个类可以有几个实例共存，就需要对单例模式进行改进，使之成为多例模式

## [5.11. 模式应用](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id27)

一个具有自动编号主键的表可以有多个用户同时使用，但数据库中只能有一个地方分配下一个主键编号，否则会出现主键重复，因此该主键编号生成器必须具备唯一性，可以通过单例模式来实现。

## [5.12. 模式扩展](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id28)

## [5.13. 总结](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/singleton.html#id29)

- 单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。单例模式的要点有三个：一是某个类只能有一个实例；二是它必须自行创建这个实例；三是它必须自行向整个系统提供这个实例。单例模式是一种对象创建型模式。
- 单例模式只包含一个单例角色：在单例类的内部实现只生成一个实例，同时它提供一个静态的工厂方法，让客户可以使用它的唯一实例；为了防止在外部对其实例化，将其构造函数设计为私有。
- 单例模式的目的是保证一个类仅有一个实例，并提供一个访问它的全局访问点。单例类拥有一个私有构造函数，确保用户无法通过new关键字直接实例化它。除此之外，该模式中包含一个静态私有成员变量与静态公有的工厂方法。该工厂方法负责检验实例的存在性并实例化自己，然后存储在静态成员变量中，以确保只有一个实例被创建。
- 单例模式的主要优点在于提供了对唯一实例的受控访问并可以节约系统资源；其主要缺点在于因为缺少抽象层而难以扩展，且单例类职责过重。
- 单例模式适用情况包括：系统只需要一个实例对象；客户调用类的单个实例只允许使用一个公共访问点。