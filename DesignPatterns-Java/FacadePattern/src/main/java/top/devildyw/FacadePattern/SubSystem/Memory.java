package top.devildyw.FacadePattern.SubSystem;

/**
 * @author Devil
 * @since 2022-08-28-13:10
 *
 * 子系统角色 memory
 */
public class Memory {
    public void startup(){
        System.out.println("memory startup!");
    }
    public void shutdown(){
        System.out.println("memory shutdown!");
    }
}
