package top.devildyw.FacadePattern.SubSystem;

/**
 * @author Devil
 * @since 2022-08-28-13:09
 *
 * 子系统角色 cpu
 */
public class CPU {
    public void startup(){
        System.out.println("cpu startup!");
    }

    public void shutdown(){
        System.out.println("cpu shutdown!");
    }
}
