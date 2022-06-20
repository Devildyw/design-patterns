package com.dyw.builderPattern.commonType.director;

import com.dyw.builderPattern.commonType.builder.ComputerBuilder;

/**
 * @author Devil
 * @since 2022-06-20-18:48
 * <br>
 * <h1>该类为建造者设计模式中的指导者类 在这里的作用是指导生产电脑</h1>
 */
public class ComputerDirector {
    public void makeComputer(ComputerBuilder builder){
        builder.setDisplay();
        builder.setKeyboard();
        builder.setUsbCount();
    }
}
