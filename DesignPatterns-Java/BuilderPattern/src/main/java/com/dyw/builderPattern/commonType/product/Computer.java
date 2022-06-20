package com.dyw.builderPattern.commonType.product;

/**
 * @author Devil
 * @since 2022-06-20-18:23
 * <br>
 * <p>
 *     该类属于建造者设计模式中的产品角色 该类有2个必须有的参数和3个可选的参数(实际上也可以都是可选参数 这里只做举例)
 *     想要构造出一个这样的类的实例,通常我们会想到使用可折叠的构造函数的方式,或是javabean的getter setter方式
 *     但是这两种方法有着不同的缺点
 * </p>
 * <p>
 *     第一种主要是使用及阅读不方便。你可以想象一下，当你要调用一个类的构造函数时，你首先要决定使用哪一个，
 *     然后里面又是一堆参数，如果这些参数的类型很多又都一样，你还要搞清楚这些参数的含义，很容易就传混了。。。那酸爽谁用谁知道。
 * </p>
 * <p>
 *     第二种方式在构建过程中对象的状态容易发生变化，造成错误。因为那个类中的属性是分步设置的，所以就容易出错。
 * </p>
 * <p><strong>正是因为这两种方式的缺点 建造者模式诞生了</strong></p>
 */
public class Computer {
    /**
     * cpu 属于必须构件
     */
    private String cpu;

    /**
     * ram 属于必须构件
     */
    private String ram;

    /**
     * usb接口数量 属于可选构件
     */
    private int usbCount;

    /**
     * 键盘 属于可选构件
     */
    private String keyboard;

    /**
     * 屏幕 属于可选构件
     */
    private String display;

    /**
     * 既然是必选的参数 那么每次构造该类的实例都应该有这两参数 其他的参数可选就靠set方法构建
     * @param cpu cpu
     * @param ram ran
     */
    public Computer(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getUsbCount() {
        return usbCount;
    }

    public void setUsbCount(int usbCount) {
        this.usbCount = usbCount;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", usbCount=" + usbCount +
                ", keyboard='" + keyboard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }
}
