package Memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private int currentStateIndex = 0; // Index of the current state in history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        saveToHistory();
    }

    public void setOption(int optionNumber, int choice) {
        model.setOption(optionNumber, choice);
        saveToHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        model.setIsSelected(isSelected);
        saveToHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public void undo() {
        if (currentStateIndex > 0) {
            currentStateIndex--;
            IMemento previousState = history.get(currentStateIndex);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (currentStateIndex < history.size() - 1) {
            currentStateIndex++;
            IMemento nextState = history.get(currentStateIndex);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();

        if (!history.isEmpty() && currentState.equals(history.get(currentStateIndex))) {
            return;
        }

        for (int i = history.size(); i > currentStateIndex + 1; i--) {
            history.remove(i - 1);
        }

        history.add(currentState);
        currentStateIndex = history.size() - 1;

        gui.updateHistoryWindow();
    }

    public int getCurrentStateIndex() {
        return currentStateIndex;
    }
}
