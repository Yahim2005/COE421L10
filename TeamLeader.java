
public class TeamLeader extends ConcreteObserver {
    private String name;
    private int patience;
    private UI ui;

    public TeamLeader(String name, int patience, UI ui, Subject subject) {
        super(subject);
        this.name = name;
        this.patience = patience;
        this.ui = ui;
    }

    public void update(int energy) {
        if (patience <= 0) {
            return; // already out of patience, nothing more to print
        }
        patience -= 5;
        if (patience == 10) {
            ui.print(name + " says: My patience is waning!");
        } else if (patience == 5) {
            ui.print(name + " says: Is this entertaining?");
        } else if (patience == 0) {
            ui.print(name + " says: Omae wa mou shindeiru");
        }
    }
}
