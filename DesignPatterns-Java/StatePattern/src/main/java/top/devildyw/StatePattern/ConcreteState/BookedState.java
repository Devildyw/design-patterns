package top.devildyw.StatePattern.ConcreteState;

import top.devildyw.StatePattern.State.State;

/**
 * 具体状态类
 * <p>
 * 已预定状态
 *
 * @author Devil
 * @since 2022-09-05-13:44
 */
public class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已预定！别人不能再定！");
    }
}
