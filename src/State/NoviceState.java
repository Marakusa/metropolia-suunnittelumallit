package State;

public class NoviceState extends CharacterState {

    private static final int EXPERIENCE_TO_INTERMEDIATE = 100;
    private static final int TRAINING_EXPERIENCE = 20;

    public NoviceState(GameCharacter character) {
        super(character);
    }

    @Override
    public String getLevel() {
        return "Novice";
    }

    @Override
    public void train() {
        character.addExperience(TRAINING_EXPERIENCE);

        System.out.println("You trained successfully!");
        System.out.println("+" + TRAINING_EXPERIENCE + " experience");

        if (character.getExperience() >= EXPERIENCE_TO_INTERMEDIATE) {
            character.increaseLevel();
            character.setState(new IntermediateState(character));

            System.out.println();
            System.out.println("Congratulations!");
            System.out.println("You have reached the Intermediate level!");
        }
    }

    @Override
    public void showAvailableActions() {
        System.out.println("Available actions:");
        System.out.println("- train");
    }
}
