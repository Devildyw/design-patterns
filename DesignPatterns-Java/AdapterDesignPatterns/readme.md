# 设计模式--结构型设计模式之适配器模式

## 一、前言

### 1）概述

​		在现实生活中，经常出现两个对象因接口不兼容而不能在一起工作的实例，这时需要第三者进行适配。例如，讲中文的人同讲英文的人对话时需要一个翻译，用直流电的笔记本电脑接交流电源时需要一个电源适配器，用计算机访问照相机的 SD 内存卡时需要一个读卡器等。还有像下面这张图一样：

![在这里插入图片描述](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208251751012.webp)

​		在软件设计中也可能出现：

1. **需要开发的具有某种业务功能的组件在现有的组件库中已经存在，但它们与当前系统的接口规范不兼容，如果重新开发这些组件成本又很高，这时用适配器模式能很好地解决这些问题。**
2. 如果想增加现有组件的复用率也可以使用适配器模式。

### 2）介绍

适配器模式（Adapter）的定义如下：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。适配器模式分为类结构型模式和对象结构型模式两种，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。

Adapter模式的宗旨：**保留现有类所提供的服务，向客户提供接口，以满足客户的期望**。

### 3）角色结构

适配器模式（Adapter）包含以下主要角色：

- 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
- 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
- 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。

### 4）使用场景

适配器模式（Adapter）通常适用于以下场景。

- 以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致。（~~就是所谓的加一层，一层不行就加两层~~）😁
- 使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同。

## 二、类适配器

当客户在接口中定义了他期望的行为时，我们就可以应用适配器模式，提供一个实现该接口的类，并且扩展已有的类，通过创建子类来实现适配。

`实现方式`：**定义一个适配器类来实现当前系统的业务接口，同时又继承现有组件库中已经存在的组件**。

我们直接用之前的那个图来做个例子：中国人到了欧洲，的给自己电脑充电，但因为自己电脑是双叉，欧式是三叉，这中间就得需要一个转换器。**对于电脑而言，它只能是双叉的，但是现在只有三叉的插座，想要充电，就必须能让双叉的插头能够插入三叉的插座上，此时我们需要一个适配器，将三叉插座的电传输给双叉的插头。此时的目标是双叉，需要将三叉的电传输到双叉的线上。**

> 可能使用sd卡和tf卡的案例比较好理解，对于同一台电脑而言它只能插入sd卡，但是呢我们现在不想让他插入sd读取数据了，我想让他读取tf卡，但是电脑不能匹配，此时就只能使用tf卡转sd的适配器了，通过读sd的方式读取了tf卡。对于该问题，目标接口就是sd卡，而适配者是tf卡，tf卡不符合现有接口规范（sd卡），需要通过适配器（适配器通过现有组件tf的读写方式实现了sd接口的规范）完成了转化。

![在这里插入图片描述](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208251751008.webp)

### 2.1、代码

适配者（Adaptee）：即图中的欧式三叉

```java
public interface EuropeSocket {
    /** 欧式三叉 通电 接通电 插座*/
    String useEuropesocket();
}

// 欧式三叉实现类
public class EuropeSocketImpl implements EuropeSocket {

    @Override
    public String useEuropesocket() {
        String msg ="使用欧式三叉充电";
        return msg;
    }
}
```

目标（Target）接口：即中国双叉

```java
public interface ChineseSocket {
    /**
     * 使用中国双叉充电
     * @return
     */
    String useChineseSocket();
}

// 中国插头的实现类
public class ChineseSocketImpl implements ChineseSocket {

    @Override
    public String useChineseSocket() {
        String msg="使用中国双叉充电";
        return msg;
    }
}
```

适配器（Adapter）类：

```java
/**
 * 定义适配器类 中国双叉转为欧洲三叉
 *
 */
public class ChineseAdapterEurope extends EuropeSocketImpl implements ChineseSocket {

    @Override
    public String useChineseSocket() {
        System.out.println("使用转换器转换完成");
        return useEuropesocket();
    }
}
```

电脑类，对于电脑类而言，它只能使用双叉的充电器，所以客户端希望的目标类就是中国双叉。

```java
public class Computer {

    public String useChineseSocket(ChineseSocket chineseSocket) {
        if(chineseSocket == null) {
            throw new NullPointerException("sd card null");
        }
        return chineseSocket.useChineseSocket();
    }
}
```

测试：

