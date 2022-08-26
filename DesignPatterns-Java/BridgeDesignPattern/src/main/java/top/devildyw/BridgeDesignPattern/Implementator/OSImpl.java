package top.devildyw.BridgeDesignPattern.Implementator;

import top.devildyw.BridgeDesignPattern.Matrix;

/**
 * @author Devil
 * @since 2022-08-26-15:39
 *
 * Implementor(实现类接口)
 * <p>
 * 在画笔案例中 充当毛笔的角色 我们只需要实现这个接口 去完成不同规格的毛笔即可
 */
public interface OSImpl {
    public void doPaint(Matrix m);
}
