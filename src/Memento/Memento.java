package Memento;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        System.out.println("Memento created");
    }

    public long getId() {
        return id;
    }

    public int[] getOptions() {
        return options.clone(); // Return a copy of the options array
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Memento)) return false;

        Memento other = (Memento) obj;
        if (this.isSelected != other.isSelected) return false;
        if (this.options == null || other.options == null) return this.options == other.options;
        if (this.options.length != other.options.length) return false;

        for (int i = 0; i < this.options.length; i++) {
            if (this.options[i] != other.options[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Boolean.hashCode(isSelected);
        for (int value : options) {
            result = 31 * result + value;
        }
        return result;
    }
}
