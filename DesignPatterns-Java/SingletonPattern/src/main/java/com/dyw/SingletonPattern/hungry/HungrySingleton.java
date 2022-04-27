package com.dyw.SingletonPattern.hungry;

/**
 * @author Devil
 * @date 2022-04-28-0:08
 *
 * <br>
 * <h1>单例模式之饿汉式</h1>
 * <p>
 *  之所以为饿汉式 他与懒汉式的区别在于 他不是等待调用才初始化类生成实例, 而是在程序运行初期就将类实例化
 *  当被调用生成实例时 直接返回.
 *
 *  本实例为了演示单例模式 在单例类中声明一个可以打印数组的方法
 * </p>
 *
 */
public class HungrySingleton {
    /**
     * 在程序加载时 就将类初始化 生成实例
     */
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    //方式二: 静态代码块
//    private static HungrySingleton HUNGRY_SINGLETON = null;
//    static {
//        HUNGRY_SINGLETON = new HungrySingleton();
//    }
    /**
     * 构造器私有化 防止重复创建类
     */
    private HungrySingleton(){

    }

    /**
     * 当被调用时 直接将该方法返回即可
     * @return HUNGRY_SINGLETON
     */
    public static HungrySingleton getInstance(){
        return HUNGRY_SINGLETON;
    }

    /**
     * 创建一个可以打印数组的方法 用于测试
     * @param array 数组
     */
    public void print(int[] array){
        for (int t : array) {
            System.out.println(t);
        }
    }

}
