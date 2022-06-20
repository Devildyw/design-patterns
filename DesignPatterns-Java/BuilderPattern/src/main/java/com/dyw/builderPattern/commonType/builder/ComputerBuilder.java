package com.dyw.builderPattern.commonType.builder;

import com.dyw.builderPattern.commonType.product.Computer;

/**
 * @author Devil
 * @since 2022-06-20-18:36
 * <br>
 * <h1>该类属于建造者设计模式中的抽象建造者角色</h1>
 */
public abstract class ComputerBuilder {
    /**
     * 设置usb接口数量
     */
    public abstract void setUsbCount();

    /**
     * 设置键盘
     */
    public abstract void setKeyboard();

    /**
     * 设置屏幕
     */
    public abstract void setDisplay();

    /**
     * 返回构建好的产品
     * @return Computer
     */
    public abstract Computer getComputer();
}
