package onewaybridge;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Bridge {
    private final Semaphore semaphore;  //calls Semaphore from Java.lang.*.  Semaphore guards against entry by more than N threads at a time.  Sends signals between two threads.

    public Bridge() {
        semaphore = new Semaphore(1);  //Constructs the semaphore. The semaphore controls access.  Allows
    }

    public void crossBridge(Vehicle vehicle) {
        try {
            System.out.printf("%s ЖДЁТ своей очереди на мост.\n", vehicle.getName());  //takes next argument and prints to string
            semaphore.acquire();  //Acquire is ued when sending signals between two threads.  It acquires a permit and blocks until permit is released.
            System.out.printf("%s ПЕРЕЕЗЖАЕТ мост.\n", vehicle.getName());  //takes next argument and prints to string
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException iex) {   //prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
            iex.printStackTrace();
        } finally {
            System.out.printf("%s ПЕРЕЕХАЛА мост.\n", vehicle.getName());  //takes next argument and prints to string
            semaphore.release();  //permit is released
        }
    }


}