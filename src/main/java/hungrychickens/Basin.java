package hungrychickens;

public class Basin
{
    private int portions;

    void fullPot() {
        portions = 15;
    }

    void eatPortion() {
        System.out.println("Порцию № : " + Integer.toString(portions) + " съел циплёнок по имени " + Thread.currentThread().getName());
        portions--;
    }

    boolean isEmpty() { return portions == 0; }

}
