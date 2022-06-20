package com.dyw.builderPattern.commonType.client;

import com.dyw.builderPattern.commonType.builder.ComputerBuilder;
import com.dyw.builderPattern.commonType.builder.LenovoComputerComputerBuilder;
import com.dyw.builderPattern.commonType.builder.MacComputerComputerBuilder;
import com.dyw.builderPattern.commonType.director.ComputerDirector;
import com.dyw.builderPattern.commonType.product.Computer;

/**
 * @author Devil
 * @since 2022-06-20-18:50
 * <br>
 * <h1>演示类 向读者演示建造者设计模式 方便读者的理解</h1>
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("================Mac电脑================");
        //1. 首先创建指导者 他来指导生产电脑
        ComputerDirector director = new ComputerDirector();
        //2. 创建具体建造类
        ComputerBuilder builder = new MacComputerComputerBuilder("M1处理器", "三星125");
        //3. 调用指导者的方法生成产品
        director.makeComputer(builder);
        //4. 产品构造完毕 取出产品
        Computer computer = builder.getComputer();
        //5. 检验结果
        System.out.println(computer);

        System.out.println("================Lenovo电脑================");
        //步骤同上
        builder = new LenovoComputerComputerBuilder("I9处理器", "海力士222");
        director.makeComputer(builder);
        computer = builder.getComputer();
        System.out.println(computer);
    }
}
