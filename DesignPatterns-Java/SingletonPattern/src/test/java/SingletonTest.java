import com.dyw.SingletonPattern.hungry.HungrySingleton;
import com.dyw.SingletonPattern.lazy.LazySingleton;
import com.dyw.SingletonPattern.lazy.LazySingletonPlus;
import org.junit.Test;

/**
 * @author Devil
 * @date 2022-04-28-0:43
 */

public class SingletonTest {
    @Test
    public void doTest(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //饿汉式
        HungrySingleton instance = HungrySingleton.getInstance();
        instance.print(array);
        HungrySingleton instance3 = HungrySingleton.getInstance();
        System.out.println(instance==instance3);
        System.out.println("=======================================");
        //普通懒汉式
        LazySingleton instance1 = LazySingleton.getInstance();
        instance1.print(array);
        LazySingleton instance4 = LazySingleton.getInstance();
        System.out.println(instance1==instance4);
        System.out.println("=======================================");
        //改良懒汉式
        LazySingletonPlus instance2 = LazySingletonPlus.getInstance();
        instance2.print(array);
        LazySingletonPlus instance5 = LazySingletonPlus.getInstance();
        System.out.println(instance2==instance5);
    }
}
