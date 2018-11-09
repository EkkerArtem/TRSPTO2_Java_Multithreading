package bearandbees;

public class Bear extends Thread {
    HoneyPot pot;

    public Bear(HoneyPot pot) { this.pot = pot; }

    public void run() {
        while(true) {
            synchronized(pot) {
                while(!pot.isFull()) {
                    try {
                        pot.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Медведь проснулся");
                pot.emptyPot();
                pot.notifyAll();
            }
        }

    }
}
