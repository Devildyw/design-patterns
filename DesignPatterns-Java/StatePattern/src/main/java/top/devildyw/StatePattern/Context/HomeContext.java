package top.devildyw.StatePattern.Context;

import top.devildyw.StatePattern.State.State;

/**
 * 状态上下文
 * <p>
 * 房间对象
 *
 * @author Devil
 * @since 2022-09-05-13:40
 */
public class HomeContext {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        System.out.println("修改状态!");
        this.state = state;
        //不同状态响应的处理
        state.handle();
    }

}
