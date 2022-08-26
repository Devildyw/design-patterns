## 1 概述

> 推荐一读的概述

毛笔和蜡笔是两种很常见的文具，它们都归属于画笔。假设需要大、中、小 3 种型号的画笔，能够绘制 12 种不同的颜色，如果使用蜡笔，需要准备 3 × 12 = 36 支，但是如果使用毛笔，只需要提供 3 种型号的毛笔，外加一个包含 12 种颜色的调色板，涉及的对象个数仅为 3 + 12 = 15，远小于 36 ，却能够实现 36 支蜡笔同样的功能。如果增加一种新型号的画笔，并且也需要具有 12 种颜色，对应的蜡笔需要增加 12 支，而毛笔只需要增加 1 支。

不难得知，在蜡笔中，颜色和型号两个不同的变化维度耦合在一起，无论是对颜色进行扩展还是对型号进行扩展势必会影响另一个维度；但在毛笔中，颜色和型号实现了分离，增加新的颜色或者型号对另一方没有任何影响。如果使用软件工程中的术语，可以认为在蜡笔中颜色和型号之间存在较强的耦合性，而毛笔很好地将二者解耦，使用起来更加的灵活，扩展也更为方便。在软件开发中有一种设计模式可以用来处理与画笔类似的具有多变化维度的情况，这就是**桥接模式**。

在桥接模式中将两个独立变化的维度设计为两个独立的继承等级结构，而不是将二者耦合在一起形成多层继承结构。桥接模式在抽象层建立起一个抽象关联，该关联关系类似一条连接两个独立继承结构的桥，故名桥接模式。

> **桥接模式**：将抽象部分与它的实现部分解耦，使得两者都能够独立变化。

桥接模式是一种对象结构型模式，它又被称为柄体（Handle and Body）模式或接口（Interface）模式。桥接模式用一种巧妙地方式处理多层继承存在的问题，用抽象关系取代了传统的多层继承，将类之间的静态继承关系转换为动态的对象组合关系，使得系统更加灵活，并易于扩展，同时有效地控制了系统中类的个数。

## 2 结构与实现

### 2.1 桥接模式结构

桥接模式包含以下 4 个角色：

1. **Abstraction(抽象类)**：其中定义了一个实现类接口类型的对象并可以维护该对象，它与 Implementor 之间具有关联关系，它既可以包含抽象业务方法，也可以包含具体业务方法。
2. **RefinedAbstraction(扩充抽象类)**：它扩充由抽象类定义的接口，它实现了在抽象类中定义的抽象业务方法，**在扩充抽象类中可以调用在实现类接口中定义的业务方法；**
3. **Implementor(实现类接口)**：实现类接口定义了实现类的接口，实现类接口仅提供基本操作，而抽象类定义的接口可能会做更多更复杂的操作；
4. **ConcreteImplementor(具体实现类)**：具体实现类实现了实现类接口并且具体实现它，在不同的具体实现类中提供基本操作的不同实现，在程序运行时，具体实现类对象将替换其父类对象，提供给客户端具体的业务操作方法。

### 2.2 桥接模式举例

#### 一、背景介绍

某软件公司要开发一个跨平台图像浏览系统，要求该系统能够显示 BMP、JPG、GIF、PNG 等多种格式的文件，并且能够在 Windows、Linux、UNIX 等多个操作系统上运行。系统首先将各种格式的文件解析为像素矩阵（Matrix），然后将像素矩阵显示在屏幕上，在不同的操作系统中可以调用不同的绘制函数来绘制像素矩阵。系统需要具有较好的扩展性，以便在将来支持新的文件格式和操作系统。请使用桥接模式。

#### 二、项目结构



![image-20220826161740971](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208261617013.png)



#### 三、项目 UML



![UML](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208261615858.webp)



#### 四、抽象类

##### Image 抽象类

```java
public abstract class Image {

    protected OSImpl osImpl;

    //注入实现类接口对象
    public Image(OSImpl osImpl) {
        this.osImpl = osImpl;
    }

    public abstract void parseFile(String fileName);
}

```

#### 五、扩充抽象类

##### BMPImage 扩充抽象类

```java
public class BMPImage extends Image {

    public BMPImage(OSImpl osImpl) {
        super(osImpl);
    }

    @Override
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获取一个像素矩阵对象 m
        Matrix matrix = new Matrix();
        osImpl.doPaint(matrix);
        System.out.println(fileName+", 格式为BMP.");
    }
}
```

##### JPGImage 扩充抽象类

```java
public class JPGImage extends Image {
    public JPGImage(OSImpl osImpl) {
        super(osImpl);
    }

    @Override
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获取一个像素矩阵对象 m
        Matrix matrix = new Matrix();
        osImpl.doPaint(matrix);
        System.out.println(fileName+", 格式为JPG.");
    }
}

```

