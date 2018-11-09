package hungrychickens;

public class Chicken extends Thread {

    Basin pot;

    public Chicken(Basin pot) {
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
                while(pot.isEmpty()) {
                    try {
                        pot.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pot.eatPortion();
                if (pot.isEmpty())
                    pot.notifyAll();
            }
        }

    }
}
