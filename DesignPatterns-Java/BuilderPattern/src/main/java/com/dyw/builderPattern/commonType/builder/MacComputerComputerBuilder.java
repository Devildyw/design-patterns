package com.dyw.builderPattern.commonType.builder;

import com.dyw.builderPattern.commonType.product.Computer;

/**
 * @author Devil
 * @since 2022-06-20-18:41
 * <br>
 * <h1>该类属于建造者设计模式中的具体建造者角色 在这里的作用是建造Mac电脑</h1>
 */
public class MacComputerComputerBuilder extends ComputerBuilder {
    private Computer computer;

    public MacComputerComputerBuilder(String cpu, String ram){
        computer = new Computer(cpu,ram);
    }
    @Override
    public void setUsbCount() {
        computer.setUsbCount(2);
    }

    @Override
    public void setKeyboard() {
        computer.setKeyboard("Mac键盘");
    }

    @Override
    public void setDisplay() {
        computer.setDisplay("Mac显示器");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
