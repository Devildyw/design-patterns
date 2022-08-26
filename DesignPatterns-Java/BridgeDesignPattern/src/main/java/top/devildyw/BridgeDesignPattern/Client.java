package top.devildyw.BridgeDesignPattern;

import org.junit.Test;
import top.devildyw.BridgeDesignPattern.Abstraction.Image;
import top.devildyw.BridgeDesignPattern.ConcreteImplementor.LinuxImpl;
import top.devildyw.BridgeDesignPattern.ConcreteImplementor.WindowImpl;
import top.devildyw.BridgeDesignPattern.Implementator.OSImpl;
import top.devildyw.BridgeDesignPattern.RefinedAbstraction.BMPImage;
import top.devildyw.BridgeDesignPattern.RefinedAbstraction.GIFImage;
import top.devildyw.BridgeDesignPattern.RefinedAbstraction.PNGImage;

/**
 * @author Devil
 * @since 2022-08-26-15:59
 *
 * 测试类
 */
public class Client {
    public static void main(String[] args) {
        Image image;
        image = new GIFImage(new WindowImpl());
        image.parseFile("这是一个文件");
        System.out.println("--------------------------------------------");
        image = new PNGImage(new LinuxImpl());
        image.parseFile("这是一个文件");


    }
}
