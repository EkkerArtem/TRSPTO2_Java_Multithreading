package hungrychickens;

public class MotherChicken extends Thread {
    Basin pot;

    public MotherChicken(Basin pot) { this.pot = pot; }

    public void run() {
        while(true) {
            synchronized(pot) {
                while(!pot.isEmpty()) {
                    try {
                        pot.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("Мама заполнила миску кормом.");
                pot.fullPot();
                pot.notifyAll();
            }
        }

    }
}
