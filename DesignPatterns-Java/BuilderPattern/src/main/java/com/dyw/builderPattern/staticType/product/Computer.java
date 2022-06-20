package com.dyw.builderPattern.staticType.product;

/**
 * @author Devil
 * @since 2022-06-20-18:23
 * <br>
 * <p>
 *     该种方式就是建造者静态内部类实现方式 也就是我们常见的链式赋值<br>
 *     1.在Computer 中创建一个静态内部类 Builder 定义一个我们需要的具体产品<br>
 *     2.在Computer中创建一个private的构造函数，参数为Builder类型<br>
 *     3.在Builder中创建一个public的构造函数，参数为Computer中必填的那些参数，cpu 和ram。<br>
 *     4.在Builder中创建设置函数，对Computer中那些可选参数进行赋值，返回值为Builder类型的实例<br>
 *     5.在Builder中创建一个build()方法，返回我们构建的实例
 * </p>
 * <br>
 * <p>一般情况下，我们更习惯使用静态内部类的方式实现建造者模式，即一个产品类内部自动带有一个具体建造者，由它负责该产品的组装创建，不再需要 Builder 和 Director。这样做可以使产品表示与创建之间的联系更加紧密，结构更加紧凑，同时使得建造者模式更加简洁。</p>
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

    public static class Builder {
        private Computer computer;

        public Builder(String cpu, String ram) {
            computer = new Computer(cpu,ram);
        }

        public Builder setUsbCount(int usbCount) {
            computer.setUsbCount(usbCount);
            return this;
        }

        public Builder setKeyBoard(String keyBoard) {
            computer.setKeyboard(keyBoard);
            return this;
        }

        public Builder setDisPlay(String display) {
            computer.setDisplay(display);
            return this;
        }

        public Computer builder() {
            return computer;
        }
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
