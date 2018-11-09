import hungrychickens.MotherChicken;
import hungrychickens.Chicken;
import hungrychickens.Basin;
import org.junit.Test;

public class HungryChickensTest {
    static int numberOfThreads = 3;

    @Test
    public void test() throws InterruptedException {
        Basin basin = new Basin();
        MotherChicken motherChicken = new MotherChicken(basin);
        motherChicken.start();

        for(int i = 0; i< numberOfThreads; i++)
        {
            Chicken chicken = new Chicken(basin);
            chicken.start();
            String id = chicken.getName();
            System.out.println("Ципленок : " + id + " готов кушать");
        }

        motherChicken.join();
    }
}
