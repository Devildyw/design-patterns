package top.devildyw.BridgeDesignPattern.RefinedAbstraction;

import top.devildyw.BridgeDesignPattern.Abstraction.Image;
import top.devildyw.BridgeDesignPattern.Implementator.OSImpl;
import top.devildyw.BridgeDesignPattern.Matrix;

/**
 * @author Devil
 * @since 2022-08-26-15:50
 */
public class JPGImage extends Image {
    public JPGImage(OSImpl osImpl) {
        super(osImpl);
    }

    @Override
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获取一个像素矩阵对象 m
        Matrix matrix = new Matrix();
        osImpl.doPaint(matrix);
        System.out.println(fileName+", 格式为JPG.");
    }
}
