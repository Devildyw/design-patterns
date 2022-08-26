package top.devildyw.BridgeDesignPattern.ConcreteImplementor;

import top.devildyw.BridgeDesignPattern.Implementator.OSImpl;
import top.devildyw.BridgeDesignPattern.Matrix;

/**
 * @author Devil
 * @since 2022-08-26-15:40
 * <p>
 * ConcreteImplementor(具体实现类)
 * <p>
 * 实现类接口的实现类 实现了实现类接口中定义的方法
 * <p>
 * 不同规格的毛笔
 */
public class WindowImpl implements OSImpl {

    @Override
    public void doPaint(Matrix m) {
        System.out.print("在 Windows 操作系统中显示图像：");
    }
}
