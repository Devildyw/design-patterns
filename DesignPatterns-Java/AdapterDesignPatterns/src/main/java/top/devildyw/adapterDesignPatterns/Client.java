package top.devildyw.adapterDesignPatterns;

import top.devildyw.adapterDesignPatterns.classType.*;

/**
 * @author Devil
 * @since 2022-08-25-16:46
 *
 * 测试类
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ChineseSocket chineseSocket = new ChineseSocketImpl();
        System.out.println(computer.useChineseSocket(chineseSocket));
        System.out.println("-----------类适配器-----------");
        ChineseAdapterEurope adapter = new ChineseAdapterEurope();
        System.out.println(computer.useChineseSocket(adapter));
        System.out.println();
        System.out.println("-----------对象适配器-----------");
        Computer computer1 = new Computer();
        EuropeSocket europeSocket = new EuropeSocketImpl();
        top.devildyw.adapterDesignPatterns.objectType.ChineseAdapterEurope adapter1 = new top.devildyw.adapterDesignPatterns.objectType.ChineseAdapterEurope(europeSocket);
        System.out.println(computer1.useChineseSocket(adapter1));
    }
}
