package AbstractFactory;

public class ButtonA extends Button {
    @Override
    public void display() {
        int padding = 5;
        System.out.println("-".repeat(text.length() + (padding * 2 + 2)));
        System.out.println("|" + " ".repeat(padding) + text + " ".repeat(padding) + "|");
        System.out.println("-".repeat(text.length() + (padding * 2 + 2)));
    }
}
