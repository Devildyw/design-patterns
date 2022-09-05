package top.devildyw.StatePattern.ConcreteState;

import top.devildyw.StatePattern.State.State;

/**
 * 具体状态类
 * <p>
 * 以入住状态
 *
 * @author Devil
 * @since 2022-09-05-13:44
 */
public class CheckInState implements State {
    @Override
    public void handle() {
        System.out.println("房间已入住！请勿打扰！");
    }
}
