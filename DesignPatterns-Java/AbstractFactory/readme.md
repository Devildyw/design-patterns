# 设计模式--创建型模式之抽象工厂设计模式

## [1.1. 模式动机](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id18)

- 在工厂方法模式中具体工厂负责生产具体的产品，每一个具体工厂对应一种具体产品，工厂方法也具有唯一性，一般情况下，一个具体工厂中只有一个工厂方法或者一组重载的工厂方法。但是有时候我们需要一个工厂可以提供多个产品对象，而不是单一的产品对象。

  > 为了更清晰地理解工厂方法模式，需要先引入两个概念：
  >
  > - **产品等级结构** ：产品等级结构即产品的继承结构，如一个抽象类是电视机，其子类有海尔电视机、海信电视机、TCL电视机，则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，抽象电视机是父类，而具体品牌的电视机是其子类。
  > - **产品族** ：在抽象工厂模式中，产品族是指由同一个工厂生产的，位于不同产品等级结构中的一组产品，如海尔电器工厂生产的海尔电视机、海尔电冰箱，海尔电视机位于电视机产品等级结构中，海尔电冰箱位于电冰箱产品等级结构中。

- 当系统所提供的工厂所需生产的具体产品并不是一个简单的对象，而是多个位于不同产品等级结构中属于不同类型的具体产品时需要使用抽象工厂模式。

- 抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形态。

- 抽象工厂模式与工厂方法模式最大的区别在于，工厂方法模式针对的是一个产品等级结构，而抽象工厂模式则需要面对多个产品等级结构，一个工厂等级结构可以负责多个不同产品等级结构中的产品对象的创建 。当一个工厂等级结构可以创建出分属于不同产品等级结构的一个产品族中的所有对象时，抽象工厂模式比工厂方法模式更为简单、有效率。

## [1.2. 模式定义](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id19)

抽象工厂模式(Abstract Factory Pattern)：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。

## [1.3. 模式结构](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id20)

抽象工厂模式包含如下角色：

- `AbstractFactory`：抽象工厂
- `ConcreteFactory`：具体工厂
- `AbstractProduct`：抽象产品
- `Product`：具体产品

![../_images/AbatractFactory.jpg](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/AbatractFactory.jpg)

## [1.4. 时序图](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id21)

![../_images/seq_AbatractFactory.jpg](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/seq_AbatractFactory.jpg)

## [1.5. 代码分析](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id22)

`Phone`抽象产品

```java
public abstract class Phone {
    /**
     * 抽象方法 打电话
     */
    public abstract void callUp();

    /**
     * 抽象方法 发送短信
     */
    public abstract void sendSMS();
}
```

`Phone`具体产品

```java
public class HuaweiPhone extends Phone{
    @Override
    public void callUp() {
        System.out.println("华为手机打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("华为手机发送短信");
    }
}

public class XiaomiPhone extends Phone{
    @Override
    public void callUp() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("小米手机发送短信");
    }
}

```

`Router`抽象产品

```java
public abstract class Router {
    /**
     * 抽象方法 打开wifi
     */
    public abstract void openWifi();

    /**
     * 抽象方法 设置
     */
    public abstract void setting();
}
```

`Router`具体产品

```java
public class HuaweiRouter extends Router{
    @Override
    public void openWifi() {
        System.out.println("华为路由器打开wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为路由器设置");
    }
}

public class XiaomiRouter extends Router{
    @Override
    public void openWifi() {
        System.out.println("小米路由器打开wifi");
    }

    @Override
    public void setting() {
        System.out.println("小米路由器设置");
    }
}

```

---

`ProductFactory`抽象工厂

```java
public abstract class ProductFactory {
   /**
    * 抽象方法 获取手机
    * @return Phone
    */
   public abstract Phone getPhone();

   /**
    * 抽象方法 获取路由器
    * @return Router
    */
   public abstract Router getRouter();
}
```

`HuaweiFactory`具体工厂

```java
public class HuaweiFactory extends ProductFactory{
    @Override
    public Phone getPhone() {
        //生产Huawei手机
        return new HuaweiPhone();
    }

    @Override
    public Router getRouter() {
        //生产Huawei路由器
        return new HuaweiRouter();
    }
}
```

`XiaomiFactory`具体工厂

```java
public class XiaomiFactory extends ProductFactory{
    @Override
    public Phone getPhone() {
        //生产Xiaomi手机
        return new XiaomiPhone();
    }

    @Override
    public Router getRouter() {
        //生产Xiaomi路由器
        return new XiaomiRouter();
    }
}
```

---

`Client`测试类

