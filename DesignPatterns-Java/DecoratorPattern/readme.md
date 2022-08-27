# 设计模式--结构型模式之装饰模式

> 动态地给一个对象增加一些额外的职责，就扩展功能而言，装饰模式提供了一种比使用子类更加灵活的替代方案

## 定义

有时我们希望给某个对象而不是整个类添加一些功能，虽然使用继承是添加功能的一种方式，但是不够灵活，而且会导致子类增加了无用功能，耦合性太强。一种较为灵活的方式是将对象嵌入另一个对象中，通过该对象添加功能，称这个嵌入的对象为装饰。这个装饰与被装饰的对象接口一致，它将请求转发给被装饰对象，并在转发的前后进行额外操作。 装饰模式就是**动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。**

## 结构

装饰模式包含如下角色：

- **Component: 抽象构件** 定义了对象的接口，可以给这些对 象动态增加职责（方法）；
- **ConcreteComponent: 具体构件（也可称为被装饰者）** 具体构件定义了具体的构件对象，实现了 在抽象构件中声明的方法，装饰器可以给它增加额外的职责（方法）；
- **Decorator: 抽象装饰类**   抽象装饰类是抽象构件类的子类，用于给具体构件增加职责，但是具 体职责在其子类中实现；
- **ConcreteDecorator: 具体装饰类（装饰者）** 具体装饰类是抽象装饰类的子类，负责向构 件添加新的职责。

## 描述

- 模式名称：**DECORATOR**（装饰）
- 类型：对象结构型模式
- 意图：动态地给一个对象添加一些额外的职责。就增加功能来说， Decorator模式相比生成子类更为灵活。
- 适用性：
    - 在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
- 效果：
- 优点：
    - 比继承更灵活。
    - 避免在层次结构高层的类有太多的特征。
    - 通过使用不同的具体装饰类以及这些装饰类的排列组合，可以创造出很多不同行为的组合。可以使用多个具体装饰类来装饰同一对象，得到功能更为强大的对象。
    - 具体构件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体构件类和具体装饰类，在使用时再对其进行组合，原有代码无须改变，符合“开闭原则”
- 缺点：
    - 多层装饰比较复杂，加大学习与理解的难度
    - 较与继承更加容易出错，排错也比较困难。

## 下面通过一个例子，来深入理解装饰模式

```text
有一家咖啡店，生意很火爆，想要更新订单系统，来满足目前的饮料供应需求。原先的设计如下：
有一个饮料的抽象类，所有的饮品都继承此类。类中包含了变量 description(描述)，和方法 getDescription()获取描述信息，以及抽象方法cost()花费。子类要实现cost方法。
复制代码
```

![image.png](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208271225090.webp)

在原先饮品种类少的情况还可以，如果说为了提高市场竞争力和消费升级，要增加多种饮品，并按照加入的不同调味品收取不同的费用。要是还按照之前的方式创建子类实现cost，就会造成子类过多，并且如果某一种调味料价格有变动，需要修改的类就很多，不利于维护。

这时可能会说直接在饮料类中添加调味料变量，设置和获取是否有某种调味料的方法就好了，将饮料类中cost方法提供实现，用于判断调味料的价钱，子类只需 计算自己的价值，配置有哪种调料，并加上父类的就行

```java
// 饮料类
public class Beverage {

   private String description;

   private double milkCost;

   private double soyCost;

   private double mochaCost;

   private double whipCost;


   private boolean hasMilk;

   private boolean hasSoy;

   private boolean hasMocha;

   private boolean hasWhip;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasMilk() {
        return hasMilk;
    }

    public void setHasMilk(boolean hasMilk) {
        this.hasMilk = hasMilk;
    }

    public boolean isHasSoy() {
        return hasSoy;
    }

    public void setHasSoy(boolean hasSoy) {
        this.hasSoy = hasSoy;
    }

    public boolean isHasMocha() {
        return hasMocha;
    }

    public void setHasMocha(boolean hasMocha) {
        this.hasMocha = hasMocha;
    }

    public boolean isHasWhip() {
        return hasWhip;
    }

    public void setHasWhip(boolean hasWhip) {
        this.hasWhip = hasWhip;
    }
    
    public double cost(){
        double condimentCost = 0;
        if(hasMilk){
            condimentCost+=milkCost;
        }
        if(hasMocha){
            condimentCost+=mochaCost;
        }
        
        if(hasSoy){
            condimentCost+=soyCost;
        }
        
        if(hasWhip){
            condimentCost+= whipCost;
        }
        
        return condimentCost;
    }
}
public class DarkRoast extends Beverage {


    public DarkRoast() {
        setDescription("Most Excellent Dark Roast");
    }

    @Override
    public double cost() {
        return 2.3 + super.cost();
    }

}

```

