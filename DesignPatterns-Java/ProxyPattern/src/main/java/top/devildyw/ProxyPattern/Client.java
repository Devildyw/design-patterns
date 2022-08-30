package top.devildyw.ProxyPattern;

import top.devildyw.ProxyPattern.Proxy.Agent;
import top.devildyw.ProxyPattern.RealSubject.Star;
import top.devildyw.ProxyPattern.Subject.Subject;

/**
 * @author Devil
 * @since 2022-08-30-11:27
 *
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        Subject star = new Star();
        Subject proxy = new Agent(star);

        proxy.movie();


    }
}
