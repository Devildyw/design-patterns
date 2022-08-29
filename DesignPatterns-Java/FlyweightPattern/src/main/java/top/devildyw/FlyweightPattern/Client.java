package top.devildyw.FlyweightPattern;

import top.devildyw.FlyweightPattern.ConcreteFlyweight.Circle;
import top.devildyw.FlyweightPattern.FlyweightFactory.ShapeFactory;

/**
 * @author Devil
 * @since 2022-08-29-12:49
 * <p>
 * 客户端
 * <p>
 * 测试
 */
public class Client {
    private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    /**
     * 获取随机颜色
     * @return String
     */
    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    /**
     * 获取随机x坐标
     * @return int
     */
    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    /**
     * 获取随机y坐标
     * @return int
     */
    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
