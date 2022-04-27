package com.dyw.SingletonPattern.lazy;

/**
 * @author Devil
 * @date 2022-04-28-0:08
 *
 * <h1>单例模式之懒汉式</h1>
 * <p>
 * 之所以为饿汉式 他与饿汉式的区别在于 他是等待调用才初始化类生成实例, 而不是在程序运行初期就将类实例化
 *
 *
 * 本实例为了演示单例模式 在单例类中声明一个可以打印数组的方法
 * </p>
 * <br>
 * <h2>注意:</h2>
 * <p>
 *     该方法通常情况有个致命的问题 就是线程安全 我们都知道懒汉式是当被访问才会去生成实例 <br>
 *     但是一开始如果有多个线程来访问这个方法 怎么保证只会创建一个实例?
 * </p>
 */
public class LazySingleton {

    /**
     * 定义一个类实例的变量 用于等待调用 调用后 作为初始化对象的容器
     */
    private static LazySingleton LAZY_SINGLETON = null;
    /**
     * 构造器私有化 防止被调用重复生成实例
     */
    private LazySingleton(){

    }

    /**
     * 当被调用时 如果没有被实例化 则实例化
     * 已经实例化了 直接返回
     * <br>
     * <h2>注意:</h2>
     * 这种写法的缺点就是线程安全无法保证
     * @return LAZY_SINGLETON
     */
    public static LazySingleton getInstance(){
        //如果LAZY_SINGLETON为空
        if (LAZY_SINGLETON==null){
            LAZY_SINGLETON = new LazySingleton();
        }
        return LAZY_SINGLETON;
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
