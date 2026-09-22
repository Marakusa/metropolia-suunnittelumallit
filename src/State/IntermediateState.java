package State;

public class IntermediateState extends CharacterState {

    private static final int EXPERIENCE_TO_EXPERT = 250;
    private static final int TRAINING_EXPERIENCE = 20;
    private static final int MEDITATION_HEALTH = 20;

    public IntermediateState(GameCharacter character) {
        super(character);
    }

    @Override
    public String getLevel() {
        return "Intermediate";
    }

    @Override
    public void train() {
        character.addExperience(TRAINING_EXPERIENCE);

        System.out.println("You trained successfully!");
        System.out.println("+" + TRAINING_EXPERIENCE + " experience");

        checkLevelUp();
    }

    @Override
    public void meditate() {
        character.addHealth(MEDITATION_HEALTH);

        System.out.println("You meditated peacefully.");
        System.out.println("+" + MEDITATION_HEALTH + " health");
    }

    private void checkLevelUp() {
        if (character.getExperience() >= EXPERIENCE_TO_EXPERT) {
            character.increaseLevel();
            character.setState(new ExpertState(character));

            System.out.println();
            System.out.println("Congratulations!");
            System.out.println("You have reached the Expert level!");
        }
    }

    @Override
    public void showAvailableActions() {
        System.out.println("Available actions:");
        System.out.println("- train");
        System.out.println("- meditate");
    }
}
