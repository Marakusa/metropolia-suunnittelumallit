package State;

public class ExpertState extends CharacterState {

    private static final int EXPERIENCE_TO_MASTER = 500;
    private static final int TRAINING_EXPERIENCE = 20;
    private static final int FIGHT_EXPERIENCE = 50;
    private static final int FIGHT_HEALTH_COST = 20;
    private static final int MEDITATION_HEALTH = 20;

    public ExpertState(GameCharacter character) {
        super(character);
    }

    @Override
    public String getLevel() {
        return "Expert";
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

    @Override
    public void fight() {
        if (character.getHealth() <= 0) {
            System.out.println("You are too exhausted to fight.");
            return;
        }

        character.removeHealth(FIGHT_HEALTH_COST);
        character.addExperience(FIGHT_EXPERIENCE);

        System.out.println("You fought bravely!");
        System.out.println("-" + FIGHT_HEALTH_COST + " health");
        System.out.println("+" + FIGHT_EXPERIENCE + " experience");

        checkLevelUp();
    }

    private void checkLevelUp() {
        if (character.getExperience() >= EXPERIENCE_TO_MASTER) {
            character.increaseLevel();
            character.setState(new MasterState(character));

            System.out.println();
            System.out.println("Congratulations!");
            System.out.println("You have reached the Master level!");
        }
    }

    @Override
    public void showAvailableActions() {
        System.out.println("Available actions:");
        System.out.println("- train");
        System.out.println("- meditate");
        System.out.println("- fight");
    }
}
