package com.dyw.SingletonPattern.lazy;

/**
 * @author Devil
 * @date 2022-04-28-0:31
 *
 * <h1>单例模式之懒汉式线程安全版</h1>
 *
 * <p>该类为普通懒汉式的改良版 具有多线程访问线程安全的特点 也提高了单例模式的可用性 其核心思路就是上锁</p>
 */
public class LazySingletonPlus {
    /**
     * 定义一个类实例的变量 用于等待调用 调用后 作为初始化对象的容器
     */
    private static LazySingletonPlus LAZY_SINGLETON_PLUS = null;
    /**
     * 构造器私有化 防止被调用重复生成实例
     */
    private LazySingletonPlus(){

    }

    /**
     * 当被调用时 如果没有被实例化 则实例化
     * 已经实例化了 直接返回
     * <br>
     * <h2>注意:</h2>
     * 这种写法的缺点就是线程安全无法保证
     * @return LAZY_SINGLETON
     */
    public static LazySingletonPlus getInstance(){
        //第一层检查  如果LAZY_SINGLETON为空
        if (LAZY_SINGLETON_PLUS==null){
            //加锁 第一个线程调用该方法的会获得一个锁 这个锁为悲观锁 保证只有一个线程进入
            //假设有线程A和线程B两个线程同时通过第一层判断，那么它们需要排队进入同步代码块，
            //假设线程A先进入同步代码块，那么实例由线程A创建，那么当线程B进入同代码块时便不能通过第二层检查，
            //即直接返回实例。这样便实现了线程安全的懒加载。
            synchronized (LazySingletonPlus.class){
                //第二层检查 此时如果实例还未被创建 则交由此处创造
                //如果这里是被别人抢先一步获得锁 这里是阻塞完毕 实例已经被先行进入锁的线程创建了
                //则这里的判断是跳出条件判断的作用 防止锁死无法跳出 导致线程阻塞.
                if (LAZY_SINGLETON_PLUS==null){
                    //最后创造实例
                    LAZY_SINGLETON_PLUS = new LazySingletonPlus();
                }
            }

        }
        //返回实例
        return LAZY_SINGLETON_PLUS;
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
