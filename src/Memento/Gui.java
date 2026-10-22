package Memento;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private Stage historyStage;
    private VBox historyContent;
    private final HashMap<Integer, Label> historyLabels = new HashMap<>();

    private void openHistoryWindow(Stage ownerStage) {
        if (historyStage == null || !historyStage.isShowing()) {
            historyStage = new Stage();
            historyStage.setTitle("History");
            historyStage.setScene(new Scene(new StackPane(), 220, 300));
            historyStage.setX(ownerStage.getX() + ownerStage.getWidth() + 20);
            historyStage.setY(ownerStage.getY());
            historyStage.setOnCloseRequest(event -> historyStage = null);

            historyContent = new VBox(5);
            historyContent.setPadding(new Insets(10));
            historyStage.setScene(new Scene(historyContent, 220, 300));
            historyStage.show();
            updateHistoryWindow();
        } else {
            historyStage.toFront();
        }
    }

    public void start(Stage stage) {
        controller = new Controller(this);

        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);
        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        Label label = new Label("Press Ctrl-Z to undo and Ctrl-Y to redo the last change.");
        label.setPadding(insets);

        Button openHistoryButton = new Button("Open History");
        openHistoryButton.setOnAction(event -> openHistoryWindow(stage));

        VBox vBox = new VBox(hBox, checkBox, label, openHistoryButton);
        checkBox.setOnAction(event -> controller.setIsSelected(checkBox.isSelected()));

        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                controller.redo();
            }
        });

        stage.setOnCloseRequest(event -> {
            if (historyStage != null) {
                historyStage.close();
            }
            Platform.exit();
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();

        openHistoryWindow(stage);
    }

    public void updateGui() {
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
        updateHistoryWindow();
    }

    public void updateHistoryWindow() {
        if (historyStage == null || historyContent == null) {
            return;
        }

        historyContent.getChildren().clear();
        historyLabels.clear();

        List<IMemento> history = controller.getHistory();
        for (int i = 0; i < history.size(); i++) {
            Memento memento = (Memento) history.get(i);
            String stateText = memento.getOptions()[0] + " " + memento.getOptions()[1] + " " + memento.getOptions()[2] + " | Selected: " + memento.isSelected();
            Label label = new Label(stateText);
            if (i == controller.getCurrentStateIndex()) {
                label.setStyle("-fx-font-weight: bold; -fx-text-fill: #0000aa;");
            }
            historyContent.getChildren().add(label);
            historyLabels.put(i, label);
        }

        if (historyContent.getChildren().isEmpty()) {
            historyContent.getChildren().add(new Label("No history yet"));
        }
    }
}
