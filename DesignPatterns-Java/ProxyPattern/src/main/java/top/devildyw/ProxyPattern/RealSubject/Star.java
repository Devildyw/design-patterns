package top.devildyw.ProxyPattern.RealSubject;

import top.devildyw.ProxyPattern.Subject.Subject;

/**
 * @author Devil
 * @since 2022-08-30-11:21
 * <p>
 * 真实主题角色
 * <p>
 * 明星 经济公司是不会让明显亲自去接戏的,一般会让明星的助理或则经纪人去帮忙做这件事,而明星只用负责拍戏就行。 这里的经纪人就是代理明星去接戏的一个角色。
 */
public class Star implements Subject {

    @Override
    public void movie() {
        System.out.println(getClass().getSimpleName() + ": 经纪人接了一部电影,我负责拍就好");
    }
}
