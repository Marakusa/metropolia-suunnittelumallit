package AbstractFactory;

public class TextFieldA extends TextField {
    @Override
    public void display() {
        int width = 20;
        String paddedText = text.length() > width ? text.substring(0, width) : text + " ".repeat(width - text.length());
        System.out.println("-".repeat(width + 2));
        System.out.println("[" + paddedText + "]");
        System.out.println("-".repeat(width + 2));
    }
}
