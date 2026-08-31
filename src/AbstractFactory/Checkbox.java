package AbstractFactory;

public abstract class Checkbox {
    public String text;

    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}
