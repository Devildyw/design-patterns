package top.devildyw.FacadePattern.SubSystem;

/**
 * @author Devil
 * @since 2022-08-28-13:09
 *
 * 子系统角色 disk
 */
public class Disk {
    public void startup() {
        System.out.println("disk startup!");
    }

    public void shutdown() {
        System.out.println("disk shutdown!");
    }
}