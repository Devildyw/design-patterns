# 设计模式--工厂方法设计模式

## [1.1. 模式动机](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id16)

现在对该系统进行修改，不再设计一个按钮工厂类来统一负责所有产品的创建，而是将具体按钮的创建过程交给专门的工厂子类去完成，我们先定义一个抽象的按钮工厂类，再定义具体的工厂类来生成圆形按钮、矩形按钮、菱形按钮等，它们实现在抽象按钮工厂类中定义的方法。这种抽象化的结果使这种结构可以在不修改具体工厂类的情况下引进新的产品，如果出现新的按钮类型，只需要为这种新类型的按钮创建一个具体的工厂类就可以获得该新按钮的实例，这一特点无疑使得工厂方法模式具有超越简单工厂模式的优越性，更加符合“开闭原则”。

## [1.2. 模式定义](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id17)

工厂方法模式(Factory Method Pattern)又称为工厂模式，也叫虚拟构造器(Virtual Constructor)模式或者多态工厂(Polymorphic Factory)模式，它属于类创建型模式。在工厂方法模式中，工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象，这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。

## [1.3. 模式结构](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id18)

工厂方法模式包含如下角色：

- `Product`：抽象产品
- `ConcreteProduct`：具体产品
- `Factory`：抽象工厂
- `ConcreteFactory`：具体工厂

![../_images/FactoryMethod.jpg](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/FactoryMethod.jpg)

## [1.4. 时序图](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id19)

![../_images/seq_FactoryMethod.jpg](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/seq_FactoryMethod.jpg)

## [1.5. 代码分析](https://github.com/Devildyw/design-patterns/tree/master/DesignPatterns-Java/FactoryMethodPattern)

**注释也可以仔细看看哦**

抽象产品类`Vehicles.java`

```java
package com.dyw.factoryMethodPattern.product;

/**
 * @author Devil
 * @since 2022-06-11-20:13
 * <br>
 * <strong>该类为工厂方法设计模式中的抽象产品角色</strong>
 * <p>基类</p>
 */
public abstract class Vehicles {
    /**
     * 交通工具的核心方法 "运行"
     */
    abstract public void work();
}

```

具体产品类`Bike.java`

```java
package com.dyw.factoryMethodPattern.product;

/**
 * @author Devil
 * @since 2022-06-11-20:13
 * <br>
 * <strong>该类角色为工厂方法设计模式中的具体产品角色</strong>
 * <p>自行车继承自交通工具抽象类实现了抽象方法</p>
 */
public class Bike extends Vehicles {
    @Override
    public void work() {
        System.out.println("Bike is running");
    }

}
```



抽象工厂类`VehiclesFactory.java`

```java
package com.dyw.factoryMethodPattern.factory;

import com.dyw.factoryMethodPattern.product.Vehicles;

/**
 * @author Devil
 * @since 2022-06-11-21:52
 *
 * <br>
 * <p><strong>工厂方法设计模式 该类为抽象工厂角色</strong></p>
 * <p>
 *     这里创建了一个抽象的工厂类 是为了让具体工厂的子类来实现这个特定的方法 以便于生产产品
 *     之所以这样便于生产产品是相较于简单工厂设计模式的，简单工厂设计模式生产产品是将生产过程耦合在了一起
 *     这样在产品不多的时候或是产品种类确定不会经常改变时较为好用，但是我们实际生产中很难确定自己的产品种类就一定不变
 *     所以我们可以使用工厂方法设计模式，他不在原来的类上进行修改，而是给出了一个抽象类 新添加的产品需要创建一个具体工厂类
 *     实现具体的抽象方法以便于创建具体的产品。符合开闭原则的同时也避免了简单工厂设计模式的高耦合性。
 * </p>
 */
public abstract class VehiclesFactory {
    /**
     * 抽象方法<br>
     * 具体工厂继承该类并且实现该抽象方法
     * @return Vehicles
     * @author Devil
     */
    public abstract Vehicles createProduct();
}

```

具体工厂类`BikeFactory.java`

```java
package com.dyw.factoryMethodPattern.factory;

import com.dyw.factoryMethodPattern.product.Bike;
import com.dyw.factoryMethodPattern.product.Vehicles;

/**
 * @author Devil
 * @since 2022-06-12-0:44
 *
 * <br>
 * <p><strong>工厂方法设计模式 该类为具体工厂角色</strong></p>
 */
public class BikeFactory extends VehiclesFactory{
    @Override
    public Vehicles createProduct() {
        System.out.println("正在生成bike...");
        return new Bike();
    }
}
```



演示类`Main.java`

```java
package com.dyw.factoryMethodPattern.client;

import com.dyw.factoryMethodPattern.factory.BikeFactory;
import com.dyw.factoryMethodPattern.factory.VehiclesFactory;
import com.dyw.factoryMethodPattern.product.Vehicles;

/**
 * @author Devil
 * @since 2022-06-12-0:48
 * <br>
 * <strong>该类用于向读者展示工厂方法是否有效</strong>
 * <p>这里仅仅只是展示了一个产品的工厂生产 通过这一个例子 读者足以理解本片想要表达的含义</p>
 */
public class Main {
    public static void main(String[] args) {
        //这里我想要一辆自行车
        //首先创建一个工厂类 让他帮我们创建类
        VehiclesFactory bikeFactory = new BikeFactory();
        //工厂类调用特定方法生产产品
        Vehicles product = bikeFactory.createProduct();
        //执行产品特有的方法
        product.work();
        //检验结果
    }
}

```

