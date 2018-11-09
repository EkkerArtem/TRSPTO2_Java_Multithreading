package bearandbees;

public class HoneyPot
{
    private int potSize;
    private int portions;

    public HoneyPot(int potSize)
    {
        this.potSize = potSize;
    }

    void emptyPot() {
        portions = 0;
        System.out.println(Integer.toString(portions));
    }

    void addPortion() {
        portions++;
        System.out.println(Integer.toString(portions) + " принесла пчела по имени " + Thread.currentThread().getName());
    }

    boolean isFull() { return potSize == portions; }

}
