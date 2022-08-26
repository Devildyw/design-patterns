package top.devildyw.BridgeDesignPattern.RefinedAbstraction;

import top.devildyw.BridgeDesignPattern.Abstraction.Image;
import top.devildyw.BridgeDesignPattern.Implementator.OSImpl;
import top.devildyw.BridgeDesignPattern.Matrix;

/**
 * @author Devil
 * @since 2022-08-26-15:39
 * <p>
 * 扩充抽象类
 * <p>
 * 实现了抽象类中定义的抽象方法 并且可以调用实现类接口的方法
 * <p>
 * 在画笔案例中 充当沾上色彩的毛笔角色
 */
public class BMPImage extends Image {

    public BMPImage(OSImpl osImpl) {
        super(osImpl);
    }

    @Override
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获取一个像素矩阵对象 m
        Matrix matrix = new Matrix();
        osImpl.doPaint(matrix);
        System.out.println(fileName + ", 格式为BMP.");
    }
}
