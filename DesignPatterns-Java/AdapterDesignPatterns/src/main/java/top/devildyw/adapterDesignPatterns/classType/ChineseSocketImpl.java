package top.devildyw.adapterDesignPatterns.classType;

/**
 * @author Devil
 * @since 2022-08-25-16:43
 *
 * 适配者接口实现类
 */
public class ChineseSocketImpl implements ChineseSocket {
    @Override
    public String userChineseSocket() {
        String msg = "使用中国双叉充电";
        return msg;
    }
}
