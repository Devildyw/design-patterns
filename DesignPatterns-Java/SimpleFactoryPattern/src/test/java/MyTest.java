import com.dyw.simpleFactoryPattern.factory.VehiclesGenerator;
import com.dyw.simpleFactoryPattern.product.Airplane;
import com.dyw.simpleFactoryPattern.product.Train;
import com.dyw.simpleFactoryPattern.product.Vehicles;
import org.junit.Test;

/**
 * @author Devil
 * @date 2022-04-16-20:56
 *
 * 测试
 */
public class MyTest {
    @Test
    public void doTest(){
        Airplane airplane = (Airplane) VehiclesGenerator.getAirplaneInstance();
        Train train = VehiclesGenerator.getTrainInstance();
        airplane.work();
        airplane.landing();
        System.out.println("==========================================");
        train.work();
        train.switchTrack();

    }
}
