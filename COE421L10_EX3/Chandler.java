
import java.util.Random;

public class Chandler implements Runnable {
    private Humor humor;
    private Random r = new Random();

    public Chandler() {
        humor = new SarcasmHumor(); // default humor technique
        Thread t = new Thread(this);
        t.start();
    }

    public void setHumor(Humor humor) {
        this.humor = humor;
    }

    public void performHumor() {
        humor.execute();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(3000); // every 3 seconds

                // randomly select a humor technique
                int choice = r.nextInt(3);
                if (choice == 0) {
                    setHumor(new SarcasmHumor());
                } else if (choice == 1) {
                    setHumor(new WitHumor());
                } else {
                    setHumor(new SelfDeprecationHumor());
                }

                performHumor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
