package top.devildyw.ProxyPattern.Proxy;

import top.devildyw.ProxyPattern.Subject.Subject;

/**
 * @author Devil
 * @since 2022-08-30-11:24
 * <p>
 * 代理主题角色
 * <p>
 * 因为明星不能亲自去接戏,所以经纪人代理明星去接戏,而明星只用负责拍戏。
 */
public class Agent implements Subject {

    //被代理对象  代理角色持有被代理角色的引用
    private Subject star;

    //创建时注入
    public Agent(Subject star) {
        this.star = star;
    }

    /**
     * 为代理角色添加了额外的服务 这里是接戏
     */
    @Override
    public void movie() {
        System.out.println(getClass().getSimpleName() + ": 剧本很好，这部电影接下了");
        star.movie();
    }
}
