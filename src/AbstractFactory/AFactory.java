package AbstractFactory;

public class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        Button button = new ButtonA();
        button.setText(text);
        return button;
    }

    @Override
    public TextField createTextField(String text) {
        TextField textField = new TextFieldA();
        textField.setText(text);
        return textField;
    }

    @Override
    public Checkbox createCheckbox(String text) {
        Checkbox checkbox = new CheckboxA();
        checkbox.setText(text);
        return checkbox;
    }
}
