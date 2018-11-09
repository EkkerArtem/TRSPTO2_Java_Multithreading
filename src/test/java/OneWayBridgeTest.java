import onewaybridge.Bridge;
import onewaybridge.Vehicle;

import java.util.concurrent.TimeUnit;

public class OneWayBridgeTest {
    public static void main(String[] args) {
        final Bridge bridge = new Bridge();  //constructs bridge calls semaphore from bridge
        //constructs South bound running thread
//method that is implemented in a Runnable interface
        Thread South = new Thread(() -> {
            while (true) {
                Vehicle vehicle = new Vehicle(bridge);  //constructs new vehicle from Vehicle class, sets to vehicle and uses bridge parameter
                Thread a = new Thread(vehicle);  //vehicle object becomes thread object
                vehicle.setName("Машина с юга: " + a.getId());  //sets vehicle name to South Vehicle and gets the thread ID
                a.start();  //starts the thread
                try  //try catch block
                {    //performs a Thread sleep for a given time
                    TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                } catch (InterruptedException iex) {  //prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
                    iex.printStackTrace();
                }
            }
        });
        Thread North = new Thread(new Runnable() //constructs North bound running thread
        {
            @Override
            public void run()//method that is implemented in a Runnable interface
            {
                while (true) {
                    Vehicle vehicle = new Vehicle(bridge);  //constructs new vehicle from Vehicle class, sets to vehicle and uses bridge parameter
                    Thread a = new Thread(vehicle);  //vehicle object becomes thread object
                    vehicle.setName("Машина с севера:  " + a.getId());  //sets vehicle name to North Vehicle and gets the thread ID
                    a.start();  //starts thread
                    try {   //performs a Thread sleep for a given time
                        TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                    } catch (InterruptedException iex) {  //prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
                        iex.printStackTrace();
                    }
                }
            }
        });
        South.start();  //starts south thread
        North.start();  //starts north thread
    }
}


