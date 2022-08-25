package top.devildyw.adapterDesignPatterns.classType;

/**
 * @author Devil
 * @since 2022-08-25-16:45
 *
 * 电脑类 这里演示电脑充电 我们只有一个两脚插头 但是插座确实三脚的 需要通过适配将2脚插头插入三角插座中
 */
public class Computer {
    public String useChineseSocket(ChineseSocket chineseSocket){
        if (chineseSocket==null){
            throw new NullPointerException("sd card null");
        }
        return chineseSocket.userChineseSocket();
    }
}
