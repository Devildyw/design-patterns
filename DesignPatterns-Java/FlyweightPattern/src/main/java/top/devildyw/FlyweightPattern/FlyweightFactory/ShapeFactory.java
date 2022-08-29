package top.devildyw.FlyweightPattern.FlyweightFactory;

import top.devildyw.FlyweightPattern.ConcreteFlyweight.Circle;
import top.devildyw.FlyweightPattern.Flyweight.Shape;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-08-29-12:59
 *
 * 享元工厂类
 */
public class ShapeFactory {
    //创建一个缓存池
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    /**
     * 获取对象
     * @param color 颜色
     * @return Shape
     */
    public static Shape getCircle(String color){
        //从缓存池中获取 防止每次都生成新的对象导致内存中对象数量太多(节约内存空间)
        Circle circle = (Circle) circleMap.get(color);

        //如果缓冲池中没有 才去创建新的对象 并且将创建好的对象加入缓存池中
        if (circle == null){
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
