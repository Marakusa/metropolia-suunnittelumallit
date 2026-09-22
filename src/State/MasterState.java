package State;

public class MasterState extends CharacterState {

    public MasterState(GameCharacter character) {
        super(character);
    }

    @Override
    public String getLevel() {
        return "Master";
    }

    @Override
    public void train() {
        System.out.println("You have already mastered your training.");
    }

    @Override
    public void meditate() {
        System.out.println("You have already mastered meditation.");
    }

    @Override
    public void fight() {
        System.out.println("You have already mastered combat.");
    }

    @Override
    public void showAvailableActions() {
        System.out.println("The character has reached the Master level.");
        System.out.println("The game is complete!");
    }
}