结果:

![image-20220612010908971](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220612010908971.png)

## [2.6. 模式分析](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id21)

工厂方法模式是简单工厂模式的进一步抽象和推广。由于使用了面向对象的多态性，工厂方法模式保持了简单工厂模式的优点，而且克服了它的缺点。在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。这个核心类仅仅负责给出具体工厂必须实现的接口，而不负责哪一个产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。

## [1.7. 实例](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id22)

日志记录器

某系统日志记录器要求支持多种日志记录方式，如文件记录、数据库记录等，且用户可以根据要求动态选择日志记录方式， 现使用工厂方法模式设计该系统。

结构图：

![../_images/loger.jpg](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/loger.jpg)

时序图：

![../_images/seq_loger.jpg](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/seq_loger.jpg)

## [1.8. 工厂方法模式的优点](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id23)

- 在工厂方法模式中，工厂方法用来创建客户所需要的产品，同时还向客户隐藏了哪种具体产品类将被实例化这一细节，用户只需要关心所需产品对应的工厂，无须关心创建细节，甚至无须知道具体产品类的类名。
- 基于工厂角色和产品角色的多态性设计是工厂方法模式的关键。它能够使工厂可以自主确定创建何种产品对象，而如何创建这个对象的细节则完全封装在具体工厂内部。工厂方法模式之所以又被称为多态工厂模式，是因为所有的具体工厂类都具有同一抽象父类。
- 使用工厂方法模式的另一个优点是在系统中加入新产品时，无须修改抽象工厂和抽象产品提供的接口，无须修改客户端，也无须修改其他的具体工厂和具体产品，而只要添加一个具体工厂和具体产品就可以了。这样，系统的可扩展性也就变得非常好，完全符合“开闭原则”。

## [1.9. 工厂方法模式的缺点](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id24)

- 在添加新产品时，需要编写新的具体产品类，而且还要提供与之对应的具体工厂类，系统中类的个数将成对增加，在一定程度上增加了系统的复杂度，有更多的类需要编译和运行，会给系统带来一些额外的开销。
- 由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度，且在实现时可能需要用到DOM、反射等技术，增加了系统的实现难度。

## [1.10. 适用环境](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id25)

在以下情况下可以使用工厂方法模式：

- 一个类不知道它所需要的对象的类：在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体的产品对象由具体工厂类创建；客户端需要知道创建具体产品的工厂类。
- 一个类通过其子类来指定创建哪个对象：在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。
- 将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定，可将具体工厂类的类名存储在配置文件或数据库中。

## [1.11. 模式应用](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id26)

`JDBC`中的工厂方法:

```text
Connection conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://loc
alhost:1433; DatabaseName=DB;user=sa;password=");
Statement statement=conn.createStatement();
ResultSet rs=statement.executeQuery("select * from UserInfo");
```

## [1.12. 模式扩展](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id27)

- 使用多个工厂方法：在抽象工厂角色中可以定义多个工厂方法，从而使具体工厂角色实现这些不同的工厂方法，这些方法可以包含不同的业务逻辑，以满足对不同的产品对象的需求。
- 产品对象的重复使用：工厂对象将已经创建过的产品保存到一个集合（如数组、List等）中，然后根据客户对产品的请求，对集合进行查询。如果有满足要求的产品对象，就直接将该产品返回客户端；如果集合中没有这样的产品对象，那么就创建一个新的满足要求的产品对象，然后将这个对象在增加到集合中，再返回给客户端。
- 多态性的丧失和模式的退化：如果工厂仅仅返回一个具体产品对象，便违背了工厂方法的用意，发生退化，此时就不再是工厂方法模式了。一般来说，工厂对象应当有一个抽象的父类型，如果工厂等级结构中只有一个具体工厂类的话，抽象工厂就可以省略，也将发生了退化。当只有一个具体工厂，在具体工厂中可以创建所有的产品对象，并且工厂方法设计为静态方法时，工厂方法模式就退化成简单工厂模式。

## [1.13. 总结](https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/factory_method.html#id28)

- 工厂方法模式又称为工厂模式，它属于类创建型模式。在工厂方法模式中，工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象，这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。
- 工厂方法模式包含四个角色：抽象产品是定义产品的接口，是工厂方法模式所创建对象的超类型，即产品对象的共同父类或接口；具体产品实现了抽象产品接口，某种类型的具体产品由专门的具体工厂创建，它们之间往往一一对应；抽象工厂中声明了工厂方法，用于返回一个产品，它是工厂方法模式的核心，任何在模式中创建对象的工厂类都必须实现该接口；具体工厂是抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，并可由客户调用，返回一个具体产品类的实例。
- 工厂方法模式是简单工厂模式的进一步抽象和推广。由于使用了面向对象的多态性，工厂方法模式保持了简单工厂模式的优点，而且克服了它的缺点。在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。这个核心类仅仅负责给出具体工厂必须实现的接口，而不负责产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。
- 工厂方法模式的主要优点是增加新的产品类时无须修改现有系统，并封装了产品对象的创建细节，系统具有良好的灵活性和可扩展性；其缺点在于增加新产品的同时需要增加新的工厂，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性。
- 工厂方法模式适用情况包括：一个类不知道它所需要的对象的类；一个类通过其子类来指定创建哪个对象；将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定。