```java
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ChineseSocket chineseSocket = new ChineseSocketImpl();
        System.out.println(computer.useChineseSocket(chineseSocket));
        System.out.println("------------");
        ChineseAdapterEurope adapter = new ChineseAdapterEurope();
        System.out.println(computer.useChineseSocket(adapter));
        /**
         * 输出：
         * 使用中国双叉充电
         * ------------
         * 使用转换器转换完成
         * 使用欧式三叉充电
         */
    }
}
```

上述代码就是简单的演示了适配器的使用。

`注`:类适配器模式违背了合成复用原则。类适配器是客户类有一个接口规范的情况下可用，反之不可用。

## 三、对象适配器

对象适配器”通过组合除了满足“用户期待接口”还降低了代码间的不良耦合。在工作中推荐使用“对象适配”。

实现方式：**对象适配器模式可釆用将现有组件库中已经实现的组件引入适配器类中，该类同时实现当前系统的业务接口**。

题目还是和上面一样的哈。代码其实差异很小

### 代码

适配者（Adaptee）：即图中的欧式三叉

```java
public interface EuropeSocket {
    /** 欧式三叉 通电 接通电 插座*/
    String useEuropesocket();
}

// 欧式三叉实现类
public class EuropeSocketImpl implements EuropeSocket {

    @Override
    public String useEuropesocket() {
        String msg ="使用欧式三叉充电";
        return msg;
    }
}
```

目标（Target）接口：即中国双叉

```java
public interface ChineseSocket {
    /**
     * 使用中国双叉充电
     * @return
     */
    String useChineseSocket();
}

// 中国插头的实现类
public class ChineseSocketImpl implements ChineseSocket {

    @Override
    public String useChineseSocket() {
        String msg="使用中国双叉充电";
        return msg;
    }
}
```

适配器（Adapter）类： 就是这个适配器内做了一些更改 从继承改为了成员变量的方式

```java
public class ChineseAdapterEurope implements ChineseSocket {

    private EuropeSocket europeSocket;

    public ChineseAdapterEurope(EuropeSocket europeSocket) {
        this.europeSocket = europeSocket;
    }

    @Override
    public String useChineseSocket() {
        System.out.println("使用转换器转换完成");
        return europeSocket.useEuropesocket();
    }
}
```

电脑类

```java
public class Computer {

    public String useChineseSocket(ChineseSocket chineseSocket) {
        if(chineseSocket == null) {
            throw new NullPointerException("sd card null");
        }
        return chineseSocket.useChineseSocket();
    }
}
```

测试：

```java
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ChineseSocket chineseSocket = new ChineseSocketImpl();
        System.out.println(computer.useChineseSocket(chineseSocket));

        System.out.println("------------");
        //这里做了更改
        EuropeSocket europeSocket=new EuropeSocketImpl();
        ChineseAdapterEurope adapter = new ChineseAdapterEurope(europeSocket);
        System.out.println(computer.useChineseSocket(adapter));
        /**
         * 输出：
         * 使用中国双叉充电
         * ------------
         * 使用转换器转换完成
         * 使用欧式三叉充电
         */
    }
}
```

这就是对象适配器啦，

适合于解决问题常见：

- 　需要的东西有，但不能用，且短时间无法改造。即，使得一个功能适合不同的环境。
- 　　在开发中，系统的数据、行为都匹配，但接口不符时，可以考虑适配器。
- 　　**希望复用一些现存的类，但是接口又与复用环境的要求不一致，应该考虑用适配器模式。**（使用一个已经存在的类，但它的接口（即，方法)，与需要的不相同时）

### 扩展

**适配器模式（Adapter）可扩展为双向适配器模式，双向适配器类既可以把适配者接口转换成目标接口，也可以把目标接口转换成适配者接口**。

## 四、总结

**优点**：

- 客户端通过适配器可以透明地调用目标接口。
- 复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。**提高了类的复用**
- **将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题**。灵活性好
- 可以让任何两个没有关联的类一起运行
- **在很多业务场景中符合开闭原则**

**其缺点是**：

- 适配器编写过程需要结合业务场景全面考虑，可能会增加系统的复杂性。
- 增加代码阅读难度，降低代码可读性，过多使用适配器会使系统代码变得凌乱。（如：明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，一个系统如果太多出现这种情况，无异于一场灾难）

**核心思想：**

继承或者依赖（引用）适配者对象，然后实现目标的接口。确保原来代码不改变的情况下，增加新的功能。

因为目标类是需要使用的，而我们现在并不能直接使用目标类（一个已存在的类，但是它不符合现有的接口规范），而需要通过适配器将现有的组件转化为目标类，所以适配器需由现有组件实现目标接口的功能（转化使其符合现有规范）来完成转化。