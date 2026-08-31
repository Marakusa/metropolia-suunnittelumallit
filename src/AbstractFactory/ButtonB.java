package AbstractFactory;

public class ButtonB extends Button {
    @Override
    public void display() {
        int padding = 5;
        System.out.println("=".repeat(text.length() + (padding * 2 + 2)));
        System.out.println("||" + " ".repeat(padding - 1) + text + " ".repeat(padding - 1) + "||");
        System.out.println("=".repeat(text.length() + (padding * 2 + 2)));
    }
}