这种方式存在几个问题：

1. 调料价格变东需要修改现有代码
2. 添加或删除新的调料，需要变动相应的变量和方法，以及 cost的计算。
3. 如果有新的饮料不适合原有调料加入，子类依然有这些没用的调料。
4. 如果想要双倍调料还需要修改cost并且添加变量。 由此看出这种方式明显违反了设计原则中的 开闭原则：对扩展开放，对修改关闭。在例子中，变化的是每种饮料的价格，价格需要根据调味品发生改变。那就先以饮料作为对象，用调味品对象装饰。

装饰模式类图结构

![image.png](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208271225028.webp)

从中可以看出：

1. 装饰者和被装饰着有相同的父类
2. 可以使用一个或多个装饰类装饰对象
3. 装饰对象可以替代被装饰类对象。
4. 装饰对象可以在被装饰者的行为执行前后进行操作。

根据装饰者模式进行调整

1. 先将饮料作为被封装者

![image.png](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208271225061.webp)

2.用摩卡装饰饮料

![image.png](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208271225111.webp)

3.再将被摩卡装饰的对象作为被装饰者，使用 奶泡进行装饰

![image.png](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208271225312.webp)

下面来看下代码

装饰和被装饰的父类

```java
public abstract class  Beverage {

    public abstract String getDescription();

    public abstract double cost();
}
```

被装饰者类

```java
public class DarkRoast extends Beverage {

    @Override
    public String getDescription() {
        return "DarkRoast";
    }

    @Override
    public double cost() {
        return 2.3 ;
    }

}
```

装饰者的父类

```java
public abstract class CondimentDecorator extends Beverage {
    private Beverage beverage;

    public CondimentDecorator (Beverage beverage){
        this.beverage = beverage;
    }

    public Beverage getBeverage() {
        return beverage;
    }

}
```

装饰者实现类

```java
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage){
        super(beverage);
    }

    @Override
    public String getDescription() {

        return getBeverage().getDescription()+" Mocha";
    }

    @Override
    public double cost() {
        return getBeverage().cost()+.20;
    }
}



public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage){
        super(beverage);
    }

    @Override
    public String getDescription() {

        return getBeverage().getDescription()+" Whip";
    }

    @Override
    public double cost() {
        return getBeverage().cost()+.10;
    }
}

```

调用情况

```java
public class Client {
    public static void main(String[] args) {
        //声明了具体构建
        Beverage beverage = new DarkRoast();
        System.out.println(beverage.getDescription()+" $ "+beverage.cost());

        //对其进行装饰
        Mocha mocha = new Mocha(beverage);
        System.out.println(mocha.getDescription()+" $ "+mocha.cost());

        Whip whip = new Whip(beverage);
        System.out.println(whip.getDescription()+" $ "+ whip.cost());
    }
}

```
![image-20220827124904754](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208271250750.png)

## Java I/O的装饰模式

java.io包内的类看起来比较多，其实就是利用了装饰模式

![image.png](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208271225042.webp)

其中：`InputStream`是装饰类和被装饰类的父类；`FileInputStream`，`StringBufferInputStream`，`ByteArrayInputStream`是被装饰类， `FilterInputStream`是装饰类的父类，`BufferedInputStream`，`LineNumberInputStream`，`DataInputStream`是装饰类。



## 使用环境

在以下情况下可以使用装饰模式：

- 在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
- 需要动态地给一个对象增加功能，这些功能也可以动态地被撤销。
- 当不能采用继承的方式对系统进行扩充或者采用继承不利于系统扩展和维护时。不能采用继承的情况主要有两类：第一类是系统中存在大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长；第二类是因为类定义不能继承（如final类）.



## 模式扩展

装饰模式的简化-需要注意的问题:

- 一个装饰类的接口必须与被装饰类的接口保持相同，对于客户端来说无论是装饰之前的对象还是装饰之后的对象都可以一致对待。
- 尽量保持具体构件类Component作为一个“轻”类，也就是说不要把太多的逻辑和状态放在具体构件类中，可以通过装饰类

对其进行扩展。 - 如果只有一个具体构件类而没有抽象构件类，那么抽象装饰类可以作为具体构件类的直接子类。