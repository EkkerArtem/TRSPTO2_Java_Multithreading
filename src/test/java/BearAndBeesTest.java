import bearandbees.Bear;
import bearandbees.Bee;
import bearandbees.HoneyPot;
import org.junit.Test;

public class BearAndBeesTest {
    static int portionSize = 20;
    static int numberOfThreads = 3;

    @Test
    public void test() throws InterruptedException {
        HoneyPot pot = new HoneyPot(portionSize);
        Bear bear = new Bear(pot);
        bear.start();
        for(int i = 0; i< numberOfThreads; i++)
        {
            Bee bee = new Bee(pot);
            bee.start();
            String id = bee.getName();
            System.out.println("Пчела : " + id + " в работе");
        }

        bear.join();
    }
}

