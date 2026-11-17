import java.util.Random;

public class Titan extends ConcreteObserver {
    private String name;
    private UI ui;
    private Random r = new Random();

    public Titan(String name, UI ui, Subject subject) {
        super(subject);
        this.name = name;
        this.ui = ui;
    }

    public void update(int energy) {
        if (r.nextBoolean()) { // 50% chance
            ui.print(name + " attacks Eren!");
            if (energy > 40) {
                ui.print(name + " says: Now we got problems, and I don't think we can solve 'em");
            }
        }
    }
}