```java
public class Client {
    public static void main(String[] args) {
        System.out.println("=============小米系列=============");
        ProductFactory productFactory = new XiaomiFactory();
        Phone phone = productFactory.getPhone();
        phone.callUp();
        phone.sendSMS();
        Router router = productFactory.getRouter();
        router.openWifi();
        router.openWifi();
        System.out.println("=============华为系列=============");
        productFactory = new HuaweiFactory();
        phone = productFactory.getPhone();
        phone.callUp();
        phone.sendSMS();
        router = productFactory.getRouter();
        router.openWifi();
        router.setting();
    }
}
```



运行结果：

![image-20220619165656769](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220619165656769.png)

## [1.6. 模式分析](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id23)

## [1.7. 实例](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id24)

## [1.8. 优点](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id25)

- 抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。由于这种隔离，更换一个具体工厂就变得相对容易。所有的具体工厂都实现了抽象工厂中定义的那些公共接口，因此只需改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。另外，应用抽象工厂模式可以实现高内聚低耦合的设计目的，因此抽象工厂模式得到了广泛的应用。
- 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。这对一些需要根据当前环境来决定其行为的软件系统来说，是一种非常实用的设计模式。
- 增加新的具体工厂和产品族很方便，无须修改已有系统，符合“开闭原则”。

## [1.9. 缺点](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id26)

- 在添加新的产品对象时，难以扩展抽象工厂来生产新种类的产品，这是因为在抽象工厂角色中规定了所有可能被创建的产品集合，要支持新种类的产品就意味着要对该接口进行扩展，而这将涉及到对抽象工厂角色及其所有子类的修改，显然会带来较大的不便。
- 开闭原则的倾斜性（增加新的工厂和产品族容易，增加新的产品等级结构麻烦）。

## [1.10. 适用环境](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id27)

在以下情况下可以使用抽象工厂模式：

- 一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是重要的。
- 系统中有多于一个的产品族，而每次只使用其中某一产品族。
- 属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来。
- 系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。

## [1.11. 模式应用](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id28)

在很多软件系统中需要更换界面主题，要求界面中的按钮、文本框、背景色等一起发生改变时，可以使用抽象工厂模式进行设计。

## [1.12. 模式扩展](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id29)

### [“开闭原则”的倾斜性](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id30)

- - “开闭原则”要求系统对扩展开放，对修改封闭，通过扩展达到增强其功能的目的。对于涉及到多个产品族与多个产品等级结构的系统，其功能增强包括两方面：

    增加产品族：对于增加新的产品族，工厂方法模式很好的支持了“开闭原则”，对于新增加的产品族，只需要对应增加一个新的具体工厂即可，对已有代码无须做任何修改。增加新的产品等级结构：对于增加新的产品等级结构，需要修改所有的工厂角色，包括抽象工厂类，在所有的工厂类中都需要增加生产新产品的方法，不能很好地支持“开闭原则”。

- 抽象工厂模式的这种性质称为“开闭原则”的倾斜性，抽象工厂模式以一种倾斜的方式支持增加新的产品，它为新产品族的增加提供方便，但不能为新的产品等级结构的增加提供这样的方便。

### [工厂模式的退化](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id31)

- 当抽象工厂模式中每一个具体工厂类只创建一个产品对象，也就是只存在一个产品等级结构时，抽象工厂模式退化成工厂方法模式；当工厂方法模式中抽象工厂与具体工厂合并，提供一个统一的工厂来创建产品对象，并将创建对象的工厂方法设计为静态方法时，工厂方法模式退化成简单工厂模式。

## [1.13. 总结](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html#id32)

- 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，属于对象创建型模式。
- 抽象工厂模式包含四个角色：抽象工厂用于声明生成抽象产品的方法；具体工厂实现了抽象工厂声明的生成抽象产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中；抽象产品为每种产品声明接口，在抽象产品中定义了产品的抽象业务方法；具体产品定义具体工厂生产的具体产品对象，实现抽象产品接口中定义的业务方法。
- 抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形态。抽象工厂模式与工厂方法模式最大的区别在于，工厂方法模式针对的是一个产品等级结构，而抽象工厂模式则需要面对多个产品等级结构。
- 抽象工厂模式的主要优点是隔离了具体类的生成，使得客户并不需要知道什么被创建，而且每次可以通过具体工厂类创建一个产品族中的多个对象，增加或者替换产品族比较方便，增加新的具体工厂和产品族很方便；主要缺点在于增加新的产品等级结构很复杂，需要修改抽象工厂和所有的具体工厂类，对“开闭原则”的支持呈现倾斜性。
- 抽象工厂模式适用情况包括：一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节；系统中有多于一个的产品族，而每次只使用其中某一产品族；属于同一个产品族的产品将在一起使用；系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。