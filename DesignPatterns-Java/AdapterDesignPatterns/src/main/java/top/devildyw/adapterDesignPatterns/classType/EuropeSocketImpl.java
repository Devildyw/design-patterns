package top.devildyw.adapterDesignPatterns.classType;

/**
 * @author Devil
 * @since 2022-08-25-16:41
 *
 * 目标接口实现类
 */
public class EuropeSocketImpl implements EuropeSocket {
    @Override
    public String userEuropeSocket() {
        String msg = "使用欧式三叉充电";
        return msg;
    }
}
