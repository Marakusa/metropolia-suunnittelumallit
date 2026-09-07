package Observer;

public class Observer {
    private final String name;

    public Observer(String name) {
        this.name = name;
    }

    public void update(double temperature) {
        System.out.println("[" + name + "] Temperature updated: " + temperature);
    }
}
