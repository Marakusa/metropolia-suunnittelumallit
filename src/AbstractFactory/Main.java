package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        Button buttonA = factoryA.createButton("Button A");
        buttonA.display();

        System.out.println();

        TextField textFieldA = factoryA.createTextField("Write here...");
        textFieldA.display();

        System.out.println();

        Checkbox checkboxA = factoryA.createCheckbox("Toggle on?");
        checkboxA.display();

        System.out.println();

        UIFactory factoryB = new BFactory();
        Button buttonB = factoryB.createButton("Button B");
        buttonB.display();

        System.out.println();

        TextField textFieldB = factoryB.createTextField("Write more here...");
        textFieldB.display();

        System.out.println();

        Checkbox checkboxB = factoryB.createCheckbox("Yes?");
        checkboxB.display();
    }
}
