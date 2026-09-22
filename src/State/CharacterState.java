package State;

public abstract class CharacterState {

    protected GameCharacter character;

    public CharacterState(GameCharacter character) {
        this.character = character;
    }

    public abstract String getLevel();

    public abstract void train();

    public void meditate() {
        System.out.println("Meditating is not available at the " + getLevel() + " level.");
    }

    public void fight() {
        System.out.println("Fighting is not available at the " + getLevel() + " level.");
    }

    public void showAvailableActions() {
        System.out.println("Available actions:");
        System.out.println("- train");
    }
}
