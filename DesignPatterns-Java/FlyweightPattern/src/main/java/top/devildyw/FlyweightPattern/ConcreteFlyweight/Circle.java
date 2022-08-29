package top.devildyw.FlyweightPattern.ConcreteFlyweight;

import top.devildyw.FlyweightPattern.Flyweight.Shape;

/**
 * @author Devil
 * @since 2022-08-29-12:55
 *
 * 具体享元类 圆
 */
public class Circle implements Shape {
    //颜色
    private String color;

    //x坐标
    private int x;

    //y坐标
    private int y;

    //半径
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw()[" +
                "color='" + color + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ']');
    }
}
