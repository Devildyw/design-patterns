package top.devildyw.adapterDesignPatterns.classType;

/**
 * @author Devil
 * @since 2022-08-25-16:44
 * 适配器类 类适配器
 *
 * 为了将适配者适配为目标类 需要使用现有组件的方法实现目标接口的规范 这里使用继承类的方式来拥有适配者的方法和变量 但是这种方式并不安全
 */
public class ChineseAdapterEurope extends EuropeSocketImpl implements ChineseSocket{
    @Override
    public String userChineseSocket() {
        System.out.println("使用转化器转化完成");
        return userEuropeSocket();
    }
}
