package top.devildyw.BridgeDesignPattern.Abstraction;

import top.devildyw.BridgeDesignPattern.Implementator.OSImpl;

/**
 * @author Devil
 * @since 2022-08-26-15:38
 * <p>
 * 抽象类
 * <p>
 * 定义了一个 Implementor (实现类接口) 类型的对象并可以维护该对象，它与 Implementor 之间具有关联关系，它既可以包含抽象业务方法，也可以包含具体业务方法。
 * <p>
 * 本质上就是组合  我们不是为每一个操作系统都编写对于不同文件的图像打印功能 而是通过桥接减少了类的产出
 * 使用桥接模式 如果增加一种操作系统 并且也需要读取这四种格式的文件 如果是常规多继承方法就需要编写4种方法 但是使用桥接模式 我们只需要增加一种新系统的打印方法即可
 * 就像画笔案例中 我们只需要增加增加一种新规格的毛笔即可 而不用准备12种新的蜡笔
 */
public abstract class Image {

    protected OSImpl osImpl;

    //注入实现类接口对象
    public Image(OSImpl osImpl) {
        this.osImpl = osImpl;
    }

    public abstract void parseFile(String fileName);
}
