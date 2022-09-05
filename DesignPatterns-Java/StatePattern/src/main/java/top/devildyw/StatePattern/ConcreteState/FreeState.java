package top.devildyw.StatePattern.ConcreteState;

import top.devildyw.StatePattern.State.State;

/**
 * 空闲状态
 *
 * @author Devil
 * @since 2022-09-05-13:43
 */
public class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("房间空闲！！！欢迎入住！");
    }
}
