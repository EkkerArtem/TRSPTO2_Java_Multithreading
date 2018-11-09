package bearandbees;

public class Bee extends Thread {

    HoneyPot pot;

    public Bee(HoneyPot pot) {
        this.pot = pot;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(pot) {
                while(pot.isFull()) {
                    try {
                        pot.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pot.addPortion();
                if (pot.isFull())
                    pot.notifyAll();
            }
        }

    }
}
