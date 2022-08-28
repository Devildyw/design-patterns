package top.devildyw.FacadePattern.Facade;

import top.devildyw.FacadePattern.SubSystem.CPU;
import top.devildyw.FacadePattern.SubSystem.Disk;
import top.devildyw.FacadePattern.SubSystem.Memory;

/**
 * @author Devil
 * @since 2022-08-28-13:11
 * <p>
 * 外观角色
 * <p>
 * Computer包含了cpu、memory、disk 这几个部件,如果想要启动computer，则先后必须启动cpu、memory、disk。关闭也是如此。
 * <p>
 * 但是我们在电脑开/关机时根本不需要我们去操作这些角色,我们只按下了开/关机键,电脑就关机了, 之所以如此,是因为电脑已经帮我们都处理好了,并隐藏了这些东西,这些组件好比子系统角色,而电脑就是一个外观角色。
 * <p>
 * 外观模式松散了客户端与子系统的耦合关系,让子系统内部能更容易扩展和维护
 */
public class Computer {
    private CPU cpu;

    private Memory memory;

    private Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.disk = new Disk();
    }

    /**
     * 开机时 computer的startup方法 帮助我们调用了各个组件的开机方法
     */
    public void startup() {
        System.out.println("start the computer!");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finished!");
    }

    /**
     * 关机时 computer的shutdown方法 帮助我们调用了各个组件的关机方法
     */
    public void shutdown() {
        System.out.println("begin to close the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer closed!");
    }
}
