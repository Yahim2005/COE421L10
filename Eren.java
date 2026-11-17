
import java.util.Random;

public class Eren extends ConcreteSubject implements Runnable {
    private int energy;
    private UI ui;
    private Random r = new Random();

    public Eren(int energy, UI ui) {
        this.energy = energy;
        this.ui = ui;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        while (energy > 0) {
            try {
                // wait a random number of seconds between 5 and 10
                Thread.sleep((5 + r.nextInt(6)) * 1000);

                // transform: lose 5 energy, then tell everyone watching
                energy -= 5;
                ui.print("Eren transforms into a Titan! (energy: " + energy + ")");
                notifyObservers(energy);

                // stays a titan for 10 seconds
                Thread.sleep(10000);
                ui.print("Eren turns back into a human.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ui.print("Eren has no energy left.");
    }
}