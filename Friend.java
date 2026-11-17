
import java.util.Random;

public class Friend extends ConcreteObserver {
    private String name;
    private UI ui;
    private Random r = new Random();

    public Friend(String name, UI ui, Subject subject) {
        super(subject);
        this.name = name;
        this.ui = ui;
    }

    public void update(int energy) {
        if (r.nextBoolean()) { // 50% chance
            ui.print(name + " says: Eren, please be safe!");
            if (energy < 20) {
                ui.print(name + " says: Rage, rage against the dying of the light");
            }
        }
    }
}