##### GIFImage 扩充抽象类

```java
public class GIFImage extends Image {
    public GIFImage(OSImpl osImpl) {
        super(osImpl);
    }

    @Override
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获取一个像素矩阵对象 m
        Matrix matrix = new Matrix();
        osImpl.doPaint(matrix);
        System.out.println(fileName+", 格式为GIF.");
    }
}
```

##### PNGImage 扩充抽象类

```java
public class PNGImage extends Image {

    public PNGImage(OSImpl osImpl) {
        super(osImpl);
    }

    @Override
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获取一个像素矩阵对象 m
        Matrix matrix = new Matrix();
        osImpl.doPaint(matrix);
        System.out.println(fileName+", 格式为PNG.");
    }
}

```

#### 六、实现类接口

##### OSImpl

```java
public interface OSImpl {
    public void doPaint(Matrix m);
}

```

#### 七、具体实现类

##### WindowsImpl

```java
public class WindowImpl implements OSImpl {

    @Override
    public void doPaint(Matrix m) {
        System.out.print("在 Windows 操作系统中显示图像：");
    }
}
```

##### LinuxImpl

```java
public class LinuxImpl implements OSImpl {
    @Override
    public void doPaint(Matrix m) {
        System.out.print("在 Linux 操作系统中显示图像：");
    }
}

```

##### UnixImpl

```java
public class UnixImpl implements OSImpl {
    @Override
    public void doPaint(Matrix m) {
        System.out.print("在 Unix 操作系统中显示图像：");
    }
}

```

#### 八、Matrix 辅助类

```java
public class Matrix {
}
```

#### 九、测试客户类

```java
public class Client {
    public static void main(String[] args) {
        Image image;
        image = new GIFImage(new WindowImpl());
        image.parseFile("杜颖淼");
        System.out.println("--------------------------------------------");
        image = new PNGImage(new LinuxImpl());
        image.parseFile("这是一个文件");


    }
}
```

#### 十、测试结果

![image-20220826162105535](https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202208261621578.png)



## 3 总结

从举例容易看出，客户端面向抽象编程，每个维度都有一个高级抽象类，每个维度的具体选项继承自该高级抽象类。**举例中我们通过 xml 配置文件配置各个维度的选择，选择什么类型的图片？选择什么操作系统？实现了不同维度的的解耦。**

桥接模式十设计 Java 虚拟机和实现 JDBC 等驱动程序的核心模式之一，应用较为广泛。在软件开发中如果一个类或一个系统有多个变化维度都可以尝试使用桥接模式对其进行设计。桥接模式为多维度变化的系统提供了一套完整的解决方案，并且降低了系统的复杂度。

### 3.1 桥接模式优点

1. 分离抽象接口及其实现部分。桥接模式使用“对象间的关联关系”解耦了抽象和实现之间固有的绑定关系，使得抽象和实现可以沿着各自的维度来变化。所谓的抽象何实现沿着各自维度的变化，也就是说抽象和实现不在同一个继承层次结构中，而是“子类化”它们，使它们各自具有自己的子类，以便任意组合子类，从而获得多维度组合对象。
2. 在很多情况下，桥接模式可以取代多层继承方案，多层继承方案违背了单一职责原则，复用性较差，并且类的个数非常多，桥接模式是比多层继承方案更好的解决方法，它极大地减少了子类的个数。
3. 桥接模式提高了系统的可扩展性，在两个变化维度中任意扩展一个维度都不需要修改原有系统，符合开闭原则。

### 3.2 桥接模式缺点

1. 桥接模式的使用会增加系统的理解和设计难度，由于关联关系建立在抽象层，要求开发者一开始就针对抽象层进行设计与编程。
2. 桥接模式要求正确地识别出系统中地两个独立变化的维度，因此其使用的范围具有一定的局限性，如何正确识别两个独立维度也需要一定的经验积累。

### 3.3 桥接模式适用环境

1. 如果一个系统需要在抽象化和具体化之间增加更多的灵活性，避免在两个层次之间建立静态的继承关系，通过桥接模式可以使它们在抽象层建立一个关联关系。
2. 抽象部分和实现部分可以用继承的方式独立扩展而互不影响，在程序运行时可以动态地将一个抽象化子类地对象和一个实现化子类地对象进行组合，即系统需要对抽象化角色和实现化角色进行多态耦合。
3. 一个类存在两个（或多个）独立变化的维度，且这两个（或多个）维度都需要独立进行扩展。
4. 对于那些不希望使用继承或因为多层继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。

> 抽象类和实现类接口都可以对调，因为对于不同规格的毛笔而言，每一种规格都可以有不同的颜色使用；对于不同的颜色而言每一种颜色都有不同规格的毛笔来使用。我们使用时权衡即可。
# 推荐链接

[秒懂设计模式之桥接模式（Bridge Pattern） - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/58903776)


