package AbstractFactory;

public class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        Button button = new ButtonB();
        button.setText(text);
        return button;
    }

    @Override
    public TextField createTextField(String text) {
        TextField textField = new TextFieldB();
        textField.setText(text);
        return textField;
    }

    @Override
    public Checkbox createCheckbox(String text) {
        Checkbox checkbox = new CheckboxB();
        checkbox.setText(text);
        return checkbox;
    }
}
