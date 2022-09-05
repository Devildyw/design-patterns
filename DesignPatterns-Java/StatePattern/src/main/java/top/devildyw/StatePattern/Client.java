package top.devildyw.StatePattern;

import top.devildyw.StatePattern.ConcreteState.BookedState;
import top.devildyw.StatePattern.ConcreteState.CheckInState;
import top.devildyw.StatePattern.ConcreteState.FreeState;
import top.devildyw.StatePattern.Context.HomeContext;

/**
 * 客户端
 *
 * @author Devil
 * @since 2022-09-05-13:49
 */
public class Client {
    public static void main(String[] args) {
        //获取房间对象
        HomeContext ctx = new HomeContext();
        //设置房间状态
        ctx.setState(new FreeState());
        System.out.println("----------------------------");
        ctx.setState(new BookedState());
        System.out.println("----------------------------");
        ctx.setState(new CheckInState());
    }
}
