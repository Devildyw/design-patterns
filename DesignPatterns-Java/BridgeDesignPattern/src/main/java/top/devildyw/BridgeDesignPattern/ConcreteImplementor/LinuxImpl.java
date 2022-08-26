package top.devildyw.BridgeDesignPattern.ConcreteImplementor;

import top.devildyw.BridgeDesignPattern.Implementator.OSImpl;
import top.devildyw.BridgeDesignPattern.Matrix;

/**
 * @author Devil
 * @since 2022-08-26-15:56
 *
 * 不同规格的毛笔
 */
public class LinuxImpl implements OSImpl {
    @Override
    public void doPaint(Matrix m) {
        System.out.print("在 Linux 操作系统中显示图像：");
    }
}
