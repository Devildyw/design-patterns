package top.devildyw.adapterDesignPatterns.objectType;

import top.devildyw.adapterDesignPatterns.classType.ChineseSocket;
import top.devildyw.adapterDesignPatterns.classType.EuropeSocket;
import top.devildyw.adapterDesignPatterns.classType.EuropeSocketImpl;

/**
 * @author Devil
 * @since 2022-08-25-16:44
 * 适配器类 类适配器
 *
 * 为了将适配者适配为目标类 首先为了符合现有规范需要实现目标接口 其次 与类适配器模式不同 它不需要继承适配者类 而是将适配者类通过成员变量的方式引入
 */
public class ChineseAdapterEurope implements ChineseSocket {
    private EuropeSocket europeSocket;

    public ChineseAdapterEurope(EuropeSocket europeSocket){
        this.europeSocket = europeSocket;
    }


    @Override
    public String userChineseSocket() {
        System.out.println("使用转化器完成");
        return europeSocket.userEuropeSocket();
    }
}
